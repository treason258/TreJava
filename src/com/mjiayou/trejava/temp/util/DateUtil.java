package com.mjiayou.trejava.temp.util;

import java.util.Calendar;

public class DateUtil {

	// ******************************** getAge & getZodica ********************************

	/**
	 * 获取年龄
	 */
	public static int getAge(Calendar calendar) {
		int age = 0;

		Calendar today = Calendar.getInstance();
		if (today.get(Calendar.YEAR) > calendar.get(Calendar.YEAR)) {
			age = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
		}

		return age;
	}

	/**
	 * 根据日期获取生肖
	 */
	public static String getZodica(Calendar calendar) {
		String[] zodiacArr = new String[] { "猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊" };
		int index = calendar.get(Calendar.YEAR) % 12;
		return zodiacArr[index];
	}

	/**
	 * test
	 */
	public static void getAgeAndZodicaTest() {
		for (int i = 1900; i <= 2100; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(i, 0, 1);

			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DAY_OF_MONTH);

			StringBuilder builder = new StringBuilder();
			builder.append(year + "年" + month + "月" + day + "日");
			builder.append(" | ");
			builder.append("年龄 -> " + getAge(calendar));
			builder.append(" | ");
			builder.append("属相 -> " + getZodica(calendar));
			System.out.println(builder.toString());
		}
	}

	// ******************************** getConstellation ********************************

	/**
	 * 获取星座
	 */
	public static String getConstellation(Calendar calendar) {
		// 魔羯座 12.22-1.19
		// 水瓶座 1.20-2.18
		// 双鱼座 2.19-3.20
		// 白羊座 3.21-4.19
		// 金牛座 4.20-5.20
		// 双子座 5.21-6.21
		// 巨蟹座 6.22-7.22
		// 狮子座 7.23-8.22
		// 处女座 8.23-9.22
		// 天秤座 9.23-10.23
		// 天蝎座 10.24-11.22
		// 射手座 11.23-12.21
		String[] constellationArr = new String[] { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
		int[] dayIndex = new int[] { 19, 18, 20, 19, 20, 21, 22, 22, 22, 23, 22, 21 }; // 两个星座分割日

		int month = calendar.get(Calendar.MONTH); // 月份默认从0开始
		int day = calendar.get(Calendar.DAY_OF_MONTH); // 日默认从1开始
		int index = month;
		// 所查询日期在分割日之后，索引+1，否则不变
		if (day > dayIndex[month]) {
			index = index + 1;
		}
		// 返回索引指向的星座string
		return constellationArr[index];
	}

	/**
	 * test
	 */
	public static void getConstellationTest() {
		for (int i = 0; i <= 11; i++) {
			for (int j = 1; j <= 31; j++) {
				Calendar calendar = Calendar.getInstance();
				calendar.set(1990, i, j);

				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;
				int day = calendar.get(Calendar.DAY_OF_MONTH);

				StringBuilder builder = new StringBuilder();
				builder.append(year + "年" + month + "月" + day + "日");
				builder.append(" | ");
				builder.append("星座 -> " + getConstellation(calendar));
				System.out.println(builder.toString());
			}
		}
	}
}
