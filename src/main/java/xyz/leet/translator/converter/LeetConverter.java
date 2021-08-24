package xyz.leet.translator.converter;

import xyz.leet.translator.enums.Letter;

import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

public class LeetConverter {

    /*
     * This SortedMap contains every Letter with their 3 Leet equivalents.
     *
     * There are no null values and the length of the Array is fixed at 3.
     */
    private static final SortedMap<Letter, String[]> map = new TreeMap<>();

    static {

        map.put(Letter.ALPHABET_A, new String[]{"4", "4", "/-\\"});
        map.put(Letter.ALPHABET_B, new String[]{"8", "8", "[3"});
        map.put(Letter.ALPHABET_C, new String[]{"C", "(", "("});
        map.put(Letter.ALPHABET_D, new String[]{"D", "[)", "|)"});
        map.put(Letter.ALPHABET_E, new String[]{"3", "3", "[-"});
        map.put(Letter.ALPHABET_F, new String[]{"F", "|=", "|="});
        map.put(Letter.ALPHABET_G, new String[]{"9", "9", "(_+"});
        map.put(Letter.ALPHABET_H, new String[]{"H", "|-|", "#"});
        map.put(Letter.ALPHABET_I, new String[]{":", ":", "!"});
        map.put(Letter.ALPHABET_J, new String[]{"J", "_|", "_|"});
        map.put(Letter.ALPHABET_K, new String[]{"K", "K", "|<"});
        map.put(Letter.ALPHABET_L, new String[]{"1", "1", "L_"});
        map.put(Letter.ALPHABET_M, new String[]{"M", "|\\/|", "|\\/|"});
        map.put(Letter.ALPHABET_N, new String[]{"N", "|\\|", "|\\|"});
        map.put(Letter.ALPHABET_O, new String[]{"0", "0", "[]"});
        map.put(Letter.ALPHABET_P, new String[]{"P", "|*", "|>"});
        map.put(Letter.ALPHABET_Q, new String[]{"Q", "(_,)", "(_,)"});
        map.put(Letter.ALPHABET_R, new String[]{"!2", "|2", "/2"});
        map.put(Letter.ALPHABET_S, new String[]{"5", "5", "$"});
        map.put(Letter.ALPHABET_T, new String[]{"7", "7", "'|'"});
        map.put(Letter.ALPHABET_U, new String[]{"U", "(_)", "|_|"});
        map.put(Letter.ALPHABET_V, new String[]{"V", "\\/", "|/"});
        map.put(Letter.ALPHABET_W, new String[]{"W", "\\/\\/", "\\|/"});
        map.put(Letter.ALPHABET_X, new String[]{"X", "><", ")("});
        map.put(Letter.ALPHABET_Y, new String[]{"Y", "\\`", "`/"});
        map.put(Letter.ALPHABET_Z, new String[]{"2", "2", "7_"});
    }

    /**
     * Converts the given {@param letter} to a Leet String in the given Leet {@param level}.
     *
     * @throws IllegalArgumentException if the {@param level} is higher than 3
     */
    public static String convert(Letter letter, int level) {

        if(level > 3)
            throw new IllegalArgumentException("Cant be higher than 3");

        return map.get(letter)[level];
    }

    /**
     * Converts the given {@param leet} letter to a {@link Letter}
     *
     * A Leet {@param level} have to be provided to simplify the translation
     *
     * @throws IllegalArgumentException if the {@param level} is higher than 3
     */
    public static Optional<Letter> convert(String leet, int level) {

        if(level > 3)
            throw new IllegalArgumentException("Cant be higher than 3");

        for(Map.Entry<Letter, String[]> entry : map.entrySet()) {

            for(String s : entry.getValue()) {

                if(leet.equals(s))
                    return Optional.of(entry.getKey());
            }
        }

        return Optional.empty();
    }

}
