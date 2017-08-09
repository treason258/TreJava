package com.mjiayou.trejava.module.test;

import java.util.ArrayList;

/**
 * Created by treason on 2017/8/9.
 */
public class ArrayListTest {

    public static void main(String[] args) {

        System.out.println("**************** BEGIN ****************");

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(new Integer(1));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i));
        }

        System.out.println("**************** END ****************");
    }
}
