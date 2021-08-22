package xyz.leet.translator.enums;

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
    R("R", "|\\"),
    S("5", "5"),
    T("7", "7"),
    U("U", "|_|"),
    V("V", "\\/"),
    W("W", "\\/\\/"),
    X("X", "X"),
    Y("Y", "\\|/"),
    Z("2", "2");

    public static LeetLetter fromLeet(String leet) {

        for(LeetLetter leetLetter : LeetLetter.values()) {

            if(leetLetter.levelOne.equalsIgnoreCase(leet) || leetLetter.levelTwo.equalsIgnoreCase(leet))
                return leetLetter;
        }
        return null;
    }

    private final String levelOne, levelTwo;

    LeetLetter(String levelOne, String levelTwo) {

        this.levelOne = levelOne;
        this.levelTwo = levelTwo;
    }

    public String getLevelOne() {
        return levelOne;
    }

    public String getLevelTwo() {
        return levelTwo;
    }
}
