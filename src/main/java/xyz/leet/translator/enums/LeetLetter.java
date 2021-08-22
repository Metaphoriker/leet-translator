package xyz.leet.translator.enums;

import java.util.function.Predicate;

public enum LeetLetter {

    A("4", "4"),
    B("8", "8"),
    C("C", "|="),
    D("D", "|>"),
    E("3", "3"),
    F("F", "|="),
    G("9", "9"),
    H("H", "|-|"),
    I("1", "1"),
    J("J", "_|"),
    K("K", "|<"),
    L("1", "1"),
    M("M", "|//|"),
    N("N", "|/|"),
    O("0", "O"),
    P("P", "|*"),
    Q("Q", "Q"),
    R("2", "|\\"),
    S("5", "5"),
    T("7", "7"),
    U("U", "|_|"),
    V("V", "\\/"),
    W("W", "\\/\\/"),
    X("X", "X"),
    Y("Y", "\\|/"),
    Z("2", "2"),
    DEFAULT("", "");

    public static LeetLetter fromLetter(String letter) {
        return getLeetLetterByPredicate(leetLetter -> leetLetter.name().equals(letter.toUpperCase()));
    }

    public static LeetLetter fromLeet(String leet) {
        return getLeetLetterByPredicate(leetLetter -> leetLetter.levelOne.equalsIgnoreCase(leet) || leetLetter.levelTwo.equalsIgnoreCase(leet));
    }

    public static boolean match(String s) {
        return fromLeet(s) != DEFAULT;
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

    private final String levelOne, levelTwo;

    LeetLetter(String levelOne, String levelTwo) {

        this.levelOne = levelOne;
        this.levelTwo = levelTwo;
    }

    public String getLetter() {
        return this.name();
    }

    public String getLeet(LeetLevel leetLevel) {
        return leetLevel == LeetLevel.NUMBERS ? levelOne : levelTwo;
    }
}
