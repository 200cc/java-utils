package me.cc200.utils;

import lombok.NonNull;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ByteUtil {

    private ByteUtil() {}

    private static ByteBuffer buffer = ByteBuffer.allocate(8);

    public static String byteToBitStr(byte b) {
        String zero = "00000000";
        String s = Integer.toBinaryString(b);
        return zero.substring(0, 8 - s.length()) + s;
    }

    public static String bytesToHexStr(@NonNull Byte... bytes) {
        return Arrays.stream(bytes)
                .map(b -> {
                    String s = Integer.toHexString(b & 0xff);
                    s = s.length() == 1 ? ("0" + s) : s;
                    return s;
                })
                .collect(Collectors.joining());
    }

    public static String bytesToHexStr(@NonNull byte... bytes) {
        Byte[] bs = new Byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            bs[i] = bytes[i];
        }
        return bytesToHexStr(bs);
    }

    public static byte[] hexStrToBytes(@NonNull String hexStr) {
        int len = hexStr.length();
        hexStr = (len % 2 == 1 ? "0" : "") + hexStr;
        len = len % 2 == 1 ? len + 1 : len;
        byte[] arr = new byte[len / 2];
        for (int i = 0; i < arr.length; i++) {
            int j = i * 2;
            int a = Integer.parseInt(hexStr.substring(j, j + 2), 16);
            byte b = (byte) (a & 0xFF);
            arr[i] = b;
        }
        return arr;
    }

    public static int bytesToInt(byte[] bytes) {
        return bytes[3] & 0xff
                | (bytes[2] & 0xff) << 8
                | (bytes[1] & 0xff) << 16
                | (bytes[0] & 0xff) << 24;
    }

    public static byte[] intToBytes(int i) {
        return new byte[] {
                (byte) ((i >> 24) & 0xff),
                (byte) ((i >> 16) & 0xff),
                (byte) ((i >> 8) & 0xff),
                (byte) (i & 0xff)
        };
    }

    public static byte[] longToBytes(long l) {
        buffer.putLong(0, l);
        return buffer.array();
    }

    public static long bytesToLong(byte[] bytes) {
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();
        return buffer.getLong();
    }

}
