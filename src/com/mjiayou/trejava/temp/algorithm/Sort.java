package com.mjiayou.trejava.temp.algorithm;

public class Sort {

	public static int[] mUnsortedArray;

	public static void main(String[] args) {

		System.out.println();
		mUnsortedArray = getDefaultArray();
		System.out.println("**************** 原始数据 ****************");
		printArray(mUnsortedArray);
		System.out.println("**************** insertSort ****************");
		insertSort(mUnsortedArray);
		printArray(mUnsortedArray);

		System.out.println();
		mUnsortedArray = getDefaultArray();
		System.out.println("**************** 原始数据 ****************");
		printArray(mUnsortedArray);
		System.out.println("**************** binInsertSort ****************");
		binInsertSort(mUnsortedArray);
		printArray(mUnsortedArray);

	}

	/**
	 * 插入排序
	 */
	public static int[] insertSort(int[] array) {
		int i, j;
		int key;
		for (i = 1; i < array.length - 1; i++) {
			key = array[i]; // 保存当前操作为key

			j = i - 1; // j指向i的前一位
			while (j >= 0 && array[j] > key) { // 当j大于low，并且j指向的数据大于key，则key向前移动，j递减
				array[j + 1] = array[j]; // 前移
				j--; // 递减
			}
			array[j + 1] = key; // 放在合适的位置
		}
		return array;
	}

	/**
	 * 二分插入排序
	 */
	public static void binInsertSort(int[] array) {
		int i, j;
		int key;
		int low, high, middle;
		for (i = 1; i < array.length - 1; i++) {
			printArray(array);
			key = array[i];

			low = 0;
			high = array.length - 1;
			while (low <= high) {
				middle = (low + high) / 2;
				if (array[middle] > key) {
					high = middle - 1;
				} else {
					low = middle + 1;
				}
			}

			for (j = i - 1; j >= low; j--) {
				array[j + 1] = array[j];
			}
			array[low] = key;
		}
	}

	/**
	 * 快速排序
	 */

	/**
	 * 选择排序
	 */

	/**
	 * 冒泡排序
	 */
	
	// ******************************** util ********************************

	/**
	 * 返回数组
	 */
	public static int[] getDefaultArray() {
		int[] DEFAULT_ARRAY = { 5, 8, 1, 3, 29, 30, 27, 18, 23, 9, 22, 15, 32, 41, 39, 13 };
		return DEFAULT_ARRAY;
	}

	/**
	 * 打印数组
	 */
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
