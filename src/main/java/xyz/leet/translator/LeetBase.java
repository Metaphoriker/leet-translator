package xyz.leet.translator;

import javafx.application.Application;
import javafx.scene.control.Alert;
import xyz.leet.translator.app.LeetApp;
import xyz.leet.translator.version.UpdateChecker;

import java.util.concurrent.CompletableFuture;

public class LeetBase {

    private static final UpdateChecker UPDATE_CHECKER = new UpdateChecker();

    public static void main(String[] args) {

        Application.launch(LeetApp.class, args);

        CompletableFuture.supplyAsync(UPDATE_CHECKER::isUpdateAvailable)
            .thenAccept(result -> {

                if(result.updateAvailable()) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Update available");
                    alert.setHeaderText("http://leet-translator.xyz/");
                    alert.setContentText("Current: " + result.oldVersion() + " | Newest: " + result.newVersion());
                    alert.showAndWait();
                }
            });
    }

}
