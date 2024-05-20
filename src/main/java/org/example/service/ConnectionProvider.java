package org.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static final String URL = "jdbc:postgresql://localhost:5432/eticaret";
    private static final String USER = "postgres";
    private static final String PASSWORD = "mysecretpassword";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
