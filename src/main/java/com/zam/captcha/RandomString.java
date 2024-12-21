package com.zam.captcha;

import java.util.Random;

public class RandomString {
    private static final int DEFAULT_LENGTH = 16;

    private static final String alphaNumPool = "QWERTYUIOPASDFGHJKLZXCVBNM01234567890qwertyuiopasdfghjklzxcvbnm";
    private static final String alphaPool = "qwertPASDFGHJKLZyuiopasQWERTYUIOXCVBNMdfghjklzxcvbnm";
    private static final String numPool = "4238950167";

    public static String generate(RandomStringType type, int length) {
        String pool = "";
        String out = "";

        Random random = new Random();

        switch(type) {
            case ALPHANUMERIC:
                pool = alphaNumPool;
                break;
            case LETTERS:
                pool = alphaPool;
                break;
            case NUMBERS:
                pool = numPool;
                break;
        }

        for(int i = 0; i < length; i++) {
            // Numero casuale tra 0 e la lunghezza della pool
            int charIndex = random.ints(0, pool.length())
                .findFirst()
                .getAsInt();

            out = out + pool.charAt(charIndex);
        }

        return out;
    }

    public static String generate(RandomStringType type) {
        return generate(type, DEFAULT_LENGTH);
    }
}
