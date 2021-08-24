package xyz.leet.translator;

import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.enums.Letter;

import java.util.Optional;

public class LeetTranslatorImpl implements LeetTranslator {

    @Override
    public String convert(Letter letter, EncryptionType encryptionType) {
        return null;
    }

    @Override
    public String toLeet(Letter letter) {
        return null;
    }

    @Override
    public String toCaesarShift(Letter letter) {
        return null;
    }

    @Override
    public String toEmoji(Letter letter) {
        return null;
    }

    @Override
    public String toFuckery(Letter letter) {
        return null;
    }

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
