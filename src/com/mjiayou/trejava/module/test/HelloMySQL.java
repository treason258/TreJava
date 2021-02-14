package com.mjiayou.trejava.module.test;

import java.sql.*;

/**
 * 依赖
 * mysql-connector-java-8.0.23.jar
 * mysql-connector-java-5.1.49-bin.jar
 */
public class HelloMySQL {

    // 数据库信息
    private static final String SERVER = "rm-m5e85ld74c05t03o7qo.mysql.rds.aliyuncs.com:3306"; // MySQL服务器地址
    private static final String USERNAME = "treason258"; // MySQL用户名
    private static final String PASSWORD = "xiaoyaA258"; // MySQL密码
    private static final String DATABASE = "treason"; // 数据库名称

    // 是否 MySQL 8.0 以上版本
    private static boolean isMySQL8 = false;
    private static final String JDBC_DRIVER = isMySQL8 ? "com.mysql.cj.jdbc.Driver" : "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://" + SERVER + "/" + DATABASE + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // JDBC连接开始
            System.out.println("JDBC连接开始...");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // 实例化Statement对象
            System.out.println("实例化Statement对象...");
            statement = connection.createStatement();

            // 执行查询
            String sql = "select * from timeline;";
            ResultSet resultSet = statement.executeQuery(sql);

            // 展开结果集数据库
            while (resultSet.next()) {
                // 通过字段检索
                int id = resultSet.getInt("id");
                String date_start = resultSet.getString("date_start");
                String date_end = resultSet.getString("date_end");
                String type = resultSet.getString("type");
                String content = resultSet.getString("content");
                String comment1 = resultSet.getString("comment1");
                String comment2 = resultSet.getString("comment2");

                // 输出数据
                System.out.print("data");
                System.out.print(", id: " + id);
                System.out.print(", date_start: " + date_start);
                System.out.print(", date_end: " + date_end);
                System.out.print(", type: " + type);
                System.out.print(", content: " + content);
                System.out.print(", comment1: " + comment1);
                System.out.print(", comment2: " + comment2);
                System.out.print("\n");
            }

            // 完成后关闭
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
