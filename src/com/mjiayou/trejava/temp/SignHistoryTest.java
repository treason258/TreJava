package com.mjiayou.trejava.temp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SignHistoryTest {
	public static void main(String[] args) {
		System.out.println("test");

		// "2014-12-11",
		// "2014-12-17",
		// "2014-12-19",
		// "2014-12-20"

		// 假数据
//		List<String> list = new ArrayList<String>();
//		list.add("2014-12-11");
//		list.add("2014-12-17");
//		list.add("2014-12-19");
//		list.add("2014-12-20");

//		List<SignedHistory> mList = new ArrayList<SignedHistory>();
//		mList.addAll(parseObjectFromResult(list));
//
//		for (int i = 0; i < mList.size(); i++) {
//			System.out.println("day:" + mList.get(i).getDay() + ";signed:" + mList.get(i).isSigned());
//		}
		
		// 当前月份
		int year = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(String.valueOf(year));
		int month = Calendar.getInstance().get(Calendar.MONTH);
		System.out.println(String.valueOf(month + 1));
		
		System.out.println(getFebruaryDayNum(year));
		

	}
	
	/**
	 * 计算二月有多少天
	 */
	public static int getFebruaryDayNum(int year) {
		Calendar c = Calendar.getInstance();
		c.set(year, 2, 1);// year年的3月1日
		c.add(Calendar.DAY_OF_MONTH, -1);// 将3月1日往左偏移一天结果是2月的天数
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 根据签到日期记录封装成List<SignedHistory>对象
	 */
	private static List<SignedHistory> parseObjectFromResult(List<String> list) {
		List<SignedHistory> mList = new ArrayList<SignedHistory>();

		// 初始化数据，返回数据中截取日期
		for (int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i).substring(8));
			System.out.println(list.get(i));
		}

		// 填充数据
		for (int i = 1; i <= 7; i++) {
			setData(list, mList, i);
		}
		for (int i = 14; i >= 8; i--) {
			setData(list, mList, i);
		}
		for (int i = 15; i <= 21; i++) {
			setData(list, mList, i);
		}
		for (int i = 28; i >= 22; i--) {
			setData(list, mList, i);
		}
		for (int i = 29; i <= 31; i++) {
			setData(list, mList, i);
		}
		
		return mList;
	}

	/**
	 * 根据所给list，填充对应i天的数据到mList
	 */
	private static void setData(List<String> list, List<SignedHistory> mList, int i) {
		SignedHistory mSignedHistory = new SignedHistory();
		mSignedHistory.setDay(String.valueOf(i));
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).equals(String.valueOf(i))) {
				mSignedHistory.setSigned(true);
			}
		}
		mList.add(mSignedHistory);
	}
}
