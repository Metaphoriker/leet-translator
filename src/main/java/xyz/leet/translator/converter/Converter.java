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
     *
     * @return An empty Optional if no matching Letter equivalents could be found, otherwise the Letter in an Optional
     */
    public abstract Optional<Letter> convert(String s);
    
    public abstract String convert(Letter l);
}
