package xyz.leet.translator;

import xyz.leet.translator.enums.LeetLetter;
import xyz.leet.translator.enums.LeetLevel;

import java.util.Optional;

public class LeetTranslator {

    public String toLeet(String normal, LeetLevel leetLevel) {

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i != normal.length(); i++)
            builder.append(getLeetLetter(normal, i, leetLevel));
        return addEncryptionCode(builder.toString(), leetLevel);
    }

    private String getLeetLetter(String s, int index, LeetLevel leetLevel) {

        String current = String.valueOf(s.charAt(index));

        if(Character.isAlphabetic(s.charAt(index)))
            return LeetLetter.fromLetter(current).getLeet(leetLevel);
        return current;
    }

    //TODO
    public String toNormal(String leet) {

        StringBuilder builder = new StringBuilder();

        String[] leetWords = leet.split(" ");

        for (String word : leetWords) {

            StringBuilder translatedWord = new StringBuilder();

            int evaluated = word.length();
            int loopsToSkip = 0;

            for(int i = word.length() -1; i != -1; i--) {

                if (loopsToSkip != 0) {
                    evaluated += 1;
                    loopsToSkip -= 1;
                    continue;
                }

                String currentString = word.substring(i, evaluated);
                if (currentString.equalsIgnoreCase(",") || currentString.equalsIgnoreCase(".")) {
                    translatedWord.insert(0, currentString);
                    evaluated = i;
                    continue;
                }
                LeetLetter fromLeet = LeetLetter.fromLeet(currentString);

                if (fromLeet != LeetLetter.DEFAULT) {
                    String letter = fromLeet.name();

                    try {
                        if (letter.equalsIgnoreCase("V")) {

                                if (LeetLetter.fromLeet(word.substring(i - 2, evaluated)).name().equalsIgnoreCase("W")) {
                                    letter = "W";
                                    loopsToSkip += 2;
                                }
                                if (LeetLetter.fromLeet(word.substring(i - 1, evaluated)).name().equalsIgnoreCase("N")) {
                                    letter = "N";
                                    loopsToSkip += 1;
                                }

                        }else if (letter.equalsIgnoreCase("I")) {

                                String substring = word.substring(i - 1, evaluated - 1);
                                if (LeetLetter.fromLeet(substring).name().equalsIgnoreCase("I")) letter = "L";

                        }
                    }catch (StringIndexOutOfBoundsException ignored) {}

                    translatedWord.insert(0, letter);
                    evaluated = i;
                }
            }
            builder.append(translatedWord).append(" ");
        }
        return builder.toString();
    }

    private String addEncryptionCode(String s, LeetLevel leetLevel) {
        return s + leetLevel.getEncryptionCode();
    }

    private Optional<LeetLevel> getEncryption(String s) {

        for(LeetLevel leetLevel : LeetLevel.values()) {

            if(s.endsWith(leetLevel.getEncryptionCode()))
                return Optional.of(leetLevel);
        }
        return Optional.empty();
    }

}
