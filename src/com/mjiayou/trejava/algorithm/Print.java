package com.mjiayou.trejava.algorithm;

import java.util.Scanner;

public class Print {

	public static void main(String[] args) {

		printDiamond1();
		printDiamond2();
		printDiamond3();

	}

	/**
	 * 打印实心菱形
	 */
	private static void printDiamond1() {
		System.out.println("打印实心菱形：");

		int line = 9;

		for (int i = 1; i <= line; i++) {
			if (i <= line / 2 + 1) {
				for (int k = 1; k <= line / 2 + 1 - i; k++) {
					System.out.print(" ");
				}
				for (int k = 1; k <= i; k++) {
					System.out.print("* ");
				}
				System.out.println();
			} else {
				for (int k = 1; k <= (i - (line / 2 + 1)); k++) {
					System.out.print(" ");
				}
				for (int k = 1; k <= (2 * (line / 2 + 1) - i); k++) {
					System.out.print("* ");
				}
				System.out.println();
			}
		}
	}

	/**
	 * 打印空心菱形
	 */
	private static void printDiamond2() {
		System.out.println("打印空心菱形：");

		int line = 11;
		int yiban = line / 2 + 1;
		int yibanduo = line / 2;

		for (int k = 1; k <= yiban; k++) {
			for (int i = 1; i <= (yiban - k); i++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int i = 1; i <= ((k - 2) * 2 + 1); i++) {
				System.out.print(" ");
			}
			if (k != 1) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int k = yibanduo; k >= 1; k--) {
			for (int i = 1; i <= (yiban - k); i++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int i = 1; i <= ((k - 2) * 2 + 1); i++) {
				System.out.print(" ");
			}
			if (k != 1) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	/**
	 * 打印指定行数的菱形
	 */
	private static void printDiamond3() {
		System.out.println("打印指定行数的菱形：");
		System.out.print("请输入对应三角形的行数：");

		Scanner scanner = new Scanner(System.in);
		int line = scanner.nextInt();
		scanner.close();

		for (int i = 0; i < line - 1; i++) {
			for (int x = i + 1; x < line; x++) {
				System.out.print(" ");
			}
			for (int y = 0; y < (i + 1) * 2 - 1; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < line; i++) {
			for (int x = 0; x < i; x++) {
				System.out.print(" ");
			}
			for (int y = i; y < 2 * line - i - 1; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
