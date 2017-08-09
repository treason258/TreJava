package com.mjiayou.trejava.module.algorithm;

/**
 * Created by treason on 2017/7/25.
 */
public class StringOP1 {

    public static void main(String[] args) {
        System.out.println("**************** StringOP1 ****************");

        String str = "abbbbccdefffggaaaabbccccccccddeffggggg";
        System.out.println(str);
        System.out.println(doFilter0(str));
        System.out.println(doFilter1(str));
        System.out.println(doFilter2(str));
    }

    /**
     * 从一个字符串中剔除连续的字符，只留一个。
     * <p>
     * abbbbccdefffggaaaabbccccccccddeffg -> abcdefgabcdefg
     */
    private static String doFilter0(String str) {
        StringBuilder builder = new StringBuilder(str);
        int offset = 0;
        for (int index = 1; index < str.length(); index++) {
            int before = index - 1;
            if (str.charAt(index) == str.charAt(before)) {
                builder.deleteCharAt(index - offset);
                offset++;
            }
        }
        return builder.toString();
    }

    /**
     * 第一种，从前往后遍历，如果后面的字符与当前的字符相同，就直接跳过，如果不相同，就停止。
     */
    private static String doFilter1(String str) {
        String newString = "";
        int i = 0;
        int j = i + 1;
        newString = newString + str.charAt(i);
        while (j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                j++;

            } else {
                i = j;
                j = i + 1;
                newString = newString + str.charAt(i);
            }
        }

        return newString;
    }

    /**
     * 第二种，是只比较当前字符与前一个字符是否相等，如果相等就删除前一个字符，不相等则直接向下遍历。
     */
    private static String doFilter2(String str) {
        StringBuilder newString = new StringBuilder(str);
        for (int i = 1; i < newString.length(); i++) {
            if (newString.charAt(i) == newString.charAt(i - 1)) {
                newString.deleteCharAt(i - 1);
                i--;
            }
        }
        return newString.toString();
    }
}
