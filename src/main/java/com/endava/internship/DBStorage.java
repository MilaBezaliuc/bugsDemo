package com.endava.internship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;


public class DBStorage {

    private Set<String> set = Storage.getStorage();

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    static final String USER = "user";
    static final String PASS = "endava";

    public void save() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            for (String s: set){
                System.out.println(s);
                String sql = "INSERT INTO message(text) " +
                        "VALUES (" + s + ")";
                stmt.executeUpdate(sql);
                System.out.println("Inserted " + s + " into the table ");
            }
        } catch (SQLException se) {
            se.getStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.getStackTrace();
            }
        }
    }

    public void delete(String text) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            for (String s: set){
                System.out.println(s);
                String sql = "DELETE  FROM message WHERE text =" + text;
                stmt.executeUpdate(sql);
                System.out.println("Deleted " + text);
            }
        } catch (SQLException se) {
            se.getStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.getStackTrace();
            }
        }
    }
}
