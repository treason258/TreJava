package com.mjiayou.trejava.module.system;

import com.mjiayou.trejava.framework.util.ConvertUtil;

import java.util.Properties;

/**
 * 打印一些系统信息
 */
public class SystemInfo {

    public static void main(String[] args) {

        System.out.println("**************** Runtime.getRuntime() ****************");
        System.out.print("Runtime.getRuntime()");//Runtime.getRuntime()获取当前运行时的实例
        System.out.print("CPU个数：");//Runtime.getRuntime()获取当前运行时的实例
        System.out.println(Runtime.getRuntime().availableProcessors()); // availableProcessors()获取当前电脑CPU数量
        System.out.print("虚拟机内存总量：");
        System.out.println(Runtime.getRuntime().totalMemory()); // totalMemory()获取java虚拟机中的内存总量
        System.out.print("虚拟机空闲内存量：");
        System.out.println(Runtime.getRuntime().freeMemory()); // freeMemory()获取java虚拟机中的空闲内存量
        System.out.print("虚拟机使用最大内存量：");
        System.out.println(Runtime.getRuntime().maxMemory()); // maxMemory()获取java虚拟机试图使用的最大内存量

        System.out.println("**************** System.getProperties() ****************");
        Properties properties = System.getProperties(); // 获取当前的系统属性
        System.out.println("Java的运行环境版本：" + properties.getProperty("java.version"));
        System.out.println("Java的运行环境供应商：" + properties.getProperty("java.vendor"));
        System.out.println("Java供应商的URL：" + properties.getProperty("java.vendor.url"));
        System.out.println("Java的安装路径：" + properties.getProperty("java.home"));
        System.out.println("Java的虚拟机规范版本：" + properties.getProperty("java.vm.specification.version"));
        System.out.println("Java的虚拟机规范供应商：" + properties.getProperty("java.vm.specification.vendor"));
        System.out.println("Java的虚拟机规范名称：" + properties.getProperty("java.vm.specification.name"));
        System.out.println("Java的虚拟机实现版本：" + properties.getProperty("java.vm.version"));
        System.out.println("Java的虚拟机实现供应商：" + properties.getProperty("java.vm.vendor"));
        System.out.println("Java的虚拟机实现名称：" + properties.getProperty("java.vm.name"));
        System.out.println("Java运行时环境规范版本：" + properties.getProperty("java.specification.version"));
        System.out.println("Java运行时环境规范供应商：" + properties.getProperty("java.specification.vender"));
        System.out.println("Java运行时环境规范名称：" + properties.getProperty("java.specification.name"));
        System.out.println("Java的类格式版本号：" + properties.getProperty("java.class.version"));
        System.out.println("Java的类路径：" + properties.getProperty("java.class.path"));
        System.out.println("加载库时搜索的路径列表：" + properties.getProperty("java.library.path"));
        System.out.println("默认的临时文件路径：" + properties.getProperty("java.io.tmpdir"));
        System.out.println("一个或多个扩展目录的路径：" + properties.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称：" + properties.getProperty("os.name"));
        System.out.println("操作系统的构架：" + properties.getProperty("os.arch"));
        System.out.println("操作系统的版本：" + properties.getProperty("os.version"));
        System.out.println("文件分隔符：" + properties.getProperty("file.separator"));   //在 unix 系统中是＂／＂
        System.out.println("路径分隔符：" + properties.getProperty("path.separator"));   //在 unix 系统中是＂:＂
        System.out.println("行分隔符：" + properties.getProperty("line.separator"));   //在 unix 系统中是＂/n＂
        System.out.println("用户的账户名称：" + properties.getProperty("user.name"));
        System.out.println("用户的主目录：" + properties.getProperty("user.home"));
        System.out.println("用户的当前工作目录：" + properties.getProperty("user.dir"));
        System.out.println("******** System.getProperties() ********");
        System.out.println(ConvertUtil.parseString(properties));
        // properties.list(System.out); // 将属性列表输出，但是显示不完整
    }
}
