package xyz.leet.translator.translator;

import xyz.leet.translator.converter.ConverterBundle;
import xyz.leet.translator.enums.EncryptionType;

public class Translator {

    private final ConverterBundle converterBundle;

    public Translator(ConverterBundle converterBundle) {
        this.converterBundle = converterBundle;
    }

    public String translate(String s) {
        return s;
    }

    public String translate(String s, EncryptionType encryptionType) {
        return s;
    }

}
