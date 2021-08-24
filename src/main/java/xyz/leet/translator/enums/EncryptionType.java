package xyz.leet.translator.enums;

public enum EncryptionType {

    LEET_LEVEL_1("L1"),
    LEET_LEVEL_2("L2"),
    LEET_LEVEL_3("L3"),
    CAESAR_SHIFT("CS"),
    FUCKERY("F"),
    EMOJI("E");

    private final String encryptionCode;

    EncryptionType(String encryptionCode) {
        this.encryptionCode = encryptionCode;
    }

    public String getEncryptionCode() {
        return encryptionCode;
    }
}
