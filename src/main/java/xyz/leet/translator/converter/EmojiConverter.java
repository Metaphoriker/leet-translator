package xyz.leet.translator.converter;

import xyz.leet.translator.enums.Letter;

import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

public class EmojiConverter {

    /*
     * This SortedMap contains every Letter with their Emoji equivalent.
     */
    private static final SortedMap<Letter, String> map = new TreeMap<>();

    static {

        map.put(Letter.ALPHABET_A, "\uD83D\uDCC8");
        map.put(Letter.ALPHABET_B, "\uD83C\uDFD6");
        map.put(Letter.ALPHABET_C, "\uD83D\uDC40");
        map.put(Letter.ALPHABET_D, "\uD83E\uDD41");
        map.put(Letter.ALPHABET_E, "\uD83D\uDC41");
        map.put(Letter.ALPHABET_F, "\uD83D\uDE28");
        map.put(Letter.ALPHABET_G, "⚙");
        map.put(Letter.ALPHABET_H, "\uD83C\uDFA9");
        map.put(Letter.ALPHABET_I, "❄");
        map.put(Letter.ALPHABET_J, "\uD83C\uDCCF");
        map.put(Letter.ALPHABET_K, "\uD83D\uDD11");
        map.put(Letter.ALPHABET_L, "♥");
        map.put(Letter.ALPHABET_M, "\uD83D\uDD0D");
        map.put(Letter.ALPHABET_N, "\uD83D\uDCDD");
        map.put(Letter.ALPHABET_O, "\uD83D\uDC19");
        map.put(Letter.ALPHABET_P, "\uD83D\uDC26");
        map.put(Letter.ALPHABET_Q, "\uD83D\uDC78");
        map.put(Letter.ALPHABET_R, "\uD83D\uDC07");
        map.put(Letter.ALPHABET_S, "\uD83D\uDD0C");
        map.put(Letter.ALPHABET_T, "\uD83D\uDE82");
        map.put(Letter.ALPHABET_U, "☂");
        map.put(Letter.ALPHABET_V, "⚱");
        map.put(Letter.ALPHABET_W, "\uD83D\uDEBA");
        map.put(Letter.ALPHABET_X, "\uD83C\uDF84");
        map.put(Letter.ALPHABET_Y, "\uD83D\uDEE5");
        map.put(Letter.ALPHABET_Z, "\uD83D\uDC05");
    }

    /**
     * Converts the given {@param letter} to the Emoji equivalent.
     */
    public static String convert(Letter letter) {
        return map.get(letter);
    }

    /**
     * Converts the given {@param s} to the Letter equivalent.
     */
    public static Optional<Letter> convert(String s) {

        for(Map.Entry<Letter, String> entry : map.entrySet()) {

            if(s.equals(entry.getValue()))
                return Optional.of(entry.getKey());
        }

        return Optional.empty();
    }

}
