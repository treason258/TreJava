package com.mjiayou.trejava.temp;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("test");

		/**
		 * getStringByList
		 */
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("");
		list.add("four");
		list.add("five");

		String result = CommonUtils.getStringByList(list);
		System.out.println(result);
	}
}
