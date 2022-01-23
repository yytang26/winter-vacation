package com.example.lottery.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author:tyy
 * @date:2022/1/23
 */
public class DateUtil {

    public static Date getTodayZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}
