package com.mjiayou.trejava.module.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日期转换测试
 */
public class CalendarTest {

    public static void main(String[] args) {
        System.out.println("begin");

        System.out.println("");
        System.out.println(Calendar.getInstance().getTime().toString());
        System.out.println("今天：" + getCurrentDate());

        System.out.println("");
        System.out.println("前天：" + getDate(-2));
        System.out.println("昨天：" + getDate(-1));
        System.out.println("今天：" + getDate(0));
        System.out.println("明天：" + getDate(1));
        System.out.println("后天：" + getDate(2));
    }

    /**
     * 获取当前日期，格式为2014-12-31
     */
    public static String getCurrentDate() {
        StringBuilder builder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();

        // SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        builder.append(simpleDateFormat.format(calendar.getTime()));

        // 手动拼接
        builder.append(" ---- ");
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        if (month.length() != 2) {
            month = "0" + month;
        }
        if (day.length() != 2) {
            day = "0" + day;
        }

        builder.append(year);
        builder.append("-");
        builder.append(month);
        builder.append("-");
        builder.append(day);

        return builder.toString();
    }

    /**
     * 今天、明天、后天、大后天日期格式
     */
    public static String getDate(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day); // day=0代表今天，类推

        // SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(calendar.getTime());
    }
}
