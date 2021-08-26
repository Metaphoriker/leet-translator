package xyz.leet.translator.app;

import javafx.application.Application;
import javafx.stage.Stage;
import xyz.leet.translator.translator.LeetTranslator;
import xyz.leet.translator.translator.LeetTranslatorImpl;

/**
 * GUI for Leet Translator
 */
public class LeetApp extends Application {

    private static final LeetTranslator LEET_TRANSLATOR = new LeetTranslatorImpl();

    @Override
    public void start(Stage stage) {

        LeetController leetController = new LeetController(stage, LEET_TRANSLATOR);
        leetController.showTranslatorView();
    }

}
