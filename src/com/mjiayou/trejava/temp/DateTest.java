package com.mjiayou.trejava.temp;

import java.util.Calendar;

public class DateTest {
	public static void main(String[] arg) {
		System.out.println("test");

		Calendar calendar = Calendar.getInstance();
		// calendar.setTimeInMillis(time);
		Calendar now = Calendar.getInstance();

		int nowYear = now.get(Calendar.YEAR);
		int nowMonth = now.get(Calendar.MONTH);

		// int topicYear = calendar.get(Calendar.YEAR);
		int topicYear = 2013;
		// int topicMonth = calendar.get(Calendar.MONTH);
		int topicMonth = 11;

		int month = (nowYear * 12 + nowMonth) - (topicYear * 12 + topicMonth);
		if (month < 12) {
			System.out.println(month + "个月前");
		} else {
			System.out.println(month / 12 + "年前");
		}

	}
}
