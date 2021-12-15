package xyz.leet.translator.converter;

import xyz.leet.translator.enums.Letter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class Converter {
    
    /*
     * This method is for override-purpose only
     */
    public List<String> getFillers() {
        return Collections.emptyList();
    }
    
    /**
     * Tries to converts the given String to a single Letter.
     * Does return an empty Optional if no matching Letter equivalents could be found.
     */
    public abstract Optional<Letter> convert(String s);
    
    public abstract String convert(Letter l);
}
