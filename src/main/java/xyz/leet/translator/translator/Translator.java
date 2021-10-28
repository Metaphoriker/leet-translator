package xyz.leet.translator.translator;

import xyz.leet.translator.converter.Converter;
import xyz.leet.translator.converter.ConverterBundle;
import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.enums.Letter;
import xyz.leet.translator.utils.EncryptionUtil;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Translator {

    private final ConverterBundle converterBundle;

    public Translator(ConverterBundle converterBundle) {
        this.converterBundle = converterBundle;
    }

    /**
     * Translates the given String to a normal readable String.
     *
     * It will return immediately, if there was no EncryptionType found.
     */
    public String translate(String s) {

        Optional<EncryptionType> encryptionTypeOptional = EncryptionUtil.getEncryption(s);
        if(encryptionTypeOptional.isEmpty()) return s;

        EncryptionType encryptionType = encryptionTypeOptional.get();

        s = s.replace(encryptionType.getEncryptionCode(), "");

        return translateToNormal(s, encryptionType);
    }

    /**
     * Translates the given String to the encrypted equivalent of the given {@link EncryptionType}.
     */
    public String translate(String s, EncryptionType encryptionType) {

        StringBuilder stringBuilder = new StringBuilder();
        int shift = ThreadLocalRandom.current().nextInt(5)+1;

        for(int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);
            if (!Character.isAlphabetic(current)) {

                stringBuilder.append(current);
                continue;
            }

            Letter letter = Letter.valueOf(String.valueOf(current).toUpperCase());

            switch (encryptionType) {

                case LEET_LEVEL_1, LEET_LEVEL_3, LEET_LEVEL_2 -> {

                    converterBundle.leetConverter.level(Integer.parseInt(encryptionType.name().split("_")[2]));
                    stringBuilder.append(converterBundle.leetConverter.convert(letter));
                }

                case CAESAR_SHIFT -> {

                    converterBundle.caesarShiftConverter.shift(shift);
                    stringBuilder.append(converterBundle.caesarShiftConverter.convert(letter));
                }

                case DISCORD_EMOJI -> stringBuilder.append(converterBundle.emojiConverter.convert(letter));
                case FUCKERY -> stringBuilder.append(converterBundle.fuckeryConverter.convert(letter));
            }
        }

        if(encryptionType == EncryptionType.CAESAR_SHIFT)
            stringBuilder.insert(0, shift + "_");

        return EncryptionUtil.appendEncryptionCode(stringBuilder.toString(), encryptionType);
    }

    private String translateToNormal(String s, EncryptionType encryptionType) {

        StringBuilder stringBuilder = new StringBuilder();

        switch (encryptionType) {

            case LEET_LEVEL_1, LEET_LEVEL_2, LEET_LEVEL_3 -> {

                int index = Integer.parseInt(encryptionType.name().split("_")[2])-1;

                converterBundle.leetConverter.level(index);
                stringBuilder.append(convertToLetter(s, converterBundle.leetConverter));
            }

            case CAESAR_SHIFT -> {

                int shift = Integer.parseInt(s.split("_")[0]);
                s = s.replace(shift + "_", "");

                converterBundle.caesarShiftConverter.shift(shift);

                for (int i = 0; i < s.length(); i++) {
                    char character = s.charAt(i);
                    if (Character.isAlphabetic(character)) {
                        stringBuilder.append(converterBundle.caesarShiftConverter.convert(Character.toString(character)).map(Enum::name).orElse("").charAt(0));
                    }else {
                        stringBuilder.append(character);
                    }
                }
            }

            case FUCKERY -> stringBuilder.append(convertToLetter(s, converterBundle.fuckeryConverter));
            case DISCORD_EMOJI -> stringBuilder.append(convertToLetter(s, converterBundle.emojiConverter));
        }

        return stringBuilder.toString();
    }

    private String convertToLetter(String s, Converter converter) {

        for(String leet : converter.getFillers()) {

            s = s.replace(leet, converter.convert(leet).map(Enum::name).orElse(""));
        }

        return s;
    }

}
