package com.xmind.smartschool.config;

import java.sql.Connection;
import java.sql.DriverManager;

import com.xmind.smartschool.utils.Constants;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private Connection connection = null;

    /*
     * Private constructor to prevent instantiation from other classes.
     */
    private DatabaseConnection() {
        try {
            Class.forName(Constants.DRIVER);
            System.out.println("PostgreSQL driver registered");
            connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, Constants.DB_PASSWORD);
            System.out.print("Database connection established.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    /*
     * Get the singleton instance of the DatabaseConnection class.
     */
    public static synchronized DatabaseConnection getInstance() {
        try {
            if (instance == null || instance.getConnection() == null || instance.getConnection().isClosed()) {
                instance = new DatabaseConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to get database connection ", e);
        }
        return instance;
    }

    /*
     * Get the database connection.
     */
    public Connection getConnection() {
        return connection;
    }

    /*
     * Close the database connection.
     */
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
