package com.mjiayou.trejava.module.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String content = readTxt("/Users/treason/Documents/Projects/TreJava/src/com/mjiayou/trejava/module/test/PatternTest.txt");
        String regex = "https://www.tuchuang188.com.*?.jpg";
        matcher(content, regex);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void matcher(String content, String regex) {
        System.out.println(content);
        System.out.println(regex);

        System.out.println("~~~~~~~~");

        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(content);
        int i = 0;
        while (matcher.find()) {
            i++;
            String match = matcher.group();
            System.out.println(match);

//            System.out.println(i + " -111- " + match);
//            Matcher matcher2 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(match);
//            if (matcher2.find()) {
//                System.out.println(i + " -222- " + match);
//            }
        }
    }

    /**
     * 传入txt路径读取txt文件
     */
    public static String readTxt(String txtPath) {
        File file = new File(txtPath);
        if (file.isFile() && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuffer buffer = new StringBuffer();
                String text = null;
                while ((text = bufferedReader.readLine()) != null) {
                    buffer.append(text);
                }
                return buffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
