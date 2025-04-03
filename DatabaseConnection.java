import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class handles the connection to the PostgreSQL database.
public class DatabaseConnection {

    // URL for connecting to the PostgreSQL database.
    // Note: We URL-encode spaces in the database name.
    private static final String URL = "jdbc:postgresql://localhost:5432/HRS";
    
    // Database username as provided.
    private static final String USER = "postgres";
    
    // Database password as provided.
    private static final String PASSWORD = "superuser@MRS";

    // Method to establish and return a connection to the database.
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
