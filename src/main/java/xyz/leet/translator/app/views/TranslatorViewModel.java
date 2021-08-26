package xyz.leet.translator.app.views;

import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.translator.LeetTranslator;

public class TranslatorViewModel {

    private final LeetTranslator leetTranslator;

    public TranslatorViewModel(LeetTranslator leetTranslator) {
        this.leetTranslator = leetTranslator;
    }

    public String translate(String text, EncryptionType encryptionType) {
        return leetTranslator.convert(text, encryptionType);
    }

}
