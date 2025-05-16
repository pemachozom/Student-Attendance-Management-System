import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        // Get the instance of DatabaseConnection
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

        // Get the database connection
        Connection connection = databaseConnection.getConnection();

        if (connection != null) {
            System.out.println("Connected to the database!");
            // Do your database operations here
        } else {
            System.out.println("Failed to connect to the database!");
        }

        // Close the database connection
        databaseConnection.closeConnection();
    }
}