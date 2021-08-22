package xyz.leet.translator;

import xyz.leet.translator.enums.LeetLetter;
import xyz.leet.translator.enums.LeetLevel;

public class LeetTranslator {

    public String toLeet(String normal) {

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i != normal.length(); i++) {

            String current = String.valueOf(normal.charAt(i));

            if(!current.equals(" "))
                builder.append(LeetLetter.fromLetter(current).getLeet(LeetLevel.NUMBERS_AND_SYMBOLS));
            else builder.append(" ");
        }

        return builder.toString();
    }

    //TODO
    public String toNormal(String leet) {

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i != leet.length(); i++) {

            String current = String.valueOf(leet.charAt(i));

            if(!current.equals(" "))
                builder.append(LeetLetter.fromLeet(current));
            else builder.append(" ");
        }
        return builder.toString();
    }

}
