package com.mjiayou.trejava.module.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class genSQL {

    public static void main(String[] args) {

        System.out.println("~~~~~~~~~~~~~~~~~");

        ArrayList<String> list = readTXT("/Users/treason/Documents/Projects/TreJava/src/com/mjiayou/trejava/module/test/genSQL.txt");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str == null || str.trim().equals("")) {
                continue;
            }
            String[] arr = str.split("\\s+");
            String type_id = arr[0];
            String date_start = arr[1];
            String date_end = arr[2];
            String content = arr[3];
            String remark = arr[4];
            String remark2 = arr[5];
            switch (type_id) {
                case "旅游":
                    type_id = "1";
                    break;
                case "团建":
                    type_id = "2";
                    break;
            }
            if (date_start.length() == 6) {
                date_start = "20" + date_start;
            }
            if (date_end.length() == 6) {
                date_end = "20" + date_end;
            }

//            System.out.print("INSERT INTO timeline_content (type_id, date_start, date_end, content, remark, remark2)");
//            System.out.print(" VALUES (" + type + ", \"" + date_start + "\", \"" + date_end + "\", \"" + content + "\", \"" + remark + "\", \"" + remark2 + "\");");
//            System.out.println();

            String insert = "(" + type_id + ", \"" + date_start + "\", \"" + date_end + "\", \"" + content + "\", \"" + remark + "\", \"" + remark2 + "\")";
            builder.append(insert).append((i == list.size() - 1) ? ";" : ",").append("\n");
        }

        System.out.println("INSERT INTO timeline_content (type_id, date_start, date_end, content, remark, remark2) VALUES ");
        System.out.println(builder.toString());

        System.out.println("~~~~~~~~~~~~~~~~~");
    }

    /**
     * 传入txt路径读取txt文件
     */
    public static ArrayList<String> readTXT(String txtPath) {
        File file = new File(txtPath);
        if (file.isFile() && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                ArrayList<String> list = new ArrayList<>();
                String text;
                while ((text = bufferedReader.readLine()) != null) {
                    list.add(text);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}

