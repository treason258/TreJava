package com.mjiayou.trejava.temp.gamelist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameList {

    public static void main(String[] args) {
        System.out.println("**************** BEGIN ****************");

        ArrayList<String> list = readTXT("/Users/xin/Documents/Projects/TreJava/src/com/mjiayou/trejava/temp/gamelist/gamelist.xml");
        StringBuilder builder = new StringBuilder();
        int line = -4;
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str == null || str.trim().equals("")) {
                continue;
            }
            str = str.trim();
            if (str.contains("<name>")) {
                str = str.replace("<name>", "");
                str = str.replace("</name>", "");
                builder.append(++line).append(line > 999 ? "\t" : "\t\t").append(str).append("\n");
            }
        }
        System.out.println(builder.toString());

        System.out.println("**************** END ****************");
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
