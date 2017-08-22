package com.oranfish.common;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date getToday(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date getTodayAddDay(int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getToday());
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return calendar.getTime();
    }
}
