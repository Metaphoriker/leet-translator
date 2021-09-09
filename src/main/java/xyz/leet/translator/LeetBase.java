package xyz.leet.translator;

import javafx.application.Application;
import javafx.scene.control.Alert;
import xyz.leet.translator.app.LeetApp;
import xyz.leet.translator.version.UpdateChecker;

import java.util.concurrent.CompletableFuture;

/**
 * Mighty MAIN
 */
public class LeetBase {

    public static void main(String[] args) {
        Application.launch(LeetApp.class, args);
    }

}
