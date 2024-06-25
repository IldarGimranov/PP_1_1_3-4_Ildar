package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CON_URL = "jdbc:mysql://localhost:3306/mydbtest";

    public static Connection getConnect() {
    //public static void main(String[] args) {
    Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            //return conn;
            conn.setAutoCommit(false);
            //System.out.print("ok");
            //System.out.print(conn.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.print("ne ok");
        } catch (ClassNotFoundException e) {
            //System.out.print("ne ok2");
            throw new RuntimeException(e);
        }
       return conn;
    }// реализуйте настройку соеденения с БД
}
