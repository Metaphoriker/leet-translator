package xyz.leet.translator;

import xyz.leet.translator.enums.LeetLetter;
import xyz.leet.translator.enums.LeetLevel;

public class LeetTranslator {

    public String toLeet(String normal) {

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i != normal.length(); i++) {

            String current = String.valueOf(normal.charAt(i));
            builder.append(getLeetLetter(current, i));
        }

        return builder.toString();
    }

    private String getLeetLetter(String s, int index) {

        if(Character.isAlphabetic(s.charAt(index)))
            return LeetLetter.fromLetter(s).getLeet(LeetLevel.NUMBERS_AND_SYMBOLS); /* TODO hardcoded */
        return s;
    }

    //TODO
    public String toNormal(String leet) {

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i != leet.length(); i++) {

            String current = String.valueOf(leet.charAt(i));

            if(Character.isDigit(leet.charAt(i)))
                builder.append(LeetLetter.fromLeet(current).getLetter());
            else if(!Character.isAlphabetic(leet.charAt(i))) builder.append(" ");
        }
        return builder.toString();
    }

}
