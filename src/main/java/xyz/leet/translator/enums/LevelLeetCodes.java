package xyz.leet.translator.enums;

import java.util.ArrayList;
import java.util.List;

public interface LevelLeetCodes {

    List<String> level1Generics = new ArrayList<>() {{
        add("4");
        add("8");
        add("C");
        add("D");
        add("3");
        add("F");
        add("9");
        add("H");
        add("1");
        add("J");
        add("K");
        add("1");
        add("M");
        add("N");
        add("0");
        add("P");
        add("Q");
        add("2");
        add("5");
        add("7");
        add("U");
        add("V");
        add("W");
        add("X");
        add("Y");
        add("2");
    }};

    List<String> level2Generics = new ArrayList<>() {{
        add("\\/\\/");
        add("|\\/|");
        add("|\\|");
        add("\\|/");
        add("(_,)");
        add("|-|");
        add("\\/");
        add("(_)");
        add("|=");
        add("[)");
        add("_|");
        add("|*");
        add("><");
        add("4");
        add("8");
        add("(");
        add("3");
        add("9");
        add("1");
        add("X");
        add("1");
        add("0");
        add("2");
        add("5");
        add("7");
        add("2");
    }};

    List<String> level3Generics = new ArrayList<>() {{
        add("|\\/|");
        add("/-\\");
        add("|\\|");
        add("(_,)");
        add("\\|/");
        add("'|'");
        add("|_|");
        add("(_+");
        add("[]");
        add("|>");
        add("/2");
        add("|)");
        add("[-");
        add("_|");
        add("|<");
        add("L_");
        add("|=");
        add("[3");
        add("|/");
        add(")(");
        add("`/");
        add("7_");
        add("(");
        add("#");
        add("!");
        add("$");
    }};

    static List<String> genericsFromLeetLevel(LeetLevel leetLevel) {
        return switch (leetLevel) {
            case LEET_LEVEL_1 -> level1Generics;
            case LEET_LEVEL_2 -> level2Generics;
            case LEET_LEVEL_3 -> level3Generics;
            case EMOJI, CAESAR_SHIFT, FUCKERY -> throw new UnsupportedOperationException("Not implemented yet");
        };
    }

}
