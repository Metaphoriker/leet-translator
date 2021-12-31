package xyz.leet.translator.converter.types;

import xyz.leet.translator.converter.Converter;
import xyz.leet.translator.enums.Letter;

import java.util.Optional;

public class CaesarShiftConverter extends Converter {
    
    /*
     * The letters in alphabetic order to be able to shift around them
     */
    private static final Letter[] letters = Letter.values();
    
    private static int getIndexOf(Letter letter) {
        
        for (int i = 0; i < letters.length - 1; i++)
            if (letter == letters[i]) return i;
        
        return -1;
    }
    
    /*
     * Returns the correct shift evaluated from current and increment.
     *
     * If the shift is higher than 25 (max. letters length) it will be 0+remaining
     */
    private static int correctShift(int current, int increment) {
        return current + increment > 25 ? current + increment - 25 : current + increment;
    }
    
    /*
     * Returns the correct shift evaluated from current and increment.
     *
     * If the shift is lower than 0 (min. letters length) it will be 25-remaining
     */
    private static int correctBackShift(int current, int decrement) {
        return current - decrement < 0 ? current - decrement + 25 : current - decrement;
    }
    
    private int shift;
    
    @Override
    public Optional<Letter> convert(String s) {
        
        Letter letter;
        
        try {
            letter = Letter.valueOf(letters[correctBackShift(getIndexOf(Letter.valueOf(s.toUpperCase())), shift)].name());
        } catch (Exception e) {
            return Optional.empty();
        }
        
        return Optional.of(letter);
    }
    
    @Override
    public String convert(Letter l) {
        return letters[correctShift(getIndexOf(l), shift)].name();
    }
    
    /**
     * @apiNote If the shift is never being set, it will be 0 by default
     */
    public void shift(int shift) {
        this.shift = shift;
    }
}
