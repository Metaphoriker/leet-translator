package xyz.leet.translator;

import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.enums.Letter;

public interface LeetTranslator {

    String convert(Letter letter, EncryptionType encryptionType);

    String toLeet(Letter letter);

    String toCaesarShift(Letter letter);

    String toEmoji(Letter letter);

    String toFuckery(Letter letter);

    Letter toLetter(String string);

}
