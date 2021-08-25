package xyz.leet.translator;

import xyz.leet.translator.gui.LeetGUI;
import xyz.leet.translator.translator.LeetTranslator;
import xyz.leet.translator.translator.LeetTranslatorImpl;

public class LeetBase {

    private static final LeetTranslator LEET_TRANSLATOR = new LeetTranslatorImpl();

    public static void main(String[] args) {

        LeetGUI leetgui = new LeetGUI(LEET_TRANSLATOR);
        leetgui.buildGUI();
    }

}
