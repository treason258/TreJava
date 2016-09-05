package com.mjiayou.trejava.temp;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		System.out.println("test");

		int[] arr = getRandom();
		for (int i = 0; i < arr.length; i++) {
			System.out.println("" + arr[i]);
		}
		System.out.println("==" + 0 % 1111);

		System.out.println("生成-2到+2的随机数：" + getRandom2());
		System.out.println("生成随机数n的随机数(n=-0.3,-0.2,-0.1,0，0.1,0.2,0.3)：" + getRandom3(-0.3f));
	}

	/**
	 * 获取随机的四位数，不能是1111的整数倍
	 */
	private static int[] getRandom() {
		int[] seed = { 0, 1, 2, 3 };
		int[] result = new int[4];
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int j = random.nextInt(seed.length);
			result[i] = seed[j];
		}

		String strRan = "" + result[0] + result[1] + result[2] + result[3];
		int value = Integer.valueOf(strRan);
		if (value % 1111 == 0) {
			result = getRandom();
		}
		return result;
	}

	/**
	 * 生成-2到+2的随机数
	 */
	private static int getRandom2() {
		Random random = new Random();
		int n = random.nextInt(3); // 生成[0-3)的随机整数：0，1，2
		int p = random.nextInt(2); // 生成[0-2)的随机整数：0，1
		if (p % 2 == 0) { // 如果p=0，则返回正，如果p=1，则返回负
			return n;
		} else {
			return -n;
		}
	}

	/**
	 * 生成随机数n的随机数(n=-0.3,-0.2,-0.1,0，0.1,0.2,0.3)
	 */
	private static float getRandom3(float n) {
		float result = 0f;

		boolean negative = false;
		if (n < 0) {
			negative = true;
			n = -n;
		}

		int nx10 = (int) (n * 10);
		Random random = new Random();
		int radomInt = random.nextInt(nx10 + 1);
		result = radomInt / 10.0f;

		if (negative) {
			result = -result;
		}
		return result;
	}
}
