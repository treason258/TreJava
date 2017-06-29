package com.mjiayou.trejava.temp;

import java.text.CollationKey;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.*;

/**
 * Created by treason on 2017/2/28.
 */
public class SortMapByKey {

    public static void main(String[] args) {
        Map<String, String> params = new TreeMap<>();
        params.put("device", "1");
        params.put("appver", "9");
        params.put("os", "4");
        params.put("token_cityid", "7");
        params.put("k", "7");
        params.put("f", "7");
        params.put("e", "7");
        params.put("c", "7");
        params.put("b", "7");

        List<String> keyList = new ArrayList<>(params.keySet());
        keyList.sort(new EnglishComparator());
        for (String key : keyList) {
            System.out.println(key + " = " + params.get(key));
        }
    }

    /**
     * EnglishComparator
     */
    static class EnglishComparator implements Comparator<String> {

        private RuleBasedCollator collator = (RuleBasedCollator) Collator.getInstance(java.util.Locale.ENGLISH);

        public int compare(String o1, String o2) {
            CollationKey c1 = collator.getCollationKey(o1);
            CollationKey c2 = collator.getCollationKey(o2);
            return collator.compare(c1.getSourceString(), c2.getSourceString());
        }
    }
}
