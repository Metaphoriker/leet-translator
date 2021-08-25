package xyz.leet.translator.translator;

import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.enums.Letter;

public interface LeetTranslator {

    String convert(String toConvert, EncryptionType encryptionType);

    String toLeet(Letter letter, int level);

    String toCaesarShift(Letter letter, int shift);

    String toEmoji(Letter letter);

    String toFuckery(Letter letter);

    Letter toLetter(String string);

}
