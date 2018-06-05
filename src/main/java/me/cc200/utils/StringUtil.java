package me.cc200.utils;

import lombok.NonNull;

public class StringUtil {

    private StringUtil() {}

    public static boolean isEmpty(String str) {
        return null == str || isBlank(str);
    }

    public static boolean isBlank(@NonNull String str) {
        return "".equals(str.trim());
    }
}
