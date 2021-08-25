package xyz.leet.translator.translator;

import xyz.leet.translator.converter.CaesarShiftConverter;
import xyz.leet.translator.converter.EmojiConverter;
import xyz.leet.translator.converter.LeetConverter;
import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.enums.Letter;
import xyz.leet.translator.utils.EncryptionUtil;

import java.util.concurrent.ThreadLocalRandom;

public class LeetTranslatorImpl implements LeetTranslator {

    @Override
    public String convert(String toConvert, EncryptionType encryptionType) {

        //TODO hardcoded
        int shift = ThreadLocalRandom.current().nextInt(5)+1;
        return switch (encryptionType) {

            case LEET_LEVEL_1 -> EncryptionUtil.appendEncryptionCode(loopThroughString(toConvert, encryptionType, 1), encryptionType);
            case LEET_LEVEL_2 -> EncryptionUtil.appendEncryptionCode(loopThroughString(toConvert, encryptionType, 2), encryptionType);
            case LEET_LEVEL_3 -> EncryptionUtil.appendEncryptionCode(loopThroughString(toConvert, encryptionType, 3), encryptionType);
            case EMOJI, FUCKERY -> EncryptionUtil.appendEncryptionCode(loopThroughString(toConvert, encryptionType, -1), encryptionType);
            case CAESAR_SHIFT -> EncryptionUtil.appendEncryptionCode(shift+loopThroughString(toConvert, encryptionType, shift), encryptionType);
        };
    }

    private String loopThroughString(String s, EncryptionType encryptionType, int integer) {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);
            Letter letter = Letter.valueOf(String.valueOf(current).toUpperCase());

            switch (encryptionType) {

                case LEET_LEVEL_1, LEET_LEVEL_3, LEET_LEVEL_2 -> stringBuilder.append(toLeet(letter, integer));
                case EMOJI -> stringBuilder.append(toEmoji(letter));
                case CAESAR_SHIFT -> stringBuilder.append(toCaesarShift(letter, integer));
                case FUCKERY -> stringBuilder.append(toFuckery(letter));

            }
        }

        return stringBuilder.toString();
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /*
     * NOTE: String#startsWith(String) check at the beginning of CaesarShift String for "deshifting"
     */
    @Override
    public Letter toLetter(String string) {
        return null;
    }

}
