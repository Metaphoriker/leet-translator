package xyz.leet.translator.app.views;

import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.translator.Translator;

/**
 * The ViewModel for the {@link TranslatorView} which manages the interactions in the {@link TranslatorView}.
 */
public class TranslatorViewModel {

    private final Translator translator;

    public TranslatorViewModel(Translator translator) {
        this.translator = translator;
    }

    public String translate(String text, EncryptionType encryptionType) {
        if (encryptionType == EncryptionType.DECODE) return translator.translate(text);
        return translator.translate(text, encryptionType);
    }

}
