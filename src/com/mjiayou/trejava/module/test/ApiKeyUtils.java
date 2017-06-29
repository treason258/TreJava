package com.mjiayou.trejava.module.test;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.CollationKey;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.*;

/**
 * 超级宝项目ApiKey计算算法，两种方式比较
 */
public class ApiKeyUtils {

    private static String KEY_1 = "def", VALUE_1 = "V 2.2.1 debug";
    private static String KEY_2 = "abc", VALUE_2 = "44";
    private static String KEY_3 = "xyz", VALUE_3 = "123";

    public static void main(String[] args) {
        List<NameValuePair> paramsX = new ArrayList<>();
        paramsX.add(new NameValuePair() {
            @Override
            public String getName() {
                return KEY_1;
            }

            @Override
            public String getValue() {
                return VALUE_1;
            }
        });
        paramsX.add(new NameValuePair() {
            @Override
            public String getName() {
                return KEY_2;
            }

            @Override
            public String getValue() {
                return VALUE_2;
            }
        });
        paramsX.add(new NameValuePair() {
            @Override
            public String getName() {
                return KEY_3;
            }

            @Override
            public String getValue() {
                return VALUE_3;
            }
        });
        System.out.println("******************************** xUtils ********************************");
        System.out.println("getApiKey(paramsX) -> " + getApiKey(paramsX));
        System.out.println("******************************** OkHttp ********************************");
        Map<String, String> paramsOK = new TreeMap<>();
        paramsOK.put(KEY_1, VALUE_1);
        paramsOK.put(KEY_2, VALUE_2);
        paramsOK.put(KEY_3, VALUE_3);
        System.out.println("getApiKey(paramsOK) -> " + getApiKey(paramsOK));
        System.out.println("******************************** END ********************************");
    }

    /**
     * zoudong
     *
     * @param params
     * @return
     */
    public static String getApiKey(List<NameValuePair> params) {
        String source = getSource(params);
        System.out.println("source = " + source);
        String md5 = md5(source);
        System.out.println("md5 = " + md5);
        char[] carr = md5.toCharArray();
        return new String(new char[]{carr[20], carr[15], carr[0], carr[3], carr[1], carr[5]});
    }

    private static String getSource(List<NameValuePair> params) {
        StringBuffer sb = new StringBuffer();
        List<NameValuePair> list = getList(params);
        for (int i = 0; i < list.size(); i++) {
            NameValuePair nameValuePair = list.get(i);
            System.out.println(nameValuePair.getName() + " = " + nameValuePair.getValue());
            sb.append(nameValuePair.getName());
            sb.append("=");
            if (nameValuePair.getValue() != null) {
                sb.append(nameValuePair.getValue());
            }
            if (i < list.size() - 1) {
                sb.append("&");
            } else {
                sb.append("m1K5@BcxUn!");
            }
        }
        return sb.toString();
    }

    public static List<NameValuePair> getList(List<NameValuePair> list) {
        /*
         * 排序
         */
        if (list == null || list.size() == 0)
            return null;

        Collections.sort(list, new Comparator<NameValuePair>() {
            private RuleBasedCollator collator = (RuleBasedCollator) Collator.getInstance(java.util.Locale.ENGLISH);

            @Override
            public int compare(NameValuePair lhs, NameValuePair rhs) {
                CollationKey c1 = collator.getCollationKey(lhs.getName());
                CollationKey c2 = collator.getCollationKey(rhs.getName());
                return collator.compare(c1.getSourceString(), c2.getSourceString());
            }
        });
        return list;
    }

    public static String md5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // ******************************** okhttp ********************************

    public static String getApiKey(Map<String, String> params) {
        String source = getSource(params);
        System.out.println("source = " + source);
        String md5 = md5(source);
        System.out.println("md5 = " + md5);
        char[] carr = md5.toCharArray();
        return new String(new char[]{carr[20], carr[15], carr[0], carr[3], carr[1], carr[5]});
    }

    private static String getSource(Map<String, String> params) {
        // 对KEY排序
        List<String> keyList = new ArrayList<>(params.keySet());
        Collections.sort(keyList, new EnglishComparator());

        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (String key : keyList) {
            System.out.println(key + " = " + params.get(key));
            builder.append(key);
            builder.append("=");
            if (params.get(key) != null) {
                builder.append(params.get(key));
            }
            if (index < keyList.size() - 1) {
                builder.append("&");
            } else {
                builder.append("m1K5@BcxUn!");
            }
            index++;
        }
        return builder.toString();
    }

    /**
     * EnglishComparator
     */
    private static class EnglishComparator implements Comparator<String> {

        private RuleBasedCollator collator = (RuleBasedCollator) Collator.getInstance(java.util.Locale.ENGLISH);

        public int compare(String o1, String o2) {
            CollationKey c1 = collator.getCollationKey(o1);
            CollationKey c2 = collator.getCollationKey(o2);
            return collator.compare(c1.getSourceString(), c2.getSourceString());
        }
    }
}
