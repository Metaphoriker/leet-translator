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

        map.put(Letter.A, new String[]{"4", "4", "/-\\"});
        map.put(Letter.B, new String[]{"8", "8", "[3"});
        map.put(Letter.C, new String[]{"C", "(", "("});
        map.put(Letter.D, new String[]{"D", "[)", "|)"});
        map.put(Letter.E, new String[]{"3", "3", "[-"});
        map.put(Letter.F, new String[]{"F", "|=", "|="});
        map.put(Letter.G, new String[]{"9", "9", "(_+"});
        map.put(Letter.H, new String[]{"H", "|-|", "#"});
        map.put(Letter.I, new String[]{":", ":", "!"});
        map.put(Letter.J, new String[]{"J", "_|", "_|"});
        map.put(Letter.K, new String[]{"K", "K", "|<"});
        map.put(Letter.L, new String[]{"1", "1", "L_"});
        map.put(Letter.M, new String[]{"M", "|\\/|", "|\\/|"});
        map.put(Letter.N, new String[]{"N", "|\\|", "|\\|"});
        map.put(Letter.O, new String[]{"0", "0", "[]"});
        map.put(Letter.P, new String[]{"P", "|*", "|>"});
        map.put(Letter.Q, new String[]{"Q", "(_,)", "(_,)"});
        map.put(Letter.R, new String[]{"!2", "|2", "/2"});
        map.put(Letter.S, new String[]{"5", "5", "$"});
        map.put(Letter.T, new String[]{"7", "7", "'|'"});
        map.put(Letter.U, new String[]{"U", "(_)", "|_|"});
        map.put(Letter.V, new String[]{"V", "\\/", "|/"});
        map.put(Letter.W, new String[]{"W", "\\/\\/", "\\|/"});
        map.put(Letter.X, new String[]{"X", "><", ")("});
        map.put(Letter.Y, new String[]{"Y", "\\`", "`/"});
        map.put(Letter.Z, new String[]{"2", "2", "7_"});
    }

    /**
     * Converts the given {@param letter} to a Leet String in the given Leet {@param level}.
     *
     * @throws IllegalArgumentException if the {@param level} is higher than 3
     */
    public static String convert(Letter letter, int level) {

        if(level > 3)
            throw new IllegalArgumentException("Cant be >= 3");

        return map.get(letter)[level-1];
    }

    /**
     * Converts the given {@param leet} letter to a {@link Letter}
     */
    public static Optional<Letter> convert(String leet) {

        for(Map.Entry<Letter, String[]> entry : map.entrySet()) {

            for(String s : entry.getValue()) {

                if(leet.equals(s))
                    return Optional.of(entry.getKey());
            }
        }

        return Optional.empty();
    }

}
