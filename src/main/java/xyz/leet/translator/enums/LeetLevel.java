package xyz.leet.translator.enums;

public enum LeetLevel {

    LEET_LEVEL_1("L1"),
    LEET_LEVEL_2("L2"),
    LEET_LEVEL_3("L3"),
    DISCORD_EMOJI("DE"),
    CAESAR_SHIFT("CS"),
    FUCKERY("F");

    private final String encryptionCode;

    LeetLevel(String encryptionCode) {
        this.encryptionCode = encryptionCode;
    }

    public String getEncryptionCode() {
        return encryptionCode;
    }
}
