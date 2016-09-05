package com.mjiayou.trejava;

import java.util.Scanner;

public class JD2 {

	public static void main(String[] args) {
		final int COUNT = 4;

		int[] num = new int[COUNT];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < COUNT; i++) {
			num[i] = scanner.nextInt();
		}
		scanner.close();

		for (int i = 0; i < COUNT; i++) {
			System.out.println(getLuckyNum(num[i]));
		}

		// System.out.println(getLuckyNum(21));
	}

	/**
	 * 求和
	 */
	private static long sum(long num) {
		long result = 0;
		long temp = 0;
		while (num != 0) {
			temp = num % 10;
			num = num / 10;
			result = result + temp;
		}
		return result;
	}

	/**
	 * 十进制转二进制
	 */
	private static long parse(int num) {
		return Long.valueOf(Long.toBinaryString(num));
	}

	/**
	 * f函数
	 */
	private static long f(int num) {
		return sum(num);
	}

	/**
	 * g函数
	 */
	private static long g(int num) {
		return sum(parse(num));
	}

	/**
	 * getLuckyNum
	 */
	private static int getLuckyNum(int num) {
		int count = 0;
		for (int i = 0; i <= num; i++) {
			if (f(i) == g(i)) {
				// System.out.println("i -> " + i + " | f(i) -> " + f(i) + " | parse(i) -> " + parse(i) + " | g(i) -> " + g(i));
				count++;
			}
		}
		return count;
	}
}
