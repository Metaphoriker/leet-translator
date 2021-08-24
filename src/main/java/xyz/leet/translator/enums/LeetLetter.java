package xyz.leet.translator.enums;

import java.util.*;
import java.util.function.Predicate;

public enum LeetLetter {

    A("4", "4", "/-\\","R"),
    B("8", "8", "[3","S"),
    C("C", "(", "(","T"),
    D("D", "[)", "|)","U"),
    E("3", "3", "[-","V"),
    F("F", "|=", "|=","W"),
    G("9", "9", "(_+","X"),
    H("H", "|-|", "#","Y"),
    I(":", ":", "!","Z"),
    J("J", "_|", "_|","A"),
    K("K", "K", "|<","B"),
    L("1", "1", "L_","C"),
    M("M", "|\\/|", "|\\/|","D"),
    N("N", "|\\|", "|\\|","E"),
    O("0", "0", "[]","F"),
    P("P", "|*", "|>","G"),
    Q("Q", "(_,)", "(_,)","H"),
    R("!2", "|2", "/2","I"),
    S("5", "5", "$","J"),
    T("7", "7", "'|'","K"),
    U("U", "(_)", "|_|","L"),
    V("V", "\\/", "|/","M"),
    W("W", "\\/\\/", "\\|/","N"),
    X("X", "><", ")(","O"),
    Y("Y", "\\`", "`/","P"),
    Z("2", "2", "7_","Q"),
    DEFAULT(" ", " ", " "," ");

    public static LeetLetter fromLetter(String letter) {
        return getLeetLetterByPredicate(leetLetter -> leetLetter.name().equals(letter.toUpperCase()));
    }

    public static LeetLetter fromLeet(String leet) {
        return getLeetLetterByPredicate(leetLetter -> leetLetter.levelOne.equalsIgnoreCase(leet) || leetLetter.levelTwo.equalsIgnoreCase(leet) || leetLetter.levelThree.equalsIgnoreCase(leet) || leetLetter.caesarShift.equalsIgnoreCase(leet));
    }

    public static boolean match(String s) {
        return fromLeet(s) != DEFAULT;
    }

    public static List<String> getLeetFillers(LeetLevel leetLevel) {

        List<String> generics = new ArrayList<>();

        for (LeetLetter value : LeetLetter.values()) {

            if (value == LeetLetter.DEFAULT) continue;
            generics.add(value.getLeet(leetLevel));
        }
        generics.sort((string1, string2) -> string2.length() - string1.length());

        return generics;
    }

    /*
    Probably not the best name for a damn method tho
     */
    private static LeetLetter getLeetLetterByPredicate(Predicate<LeetLetter> predicate) {

        for(LeetLetter letter : LeetLetter.values()) {

            if(predicate.test(letter))
                return letter;
        }
        return DEFAULT;
    }

    private final String levelOne, levelTwo, levelThree, caesarShift;

    LeetLetter(String levelOne, String levelTwo, String levelThree, String caesarShift) {

        this.levelOne = levelOne;
        this.levelTwo = levelTwo;
        this.levelThree = levelThree;
        this.caesarShift = caesarShift;
    }

    public String getLetter() {
        return this.name();
    }

    public String getLeet(LeetLevel leetLevel) {

        return switch (leetLevel) {

            case LEET_LEVEL_1 -> levelOne;
            case LEET_LEVEL_2 -> levelTwo;
            case LEET_LEVEL_3 -> levelThree;
            case CAESAR_SHIFT -> caesarShift;
            case DISCORD_EMOJI, FUCKERY -> throw new UnsupportedOperationException("Not implemented yet");
        };
    }

}
