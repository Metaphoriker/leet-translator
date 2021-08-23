package xyz.leet.translator;

import xyz.leet.translator.enums.LeetLevel;

public class LeetBase {

    public static final LeetTranslator LEET_TRANSLATOR = new LeetTranslator();

    public static void main(String[] args) {

        String leet = LEET_TRANSLATOR.toLeet("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z", LeetLevel.LEET_LEVEL_1);
        String leet2 = LEET_TRANSLATOR.toLeet("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z", LeetLevel.LEET_LEVEL_2);
        String leet3 = LEET_TRANSLATOR.toLeet("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z", LeetLevel.LEET_LEVEL_3);

        System.out.println(LEET_TRANSLATOR.toNormal(leet));
        System.out.println(LEET_TRANSLATOR.toNormal(leet2));
        System.out.println(LEET_TRANSLATOR.toNormal(leet3));
    }

}
