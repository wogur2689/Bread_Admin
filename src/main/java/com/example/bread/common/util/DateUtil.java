package com.example.bread.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    /**
     * 날짜 유효성 검사
     */
    public static boolean checkDate(String date, String pattern) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * String To Date yyyy-MM-dd
     */
    public static Date convertStringToDate(String utilDate) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(utilDate);
    }

    /**
     * Date To formatString
     */
    public static String dateToStringFormat(Date srcDate, String formatStr) {
        SimpleDateFormat sf = new SimpleDateFormat(formatStr);
        return sf.format(srcDate);
    }

    /**
     * yyyyMMddHHmmss TO LocalDateTime
     */
    public static LocalDateTime convertStringToLocalDateTime(String textDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.parse(textDate, formatter);
    }
}
