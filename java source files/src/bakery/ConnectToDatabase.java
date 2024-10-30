package bakery;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectToDatabase {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Register driver and get the connection using username - root and password - 12345678
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery", "root", "12345678");
            return conn;
        } catch (SQLException e) {
            // Displays dialog if connection cannot be established
            JOptionPane.showMessageDialog(null, "Connection cannot be established: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            // Displays dialog if driver class is not found
            JOptionPane.showMessageDialog(null, "MySQL Driver not found: " + e.getMessage());
            return null;
        }
    }
}