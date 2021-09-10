package xyz.leet.translator.converter.types;

import xyz.leet.translator.converter.Converter;
import xyz.leet.translator.enums.Letter;

import java.util.*;

public class LeetConverter extends Converter {

    /*
     * This SortedMap contains every Letter with their 3 Leet equivalents.
     *
     * There are no null values and the length of the Array is fixed at 3.
     */
    public static final SortedMap<Letter, String[]> map = new TreeMap<>();

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

    private int level;

    @Override
    public Optional<Letter> convert(String leet) {

        for(Map.Entry<Letter, String[]> entry : map.entrySet()) {

            for(String s : entry.getValue()) {

                if(leet.equals(s))
                    return Optional.of(entry.getKey());
            }
        }

        return Optional.empty();
    }

    @Override
    public String convert(Letter l) {

        if(level > 3)
            throw new IllegalArgumentException("Cant be >= 3");

        return map.get(l)[level-1];
    }

    @Override
    public List<String> getFillers() {

        List<String> generics = new ArrayList<>();

        for (Letter letter : Letter.values())
            generics.add(map.get(letter)[level]);

        generics.sort((string1, string2) -> string2.length() - string1.length());

        return generics;
    }

    /*
     * TODO bad solution
     */
    public void level(int level) {
        this.level = level;
    }

}
