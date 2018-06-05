package me.cc200.utils;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtil {

    private RandomUtil() {}

    public static final String[] NUMBERS = "0123456789".split("");

    public static final String[] ALPHAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    public static final String[] ALPHANUMBERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    public static String numbers(int len) {
        return chars(NUMBERS, len);
    }

    public static String alphas(int len) {
        return chars(ALPHAS, len);
    }

    public static String alphaNumbers(int len) {
        return chars(ALPHANUMBERS, len);
    }

    public static String chars(final String[] chars, int len) {
        final int cLen = chars.length;
        return (chars.length == 0 || len <= 0)
                ? ""
                : IntStream.range(0, len).boxed()
                    .map(i -> chars[new Random().nextInt(cLen)])
                    .collect(Collectors.joining());
    }

}
