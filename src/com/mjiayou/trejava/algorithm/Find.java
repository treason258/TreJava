package com.mjiayou.trejava.algorithm;

public class Find {

	public static int[] mSortedData = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

	public static void main(String[] args) {
		
		System.out.println("**************** 二分查找算法 ****************");
		System.out.println("binarySearchA -> " + binarySearchA(mSortedData, 6));
		System.out.println("binarySearchB -> " + binarySearchB(mSortedData, 6));
		
	}

	/**
	 * 二分查找算法-递归
	 */
	public static int binarySearchA(int[] array, int key) {
		return binarySearchACore(array, 0, array.length - 1, key);
	}

	public static int binarySearchACore(int[] array, int low, int high, int key) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (key == array[mid])
				return mid;
			else if (key < array[mid]) // 移动low和high
				return binarySearchACore(array, low, mid - 1, key);
			else if (key > array[mid])
				return binarySearchACore(array, mid + 1, high, key);
		}
		return -1;
	}

	/**
	 * 二分查找算法-非递归
	 */
	public static int binarySearchB(int[] array, int key) {
		int low = 0; // 第一个位置
		int high = array.length - 1; // 最高位置，数组长度-1，因为下标是从0开始的
		while (low <= high) { // 当low"指针"和high不重复的时候
			int middle = low + ((high - low) >> 1); // 中间位置计算，low+ 最高位置减去最低位置,右移一位,相当于除2.也可以用(high+low)/2
			if (key == array[middle]) { // 与最中间的数字进行判断，是否相等，相等的话就返回对应的数组下标.
				return middle;
			} else if (key < array[middle]) { // 如果小于的话则移动最高层的"指针"
				high = middle - 1;
			} else { // 移动最低的"指针"
				low = middle + 1;
			}
		}
		return -1;
	}
}
