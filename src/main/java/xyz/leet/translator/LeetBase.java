package xyz.leet.translator;

public class LeetBase {

    public static final LeetTranslator LEET_TRANSLATOR = new LeetTranslator();

    public static void main(String[] args) {
        System.out.println(LEET_TRANSLATOR.toNormal("|=|_||=|< \\|/O|_|"));
    }

}