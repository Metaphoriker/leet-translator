package xyz.leet.translator;

import xyz.leet.translator.enums.LeetLetter;
import xyz.leet.translator.enums.LeetLevel;

public class LeetTranslator {

    public String toLeet(String normal) {

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i != normal.length(); i++)
            builder.append(getLeetLetter(normal, i));

        return builder.toString();
    }

    private String getLeetLetter(String s, int index) {

        String current = String.valueOf(s.charAt(index));

        if(Character.isAlphabetic(s.charAt(index)))
            return LeetLetter.fromLetter(current).getLeet(LeetLevel.LEET_LEVEL_2); /* TODO hardcoded */
        return current;
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
