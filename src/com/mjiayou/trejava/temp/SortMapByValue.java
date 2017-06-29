package com.mjiayou.trejava.temp;

import java.util.*;

/**
 * Created by treason on 2017/2/28.
 */
public class SortMapByValue {

    public static void main(String[] args) {
        TreeMap<String, Integer> newMap = new TreeMap<String, Integer>();
        newMap.put("dsaf1", 1);
        newMap.put("dsaf9", 9);
        newMap.put("dsaf4", 4);
        newMap.put("dsaf7", 7);
        newMap.put("dsaf6", 6);
        newMap.put("dsaf3", 3);
        newMap.put("dsaf10", 10);

        ByValueComparator bvc = new ByValueComparator(newMap);
        List<String> newList = new ArrayList<String>(newMap.keySet());
        Collections.sort(newList, bvc);
        for (String str : newList) {
            System.out.println(str + "=================================" + newMap.get(str));
        }
    }

    /**
     * @description 对HashMap按值进行排序
     */
    static class ByValueComparator implements Comparator<String> {

        TreeMap<String, Integer> base_map;

        public ByValueComparator(TreeMap<String, Integer> base_map) {
            this.base_map = base_map;
        }

        public int compare(String arg0, String arg1) {
            if (!base_map.containsKey(arg0) || !base_map.containsKey(arg1)) {
                return 0;
            }

            if (base_map.get(arg0) < base_map.get(arg1)) {
                return 1;
            } else if (base_map.get(arg0) == base_map.get(arg1)) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
