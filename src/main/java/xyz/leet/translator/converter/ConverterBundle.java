package xyz.leet.translator.converter;

import xyz.leet.translator.converter.types.CaesarShiftConverter;
import xyz.leet.translator.converter.types.EmojiConverter;
import xyz.leet.translator.converter.types.FuckeryConverter;
import xyz.leet.translator.converter.types.LeetConverter;

public class ConverterBundle {

    public final LeetConverter leetConverter;
    public final EmojiConverter emojiConverter;
    public final FuckeryConverter fuckeryConverter;
    public final CaesarShiftConverter caesarShiftConverter;

    public ConverterBundle() {

        this.leetConverter = new LeetConverter();
        this.emojiConverter = new EmojiConverter();
        this.fuckeryConverter = new FuckeryConverter();
        this.caesarShiftConverter = new CaesarShiftConverter();
    }

}
