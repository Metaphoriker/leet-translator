package xyz.leet.translator.translator;

import xyz.leet.translator.converter.CaesarShiftConverter;
import xyz.leet.translator.converter.EmojiConverter;
import xyz.leet.translator.converter.FuckeryConverter;
import xyz.leet.translator.converter.LeetConverter;
import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.enums.Letter;
import xyz.leet.translator.utils.EncryptionUtil;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class LeetTranslatorImpl implements LeetTranslator {

    @Override
    public String convert(String toConvert, EncryptionType encryptionType) {

        int shift = ThreadLocalRandom.current().nextInt(5)+1;
        return switch (encryptionType) {

            case DECODE -> convertToNormal(toConvert);
            case LEET_LEVEL_1 -> EncryptionUtil.appendEncryptionCode(loopThroughString(toConvert, encryptionType, 1), encryptionType);
            case LEET_LEVEL_2 -> EncryptionUtil.appendEncryptionCode(loopThroughString(toConvert, encryptionType, 2), encryptionType);
            case LEET_LEVEL_3 -> EncryptionUtil.appendEncryptionCode(loopThroughString(toConvert, encryptionType, 3), encryptionType);
            case DISCORD_EMOJI, FUCKERY -> EncryptionUtil.appendEncryptionCode(loopThroughString(toConvert, encryptionType, -1), encryptionType);
            case CAESAR_SHIFT -> EncryptionUtil.appendEncryptionCode(shift + "_" +loopThroughString(toConvert, encryptionType, shift), encryptionType);
            default -> throw new IllegalArgumentException("Untreated enum expression");
        };
    }

    @Override
    public String convertToNormal(String toConvert) {

        Optional<EncryptionType> encryptionTypeOptional = EncryptionUtil.getEncryption(toConvert);
        if(encryptionTypeOptional.isEmpty()) return toConvert;

        EncryptionType encryptionType = encryptionTypeOptional.get();

        return loopThroughString(toConvert.replace(encryptionType.getEncryptionCode(), ""), encryptionType);
    }

    @Override
    public String toLeet(Letter letter, int level) {
        return LeetConverter.convert(letter, level);
    }

    @Override
    public String toCaesarShift(Letter letter, int shift) {
        return CaesarShiftConverter.convert(letter, shift);
    }

    @Override
    public String toEmoji(Letter letter) {
        return EmojiConverter.convert(letter);
    }

    @Override
    public String toFuckery(Letter letter) {
        return FuckeryConverter.convert(letter);
    }

    private String loopThroughString(String s, EncryptionType encryptionType) {

        StringBuilder stringBuilder = new StringBuilder();

        switch (encryptionType) {

            case LEET_LEVEL_1, LEET_LEVEL_2, LEET_LEVEL_3 -> {

                int index = Integer.parseInt(encryptionType.name().split("_")[2])-1;
                for (String leet : LeetConverter.getLeetFillers(index)) {

                    Optional<Letter> optionalLetter = LeetConverter.convert(leet);
                    s = s.replace(leet, optionalLetter.map(Enum::name).orElse(""));
                }

                stringBuilder.append(s);
            }

            case FUCKERY -> {

                for (String leet : FuckeryConverter.getFuckeryFillers()) {

                    Optional<Letter> optionalLetter = FuckeryConverter.convert(leet);
                    s = s.replace(leet, optionalLetter.map(Enum::name).orElse(""));
                }
                stringBuilder.append(s);
            }

            case DISCORD_EMOJI -> {

                for (String leet : EmojiConverter.getEmojiFillers()) {

                    Optional<Letter> optionalLetter = EmojiConverter.convert(leet);
                    s = s.replace(leet, optionalLetter.map(Enum::name).orElse(""));
                }
                stringBuilder.append(s);
            }

            case CAESAR_SHIFT -> {

                int shift = Integer.parseInt(s.split("_")[0]);
                s = s.replace(shift + "_", "");

                for(int i = 0; i < s.length(); i++) {

                    String currentS = String.valueOf(s.charAt(i));
                    appendToStringBuilder(stringBuilder, CaesarShiftConverter.convert(currentS, shift), currentS);
                }
            }

            default -> throw new IllegalArgumentException("Untreated enum expression");
        }

        return stringBuilder.toString();
    }

    private String loopThroughString(String s, EncryptionType encryptionType, int integer) {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);
            if (!Character.isAlphabetic(current)) {

                stringBuilder.append(current);
                continue;
            }

            Letter letter = Letter.valueOf(String.valueOf(current).toUpperCase());

            switch (encryptionType) {

                case LEET_LEVEL_1, LEET_LEVEL_3, LEET_LEVEL_2 -> stringBuilder.append(toLeet(letter, integer));
                case DISCORD_EMOJI -> stringBuilder.append(toEmoji(letter));
                case CAESAR_SHIFT -> stringBuilder.append(toCaesarShift(letter, integer));
                case FUCKERY -> stringBuilder.append(toFuckery(letter));
                default -> throw new IllegalArgumentException("Untreated enum expression");

            }
        }

        return stringBuilder.toString();
    }

    private void appendToStringBuilder(StringBuilder stringBuilder, Optional<Letter> letterOptional, String currentS) {
        stringBuilder.append(letterOptional.isPresent() ? letterOptional.get() : currentS);
    }

}
