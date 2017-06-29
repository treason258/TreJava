package com.mjiayou.trejava.temp;

/**
 * Created by treason on 2016/12/21.
 */
public class BitArithmetic {

    public static void main(String[] args) {
        System.out.println("**************** BEGIN ****************");

        long data = 0xffffL;
        long result1 = data & 0x1;
        long result2 = data & 0x10;
        long result3 = data & 0x100;
        long result4 = data & 0xffff;
        System.out.println("result1 -> " + result1);
        System.out.println("result2 -> " + result2);
        System.out.println("result3 -> " + result3);
        System.out.println("result4 -> " + result4);

        // 10进制转16进制
        Integer.toHexString(20);
        // 10进制转2进制
        Integer.toBinaryString(10);
        // 16进制转10进制
        Integer.parseInt("30", 16);

        StringBuilder builder = new StringBuilder();
        builder.append("10")
                .append("\t\t\t").append("16")
                .append("\t\t\t").append("8")
                .append("\t\t\t").append("2")
                .append("\n");
        for (int i = 0; i < 1024; i++) {
            builder.append(i)
                    .append("\t\t\t").append(Integer.toHexString(i)) // 十六进制
                    .append("\t\t\t").append(Integer.toOctalString(i)) // 八进制
                    .append("\t\t\t").append(Integer.toBinaryString(i)) // 二进制
                    .append("\n");
        }
        System.out.println(builder.toString());

        System.out.println("**************** END ****************");
    }
}
