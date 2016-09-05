package com.mjiayou.trejava.temp;

import java.util.List;

public class CommonUtils {

	/**
	 * List<String> 转换成","间隔的字符串
	 */
	public static String getStringByList(List<String> list) {
		String result = "";
		if (list == null) {
			return result;
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("")) {
				continue;
			}
			if (result.equals("")) {
				result += list.get(i);
			} else {
				result += "," + list.get(i);
			}
		}
		return result;
	}
	
	
}
