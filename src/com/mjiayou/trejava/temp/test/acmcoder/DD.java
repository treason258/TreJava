package com.mjiayou.trejava.temp.test.acmcoder;

public class DD {
	public static void main(String[] args) {
//		System.out.println("result -> " + foo(2 ^ 31 - 3));

		for (int i = 0; i < 9; i++) {
			getTestNum();
		}
		System.out.println("result -> " + getTestNum());
	}

	public static int foo(int x) {
		return x & -x;
	}

	static int getTestNum() {
		int a = 0;
		int b = 1;
		int c = a + b;
		a = b;
		b = c;
		return c;
	}
}
