package com.mjiayou.trejava;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BabyFinder {

	public static void main(String[] args) {
		System.out.println("**************** BEGIN ****************");

		System.out.println("getAddressByNumber(940022110dfc83b7d6d1) -> " + getAddressByNumber("940022110dfc83b7d6d1"));
		System.out.println("getNumberByAddress(0D:FC:83:B7:D6:D1) -> " + getNumberByAddress("0D:FC:83:B7:D6:D1"));

		System.out.println("getDisconnectDateTime(1479560999) -> " + getDisconnectDateTime("1479560999"));
		System.out.println("getDisconnectDateTime(1479560999) -> " + getDisconnectDateTime("1479561204.18805"));

		System.out.println("**************** END ****************");
	}

	// "add_time": "1479560999",
	// "last_time": "1479561204.18805",
	public static String getDisconnectDateTime(String timestamp) {
		String dateTime = timestamp;
		Double timestampD = Double.valueOf(timestamp) * 1000;
		Long timestampL = Math.round(timestampD);
		dateTime = DateUtil.parseString(timestampL, DateUtil.FormatType.FORMAT_DEFAULT);
		return dateTime;
	}

	public static String getProtectTime(String protection) {
		String protectTime = protection;
		// TODO 需要转换处理
		return protectTime;
	}

	public static String getAddressByNumber(String number) {
		String address = number;
		String macStr = number.substring(number.length() - 12, number.length());
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < macStr.length() / 2; i++) {
			builder.append(macStr.substring(i * 2, i * 2 + 2).toUpperCase() + ":");
		}
		address = builder.toString();
		address = address.substring(0, address.length() - 1);
		return address;
	}

	public static String getNumberByAddress(String address) {
		// 0D:FC:83:B7:D6:D1 -> 940022110dfc83b7d6d1
		// 0D:FC:83:31:EC:B1
		String number = address;
		String[] array = address.split(":");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			builder.append(array[i]);
		}
		number = "94002211" + builder.toString().toLowerCase();
		return number;
	}
}
