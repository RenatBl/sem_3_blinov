package ru.itis.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
    private static Connection connection;
    private final String url = "jdbc:postgresql://localhost:5432/sem_3";
    private final String name = "postgres";
    private final String password = "123990";

    private ConnectionService() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            ConnectionService connectionService = new ConnectionService();
        }
        return connection;
    }
}
