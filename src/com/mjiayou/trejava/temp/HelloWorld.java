package com.mjiayou.trejava.temp;

import java.lang.reflect.Field;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	static {
		try {
			Field valueField = String.class.getDeclaredField("value");
			if (valueField != null) {
				valueField.setAccessible(true);
			}
			valueField.set("Hello World!", "Goodbye!".toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
