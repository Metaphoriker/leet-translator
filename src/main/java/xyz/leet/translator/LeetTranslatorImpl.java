package xyz.leet.translator;

import xyz.leet.translator.converter.CaesarShiftConverter;
import xyz.leet.translator.converter.EmojiConverter;
import xyz.leet.translator.converter.LeetConverter;
import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.enums.Letter;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class LeetTranslatorImpl implements LeetTranslator {

    @Override
    public String convert(Letter letter, EncryptionType encryptionType) {

        //TODO hardcoded
        int shift = ThreadLocalRandom.current().nextInt(5)+1;
        return switch (encryptionType) {

            case LEET_LEVEL_1 -> addEncryptionCode(toLeet(letter, 1), encryptionType);
            case LEET_LEVEL_2 -> addEncryptionCode(toLeet(letter, 2), encryptionType);
            case LEET_LEVEL_3 -> addEncryptionCode(toLeet(letter, 3), encryptionType);
            case EMOJI -> addEncryptionCode(toEmoji(letter), encryptionType);
            case CAESAR_SHIFT -> addEncryptionCode(shift+toCaesarShift(letter, shift), encryptionType);
            case FUCKERY -> throw new UnsupportedOperationException("Not implemented yet");
        };
    }

    @Override
    public String toLeet(Letter letter, int level) {
        return LeetConverter.convert(letter, level);
    }

    @Override
    public String toCaesarShift(Letter letter, int shift) {
        return CaesarShiftConverter.convert(letter, shift);
    }

    @Override
    public String toEmoji(Letter letter) {
        return EmojiConverter.convert(letter);
    }

    @Override
    public String toFuckery(Letter letter) {
        return null;
    }

    /*
     * NOTE: String#startsWith(String) check at the beginning of CaesarShift String for "deshifting"
     */
    @Override
    public Letter toLetter(String string) {
        return null;
    }

    private String addEncryptionCode(String s, EncryptionType encryptionType) {
        return s + encryptionType.getEncryptionCode();
    }

    private String getWithoutEncrytpionCode(String s) {

        Optional<EncryptionType> leetLevel = this.getEncryption(s);
        return s.substring(0, s.length() - leetLevel.get().getEncryptionCode().length());
    }

    private Optional<EncryptionType> getEncryption(String s) {

        for(EncryptionType encryptionType : EncryptionType.values()) {

            if(s.endsWith(encryptionType.getEncryptionCode()))
                return Optional.of(encryptionType);
        }
        return Optional.empty();
    }
}
