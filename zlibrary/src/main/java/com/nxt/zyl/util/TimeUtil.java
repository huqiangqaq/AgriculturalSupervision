package com.nxt.zyl.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeUtil {
    static Calendar calendar = Calendar.getInstance();
    private static List<String> weeklist = new ArrayList<>();

    public static int gethour() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH");
        return Integer.parseInt(format.format(date));

    }

    public static String getweek(int day) {

        if (day == 7) {
            return "周六";
        } else if (day == 6) {
            return "周五";
        } else if (day == 5) {
            return "周四";
        } else if (day == 4) {
            return "周三";
        } else if (day == 3) {
            return "周二";
        } else if (day == 2) {
            return "周一";
        } else if (day == 1) {
            return "周日";
        }
        return null;

    }

    public static String getdate1() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(date);
    }

    public static String getdate2() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static String getweatherdate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        return format.format(date);
    }

    public static List<String> getdatalist() {
        List<String> llist = new ArrayList<String>();
        List<String> weeklists = getoneweekdate();
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        int nextday;
        for (int i = 0; i < 7; i++) {
            nextday = day + i;
            if (nextday > 7) {
                nextday = nextday - 7;
            }
            if (i == 0) {
                llist.add("今天" + "\n" + weeklists.get(i));
            } else {
                llist.add(getweek(nextday) + "\n" + weeklists.get(i));
            }
        }

        return llist;

    }

    public static List<String> getoneweekdate() {
        Calendar cal = Calendar.getInstance();

        for (int i = 0; i < 7; i++) {
            if (i > 0) {
                cal.add(Calendar.DATE, 1);
            }
            weeklist.add(new SimpleDateFormat("MM-dd").format(cal.getTime()));
        }
        return weeklist;
    }

    public static boolean isday() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH");
        int hour = Integer.valueOf(format.format(date));
        System.out.println("hour------------>" + hour);
        if (hour >= 18 || hour <= 3) {
            return false;
        } else {
            return true;
        }
    }
}
