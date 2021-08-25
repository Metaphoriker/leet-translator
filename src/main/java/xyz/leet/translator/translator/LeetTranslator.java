package xyz.leet.translator.translator;

import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.enums.Letter;

public interface LeetTranslator {

    /**
     * Returns the given String converted to the given {@link EncryptionType}
     */
    String convert(String toConvert, EncryptionType encryptionType);

    /**
     * Returns the given Letter converted to a Leet String with the given level
     */
    String toLeet(Letter letter, int level);

    /**
     * Returns the given Letter converted to the letter increasingly shifted by the given shift
     */
    String toCaesarShift(Letter letter, int shift);

    /**
     * Returns the given Letter converted to the emoji equivalent
     */
    String toEmoji(Letter letter);

    /**
     * TODO
     */
    String toFuckery(Letter letter);

}
