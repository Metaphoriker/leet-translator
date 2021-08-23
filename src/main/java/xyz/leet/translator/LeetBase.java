package xyz.leet.translator;

import xyz.leet.translator.enums.LeetLevel;

public class LeetBase {

    public static final LeetTranslator LEET_TRANSLATOR = new LeetTranslator();

    public static void main(String[] args) {

        String leet = LEET_TRANSLATOR.toLeet("just get the translator or contribute to it, so you will understand what i write. GodCipher is a fucking wanker mate", LeetLevel.LEET_LEVEL_1);
        System.out.println(LEET_TRANSLATOR.toNormal(leet));
    }

}
