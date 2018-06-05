package me.cc200.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayUtil {

    private ArrayUtil() {}

    public static <T> T[] concat(T[] a, T[] b) {
        if (a.length == 0) {
            return b;
        }
        if (b.length == 0) {
            return a;
        }
        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length + b.length);
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

}
