package com.mjiayou.trejava.babyfinder;

import com.mjiayou.trejava.DateUtil;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BabyFinder {

	public static void main(String[] args) {
		System.out.println("**************** BEGIN ****************");
		System.out.println();
		System.out.println("getAddressByNumber(940022110dfc83b7d6d1) -> " + getAddressByNumber("940022110dfc83b7d6d1"));
		System.out.println("getNumberByAddress(0D:FC:83:B7:D6:D1) -> " + getNumberByAddress("0D:FC:83:B7:D6:D1"));
		System.out.println();
		System.out.println("getDisconnectDateTime(1479560999) -> " + getDisconnectDateTime("1479560999"));
		System.out.println("getDisconnectDateTime(1479560999) -> " + getDisconnectDateTime("1479561204.18805"));
		System.out.println();
		String fileNameOrigin = "/Users/treason/Pictures/com.tencent.ScreenCapture/QQ20160927-9@2x.ssss";
		File file = new File(fileNameOrigin);
		String mimeType;
		mimeType = "image/" + file.getName().split("\\.")[1]; // image/jpg
		mimeType = "image/" + file.getName().substring(file.getName().lastIndexOf(".") + 1);
		System.out.println("mimeType -> " + mimeType);
		System.out.println();
		System.out.println("getProtectTime(1479560999) -> " + getProtectTime("12000"));
		System.out.println();
		String tempName = "尚未设置";
		try {
			tempName = "18600574121";
			tempName = tempName.substring(0, 3) + "****" + tempName.substring(tempName.length() - 4, tempName.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("tempName -> " + tempName);
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

	public static String getProtectTime(String protection) {
		return getProtectTime(Long.valueOf(protection));
	}

	public static String getProtectTime(long protection) {
		if (protection < 60) {
			return "小于一分钟";
		} else if (protection >= 60 && protection < 60 * 60) {
			long minute = protection / 60;
			return minute + "分钟";
		} else {
			long hour = protection / (60 * 60);
			long minute = protection % (60 * 60) / 60;
			return hour + "小时" + (minute == 0 ? "" : minute + "分钟");
		}
	}
}
