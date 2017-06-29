package com.mjiayou.trejava.module.test;

import java.util.Calendar;

/**
 * 指定日期，判断是多少天之前
 */
public class DayBeforeTest {

    public static void main(String[] arg) {

        int topicYear = 2016;
        int topicMonth = 5;
        int topicDay = 21;

        System.out.println(getDayBefore(topicYear, topicMonth, topicDay));
    }

    private static String getDayBefore(int topicYear, int topicMonth, int topicDay) {
        String result;
        Calendar calendar = Calendar.getInstance();

        int nowYear = calendar.get(Calendar.YEAR);
        int nowMonth = calendar.get(Calendar.MONTH) + 1;
        int nowDay = calendar.get(Calendar.DAY_OF_MONTH);

        int yearDiff = nowYear - topicYear;
        int monthDiff = (nowYear * 12 + nowMonth) - (topicYear * 12 + topicMonth);
        int dayDiff = (nowYear * 12 * 30 + nowMonth * 30 + nowDay) - (topicYear * 12 * 30 + topicMonth * 30 + topicDay);

//        System.out.println("topicYear = " + topicYear);
//        System.out.println("topicMonth = " + topicMonth);
//        System.out.println("topicDay = " + topicDay);
//
//        System.out.println("nowYear = " + nowYear);
//        System.out.println("nowMonth = " + nowMonth);
//        System.out.println("nowDay = " + nowDay);
//
//        System.out.println("yearDiff = " + yearDiff);
//        System.out.println("monthDiff = " + monthDiff);
//        System.out.println("dayDiff = " + dayDiff);

        if (monthDiff == 0) { // 同一个月
            if (dayDiff == 0) {
                result = "今天";
            } else if (dayDiff < 0) {
                result = "日期错误";
            } else {
                result = dayDiff + "天前";
            }
        } else if (monthDiff < 12) {
            result = monthDiff + "个月前";
        } else {
            result = monthDiff / 12 + "年前";
        }

        return result;
    }
}
