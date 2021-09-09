package xyz.leet.translator.app;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import xyz.leet.translator.translator.LeetTranslator;
import xyz.leet.translator.translator.LeetTranslatorImpl;
import xyz.leet.translator.version.UpdateChecker;
import xyz.leet.translator.version.UpdateCheckerResult;

/**
 * Starter for the UI
 */
public class LeetApp extends Application {
    
    private static final LeetTranslator LEET_TRANSLATOR = new LeetTranslatorImpl();
    private static final UpdateChecker UPDATE_CHECKER = new UpdateChecker();
    
    @Override
    public void start(Stage stage) {

        LeetController leetController = new LeetController(stage, LEET_TRANSLATOR);
        leetController.showLoadingView();
    
        UpdateCheckerResult result = UPDATE_CHECKER.isUpdateAvailable();
    
        leetController.closeLatestView();
        if(result.updateAvailable()) {
        
            System.out.println("Update is Needed");
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update available");
            alert.setHeaderText("Current: " + result.oldVersion() + " | Newest: " + result.newVersion());
            alert.setContentText("http://leet-translator.xyz/");
            alert.showAndWait();
        }
    
        leetController.showTranslatorView();
    }

}
