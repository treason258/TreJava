package com.mjiayou.trejava.temp;

public class Dpi {
    private static double width = 480f;
    private static double length = 854f;
    private static double dpi = 240f;
    private static double size = 0f;

    public static void main(String[] arg0) {
        size = (Math.sqrt((width * width) + (length * length))) / dpi;
        System.out.println("width:" + width + "\nlength:" + length + "\ndpi:" + dpi + "\nsize:" + size);
    }
}