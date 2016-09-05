package com.mjiayou.trejava.temp;

import java.util.Calendar;

public class OrderHour {
	public static void main(String[] args) {
		System.out.println("test");
		System.out.println(getIdByOrderHour("11:00"));
		System.out.println(getIdByCurrentTime());

		// 当前时间
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);

		System.out.println("time--" + hour + ":" + minute);
	}

	/**
	 * orderHour to id
	 */
	public static String getIdByOrderHour(String orderHour) {
		String orderHourId = "0";
		try {
			String hour = orderHour.split(":")[0];
			String minute = orderHour.split(":")[1];
			int id = Integer.parseInt(hour) * 2 + Integer.parseInt(minute) / 30;

			orderHourId = String.valueOf(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderHourId;
	}

	/**
	 * orderHour to id
	 */
	public static String getIdByCurrentTime() {

		String orderHourId = "0";
		try {
			// 当前时间
			Calendar calendar = Calendar.getInstance();
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			
			int id = hour * 2 + minute / 30;

			orderHourId = String.valueOf(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderHourId;
	}
}
