package com.mjiayou.trejava.test.acmcoder;

import java.util.Scanner;

public class JD1 {

	int[] m1;
	int[] m2;
	String[] m3;
	int i = 0;
	int sum1 = 0;
	int sum2 = 0;
	int n2;
	int n3;
	Scanner n1;

	public void in() {
		n1 = new Scanner(System.in);
		n2 = n1.nextInt();
		n3 = n1.nextInt();
		m1 = new int[n2];
		m2 = new int[n2];
		for (int i = 0; i < n2; i++) {
			m3[i] = n1.next();

		}
		for (int i = 0; i < n3; i++) {
			m1[i] = n1.nextInt();
			m2[i] = m1[i];
		}
	}

	public void max() {
		for (int i = 0; i < n3; i++) {
			int m = m1[0];
			int flag = 0;
			for (int j = 1; j < n2; j++) {

				if (m < m1[j]) {
					m = m1[j];
					flag = j;
				}
			}

			sum1 = sum1 + m;
			m1[flag] = 0;

		}
	}

	public void mal() {
		for (int i = 0; i < n3; i++) {

			int n = m2[0];
			int flag1 = 0;
			for (int j = 1; j < n2; j++) {
				if (n > m2[j]) {
					n = m2[j];
					flag1 = j;
				}
			}
			sum2 = sum2 + n;
			m2[flag1] = 100;

		}
	}

	public void out() {
		System.out.print(sum2 + "  " + sum1);
	}

	public static void main(String[] args) {
		JD1 yi = new JD1();
		yi.in();
		yi.max();
		yi.mal();
		yi.out();
	}
}
