package me.cc200.utils;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final ZoneId ZONE_CN = ZoneId.of("Asia/Shanghai");

    public static final DateTimeFormatter DTF_YMDHMS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final DateTimeFormatter DTF_YMD = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDateTime now() {
        return LocalDateTime.now(ZONE_CN);
    }

    public static String nowYMDHMS() {
        return formatYMDHMS(now());
    }

    public static String nowYMD() {
        return formatYMS(now());
    }

    public static String format(@NonNull LocalDateTime time, @NonNull DateTimeFormatter formatter) {
        return formatter.format(time);
    }

    public static String formatYMDHMS(@NonNull LocalDateTime time) {
        return format(time, DTF_YMDHMS);
    }

    public static String formatYMS(@NonNull LocalDateTime time) {
        return format(time, DTF_YMD);
    }

    public static LocalDateTime parse(@NonNull String dateStr, @NonNull DateTimeFormatter formatter) {
        return LocalDateTime.parse(dateStr, formatter);
    }

    public static LocalDateTime parseYMDHMS(@NonNull String dateStr) {
        return parse(dateStr, DTF_YMDHMS);
    }

    public static LocalDateTime parseYMD(@NonNull String dateStr) {
        return parse(dateStr, DTF_YMD);
    }
}
