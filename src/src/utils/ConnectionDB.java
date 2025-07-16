package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/ss16?createDatabaseIfNotExist=true";
    private static final String username = "root";
    private static final String password = "10122001@";

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}