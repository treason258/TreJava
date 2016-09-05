package com.mjiayou.trejava;


public class Main {

	public static void main(String[] args) {
		System.out.println("**************** BEGIN ****************");

		// DateUtil.getAgeAndZodicaTest();
		// System.out.println("");
		// DateUtil.getConstellationTest();

		// 计算等级
		// for (int i = 0; i < 50; i++) {
		// System.out.println(i + " -> " + getNextGradeIntegral(i));
		// }

		// 编写一个函数将一个十六进制数的字符串参数转换成整数返回。
		// String str = "abcd";
		// int len = str.length();
		// int sum = 0;
		// for (int i = 0; i < len; i++) {
		// char c = str.charAt(len - 1 - i);
		// int n = Character.digit(c, 16);
		// sum += n * (1 << (4 * i));
		// }
		// System.out.println("sum -> " + sum);
		// System.out.println("sum -> " + Integer.parseInt(str, 16));

		// 任意数字序列“123456”之类，输出它们所有的排列组合
		// String str = "123456";
		// char[] arr1 = str.toCharArray();
		// char[] arr2 = java.util.Arrays.copyOf(arr1, arr1.length);
		// for (int i = 0; i < arr1.length - 1; i++) {
		// for (int j = i + 1; j < arr2.length; j++) {
		// System.out.println(arr1[i] + "," + arr2[j]);
		// }
		// }

		// StringTokenizer st = new StringTokenizer("this,is,a,test", ",");
		// while (st.hasMoreTokens()) {
		// System.out.println(st.nextToken());
		// }
		//
		// String[] result = "this,is,a,test".split(",");
		// for (int i = 0; i < result.length; i++) {
		// System.out.println(result[i]);
		// }

		// TreeMap<String, String> treeMap = new TreeMap<>();
		// HashMap<String, String> hashMap = new HashMap<>();
		// Hashtable<String, String> hashtable = new Hashtable<>();
		//
		// TreeSet<String> treeSet = new TreeSet<>();
		// ArrayList<String> arratList = new ArrayList<>();
		// Vector<String> vector = new Vector<>();
		//
		// Stack<String> stack = new Stack<>();

		System.out.println("**************** END ****************");
	}

//	private static int getNextGradeIntegral(int grade) {
//		return (grade * grade - 1) * 50;
//	}
}
