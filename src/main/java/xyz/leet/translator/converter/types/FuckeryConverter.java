package xyz.leet.translator.converter.types;

import xyz.leet.translator.converter.Converter;
import xyz.leet.translator.enums.Letter;

import java.util.*;

public class FuckeryConverter extends Converter {

    public static final Map<Letter, String> map = new HashMap<>();

    static {
        map.put(Letter.A, "CHAIR");
        map.put(Letter.B, "DESK");
        map.put(Letter.C, "TABLE");
        map.put(Letter.D, "CARPET");
        map.put(Letter.E, "CHOCO");
        map.put(Letter.F, "WINDOWS");
        map.put(Letter.G, "FLOOR");
        map.put(Letter.H, "METAL");
        map.put(Letter.I, "WOOD");
        map.put(Letter.J, "ALUMINIUM");
        map.put(Letter.K, "FORTNITE");
        map.put(Letter.L, "ICECREAM");
        map.put(Letter.M, "COFFEE");
        map.put(Letter.N, "TEA");
        map.put(Letter.O, "CRUMPETS");
        map.put(Letter.P, "CAKE");
        map.put(Letter.Q, "COAL");
        map.put(Letter.R, "OIL");
        map.put(Letter.S, "SCHOOL");
        map.put(Letter.T, "GUN");
        map.put(Letter.U, "EXPLOSION");
        map.put(Letter.V, "PHONE");
        map.put(Letter.W, "CABLE");
        map.put(Letter.X, "DUCK");
        map.put(Letter.Y, "COW");
        map.put(Letter.Z, "OSTRICH");
    }

    @Override
    public String convert(Letter l) {
        return map.get(l);
    }

    @Override
    public Optional<Letter> convert(String s) {

        for(Map.Entry<Letter, String> entry : map.entrySet()) {

            if(s.equals(entry.getValue()))
                return Optional.of(entry.getKey());
        }

        return Optional.empty();
    }

    @Override
    public List<String> getFillers() {

        List<String> generics = new ArrayList<>();

        for (Letter letter : Letter.values())
            generics.add(map.get(letter));

        generics.sort((string1, string2) -> string2.length() - string1.length());

        return generics;
    }

}
