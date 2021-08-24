package xyz.leet.translator.converter;

import xyz.leet.translator.enums.Letter;

public class CaesarShiftConverter {

    /*
     * The letters in alphabetic order to be able to shift around them
     */
    private static final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * Converts the given {@param letter} to the letter at the position current+{@param shift}.
     */
    public static String convert(Letter letter, int shift) {
        return letters[correctShift(getIndexOf(letter), shift)];
    }

    /**
     * Converts the given {@param letter} to the letter at the position current-{@param shift}.
     * @see Letter#valueOf(String)
     */
    public static Letter convert(String shifted, int shift) {
        return Letter.valueOf(letters[correctBackShift(getIndexOf(Letter.valueOf(shifted.toUpperCase())), shift)]);
    }

    /*
     * Returns the index of the given letter
     */
    private static int getIndexOf(Letter letter) {

        for(int i = 0; i < letters.length-1; i++)
            if(letter.name().equals(letters[i])) return i;

        return -1;
    }

    /*
     * Returns the correct shift evaluated from current and increment.
     *
     * If the shift is higher than 25 (max. letters length) it will be 0+remaining
     */
    private static int correctShift(int current, int increment) {
        return current+increment > 25 ? current+increment-25 : current+increment;
    }

    /*
     * Returns the correct shift evaluated from current and incremet.
     *
     * If the shift is lower than 0 (min. letters length) it will be 25-remaining
     */
    private static int correctBackShift(int current, int decrement) {
        return current-decrement < 0 ? current-decrement+25 : current-decrement;
    }
}
