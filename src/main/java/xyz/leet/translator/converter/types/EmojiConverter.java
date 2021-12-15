package xyz.leet.translator.converter.types;

import xyz.leet.translator.converter.Converter;
import xyz.leet.translator.enums.Letter;

import java.util.*;

public class EmojiConverter extends Converter {
    
    private static final Map<Letter, String> map = new HashMap<>();
    
    static {
        
        map.put(Letter.A, ":chart_with_upwards_trend:");
        map.put(Letter.B, ":beach:");
        map.put(Letter.C, ":eyes:");
        map.put(Letter.D, ":drum:");
        map.put(Letter.E, ":eye:");
        map.put(Letter.F, ":fearful:");
        map.put(Letter.G, ":gear:");
        map.put(Letter.H, ":tophat:");
        map.put(Letter.I, ":snowflake:");
        map.put(Letter.J, ":black_joker:");
        map.put(Letter.K, ":key:");
        map.put(Letter.L, ":hearts:");
        map.put(Letter.M, ":mag:");
        map.put(Letter.N, ":pencil:");
        map.put(Letter.O, ":octopus:");
        map.put(Letter.P, ":bird:");
        map.put(Letter.Q, ":princess:");
        map.put(Letter.R, ":rabbit2:");
        map.put(Letter.S, ":electric_plug:");
        map.put(Letter.T, ":steam_locomotive:");
        map.put(Letter.U, ":umbrella2:");
        map.put(Letter.V, ":urn:");
        map.put(Letter.W, ":womens:");
        map.put(Letter.X, ":christmas_tree:");
        map.put(Letter.Y, ":motorboat:");
        map.put(Letter.Z, ":tiger2:");
    }
    
    @Override
    public Optional<Letter> convert(String s) {
        
        for (Map.Entry<Letter, String> entry : map.entrySet())
            if (s.equals(entry.getValue()))
                return Optional.of(entry.getKey());
        
        return Optional.empty();
    }
    
    @Override
    public String convert(Letter l) {
        return map.get(l);
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
