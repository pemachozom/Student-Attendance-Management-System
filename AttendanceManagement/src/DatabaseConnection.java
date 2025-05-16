// Singleton pattern
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Static variable to hold the single instance of the DatabaseConnection class
    private static DatabaseConnection instance = null;
    // Database connection object
    private Connection connection;

    // Private constructor to prevent instantiation from outside
    private DatabaseConnection() {
        try {
            // Register MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            String url = "jdbc:mysql://localhost:3306/designpattern";
            String username = "root"; 
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the single instance of DatabaseConnection class
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }

    // Method to close the database connection
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}