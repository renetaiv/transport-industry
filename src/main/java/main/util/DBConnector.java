package main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    public static final String DB_HOSTNAME = "127.0.0.1";
    public static final String DB_PORT = "3306";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "root";
    private static DBConnector instance;
    private Connection connection;

    private DBConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOSTNAME + ":" + DB_PORT + "/vehicle",
                    DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to use MySQL. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error communicating with MySQL database. " + e.getMessage());
        }
    }

    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
