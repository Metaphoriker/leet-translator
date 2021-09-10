package xyz.leet.translator.converter;

import xyz.leet.translator.enums.Letter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class Converter {

    public abstract Optional<Letter> convert(String s);

    public abstract String convert(Letter l);

    /**
     * This method is for override purpose only
     */
    public List<String> getFillers() {
        return Collections.emptyList();
    }

}
