package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
public class JDBCTest {

    @Test
    @DisplayName("JDBC 드라이버 연결이 된다.")
    public void testConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/shop3";
        try(Connection con
                    = DriverManager.getConnection(url, "root", "1234")) {
            System.out.println("---- testConnection>> " + con.getMetaData().getDatabaseProductName());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


//    @Test
//    @Disabled
//    public void test2() {
//
//    }
}
