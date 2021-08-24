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

        map.put(Letter.A, "\uD83D\uDCC8");
        map.put(Letter.B, "\uD83C\uDFD6");
        map.put(Letter.C, "\uD83D\uDC40");
        map.put(Letter.D, "\uD83E\uDD41");
        map.put(Letter.E, "\uD83D\uDC41");
        map.put(Letter.F, "\uD83D\uDE28");
        map.put(Letter.G, "⚙");
        map.put(Letter.H, "\uD83C\uDFA9");
        map.put(Letter.I, "❄");
        map.put(Letter.J, "\uD83C\uDCCF");
        map.put(Letter.K, "\uD83D\uDD11");
        map.put(Letter.L, "♥");
        map.put(Letter.M, "\uD83D\uDD0D");
        map.put(Letter.N, "\uD83D\uDCDD");
        map.put(Letter.O, "\uD83D\uDC19");
        map.put(Letter.P, "\uD83D\uDC26");
        map.put(Letter.Q, "\uD83D\uDC78");
        map.put(Letter.R, "\uD83D\uDC07");
        map.put(Letter.S, "\uD83D\uDD0C");
        map.put(Letter.T, "\uD83D\uDE82");
        map.put(Letter.U, "☂");
        map.put(Letter.V, "⚱");
        map.put(Letter.W, "\uD83D\uDEBA");
        map.put(Letter.X, "\uD83C\uDF84");
        map.put(Letter.Y, "\uD83D\uDEE5");
        map.put(Letter.Z, "\uD83D\uDC05");
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
