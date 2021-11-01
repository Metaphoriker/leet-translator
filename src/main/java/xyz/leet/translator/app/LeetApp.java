package xyz.leet.translator.app;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import xyz.leet.translator.converter.ConverterBundle;
import xyz.leet.translator.translator.Translator;
import xyz.leet.translator.version.UpdateChecker;
import xyz.leet.translator.version.UpdateCheckerResult;

public class LeetApp extends Application {

    private static final Translator TRANSLATOR;
    private static final UpdateChecker UPDATE_CHECKER;

    static {

        TRANSLATOR = new Translator(new ConverterBundle());
        UPDATE_CHECKER = new UpdateChecker();
    }

    @Override
    public void start(Stage stage) {

        LeetController leetController = new LeetController(stage, TRANSLATOR);
        leetController.showLoadingView();
    
        UpdateCheckerResult result = UPDATE_CHECKER.checkUpdate();
    
        leetController.closeLatestView();
        if(result.updateAvailable()) {
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update available");
            alert.setHeaderText("Current: " + result.oldVersion() + " | Newest: " + result.newVersion());
            alert.setContentText("http://leet-translator.xyz/");
            alert.showAndWait();
        }
    
        leetController.showTranslatorView();
    }

}
