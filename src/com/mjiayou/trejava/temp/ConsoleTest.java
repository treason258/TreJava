package com.mjiayou.trejava.temp;

import java.util.Scanner;

public class ConsoleTest {

	public static void main(String[] args) {

		String account = "";
		String password = "";
		String confirm = "";

		Scanner scanner = new Scanner(System.in);

		System.out.println("请输入账号：");
		account = scanner.next();
		System.out.println("请输入密码：");
		password = scanner.next();

		System.err.println("\n输入信息为：");
		System.err.println("账号：" + account);
		System.err.println("密码：" + password);
		
		System.err.println("\n确认信息(y/n)：");
		confirm = scanner.next();
		
		if (confirm.equals("y")) {
			System.out.println("你输入y");
		} else if (confirm.equals("n")) {
			System.out.println("你输入n");
		} else {
			System.out.println("输入有误，请重新输入");
		}

		scanner.close();
	}
}
