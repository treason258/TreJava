package com.mjiayou.trejava.framework.util;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Properties;

/**
 * Created by treason on 2017/6/29.
 */
public class ConvertUtil {

    /**
     * Map TO String
     */
    public static String parseString(Map data) {
        if (data == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Object key : data.keySet()) {
            builder.append(key).append(" = ").append(data.get(key) == null ? "null" : data.get(key).toString()).append("\r\n");
        }
        return builder.toString();
    }

    /**
     * Properties TO String
     */
    public static String parseString(Properties data) {
        if (data == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Object key : data.keySet()) {
            builder.append(key).append(" = ").append(data.get(key) == null ? "null" : data.get(key).toString()).append("\r\n");
        }
        return builder.toString();
    }

    /**
     * Class TO String
     */
    public static String parseString(Class clazz) {
        if (clazz == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                builder.append(field.getName()).append(" = ").append(field.get(null) == null ? "null" : field.get(null).toString()).append("\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }
}
