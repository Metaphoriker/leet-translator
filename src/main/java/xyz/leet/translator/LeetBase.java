package xyz.leet.translator;

import xyz.leet.translator.gui.LeetGUI;
import xyz.leet.translator.translator.LeetTranslator;
import xyz.leet.translator.translator.LeetTranslatorImpl;
import xyz.leet.translator.version.UpdateChecker;

import javax.swing.*;
import java.util.concurrent.CompletableFuture;

public class LeetBase {

    private static final LeetTranslator LEET_TRANSLATOR = new LeetTranslatorImpl();
    private static final UpdateChecker UPDATE_CHECKER = new UpdateChecker();

    public static void main(String[] args) {

        LeetGUI leetgui = new LeetGUI(LEET_TRANSLATOR);
        leetgui.buildGUI();

        CompletableFuture.supplyAsync(UPDATE_CHECKER::isUpdateAvailable)
            .thenAccept(b -> JOptionPane.showMessageDialog(leetgui, "An update is available \n http://leet-translator.xyz/", "Update available", JOptionPane.INFORMATION_MESSAGE));
    }

}
