package xyz.leet.translator.utils;

import xyz.leet.translator.enums.EncryptionType;

import java.util.Optional;

public class EncryptionUtil {

    public static String appendEncryptionCode(String s, EncryptionType encryptionType) {
        return s + encryptionType.getEncryptionCode();
    }

    public static String withoutEncryptionCode(String s) {
        Optional<EncryptionType> leetLevel = getEncryption(s);
        return leetLevel.map(encryptionType -> s.substring(0, s.length() - encryptionType.getEncryptionCode().length())).orElse(s);
    }

    public static Optional<EncryptionType> getEncryption(String s) {

        for(EncryptionType encryptionType : EncryptionType.values()) {

            if(encryptionType == EncryptionType.DECODE) continue;

            if(s.endsWith(encryptionType.getEncryptionCode()))
                return Optional.of(encryptionType);
        }
        
        return Optional.empty();
    }

}
