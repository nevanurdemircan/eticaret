package org.example;

import org.example.service.UIService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/eticaret";
    private static final String USER = "postgres";
    private static final String PASSWORD = "mysecretpassword";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            UIService uiService = new UIService();

           Start.start(connection, uiService);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}