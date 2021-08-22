package xyz.leet.translator;

import xyz.leet.translator.enums.LeetLetter;
import xyz.leet.translator.enums.LeetLevel;

public class LeetTranslator {

    public String translate(LeetLetter letter, LeetLevel leetLevel) {

        return switch (leetLevel) {
            case NUMBERS -> letter.getLevelOne();
            case NUMBERS_AND_SYMBOLS -> letter.getLevelTwo();
        };
    }

    public LeetLetter translate(String leet) {
        return LeetLetter.fromLeet(leet);
    }

}
