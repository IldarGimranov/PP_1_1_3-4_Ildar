package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CON_URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static Connection conn = null;

    private Util() {
    }

    public static Connection getConnect() {

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }// реализуйте настройку соеденения с БД
}
