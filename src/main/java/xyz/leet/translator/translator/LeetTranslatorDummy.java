package xyz.leet.translator.translator;

import xyz.leet.translator.enums.LeetLetter;
import xyz.leet.translator.enums.EncryptionType;

import java.util.Optional;

@Deprecated
public class LeetTranslatorDummy {

    /**
     * Translates the given *normal* String to Leet
     */
    public String translate(String normal, EncryptionType encryptionType) {

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i != normal.length(); i++)
            builder.append(getLeetLetter(normal, i, encryptionType));
        return addEncryptionCode(builder.toString(), encryptionType);
    }

    /**
     * Translates the given *leet* String to normal
     */
    public String translate(String leet) {

        Optional<EncryptionType> leetLevel = this.getEncryption(leet);
        leet = getWithoutEncrytpionCode(leet);

        if(leetLevel.isEmpty()) return leet;
        
        for (String filler : LeetLetter.getLeetFillers(leetLevel.get()))
            leet = leet.replace(filler, LeetLetter.fromLeet(filler).name());

        return leet;
    }

    private String getLeetLetter(String s, int index, EncryptionType encryptionType) {

        String current = String.valueOf(s.charAt(index));

        if(Character.isAlphabetic(s.charAt(index)))
            return LeetLetter.fromLetter(current).getLeet(encryptionType);
        return current;
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
