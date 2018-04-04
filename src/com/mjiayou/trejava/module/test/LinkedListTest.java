package com.mjiayou.trejava.module.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by treason on 2017/8/11.
 */
public class LinkedListTest {

//    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger("LinkedListTest");
//
//    private static Stopwatch stopWatch = new Stopwatch();
//
//    public static void testList(int num) {
//        List<String> aList = new ArrayList<String>();
//        List<String> lList = new LinkedList<String>();
//        stopWatch.reset();
//        stopWatch.start();
//        for (int i = 0; i < num; i++) {
//            aList.add("201411180827 cctv5_800   83  796.03  115.182.51.134  123.125.89.75   in  uuid1   5");
//        }
//        LOGGER.info("insert num:{} ArrayList cost:{} ms", num, stopWatch.elapsedTime(TimeUnit.MILLISECONDS));
//
//        stopWatch.reset();
//        stopWatch.start();
//        for (int i = 0; i < num; i++) {
//            lList.add("201411180827 cctv5_800   83  796.03  115.182.51.134  123.125.89.75   in  uuid1   5");
//        }
//        LOGGER.info("insert num:{} LinkedList cost:{} ms", num, stopWatch.elapsedTime(TimeUnit.MILLISECONDS));
//    }

//    public static void main(String[] args) throws InterruptedException, IOException {
//        int[] nums = {10000, 10 * 10000, 100 * 10000, 1000 * 10000, 10000 * 10000};
//
//        for (int i = 0; i < nums.length; i++) {
//            testList(nums[i]);
//        }
//    }

    public static void main(String[] args) {
        Random random = new Random(10);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0, 0);
        long startArray = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
//            arrayList.add(arrayList.size() / 2, i);
//            arrayList.add(0, i);
//            arrayList.add(arrayList.size(), i);
            arrayList.add(random.nextInt(arrayList.size()), i);
        }
        System.out.println("ArrayList -> " + (System.currentTimeMillis() - startArray));

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0, 0);
        long startLinked = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
//            linkedList.add(linkedList.size() / 2, i);
//            linkedList.add(0, i);
//            linkedList.add(linkedList.size(), i);
            linkedList.add(random.nextInt(linkedList.size()), i);
        }
        System.out.println("LinkedList -> " + (System.currentTimeMillis() - startLinked));
    }
}