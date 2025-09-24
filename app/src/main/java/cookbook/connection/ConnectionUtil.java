package cookbook.connection;

import java.sql.*;
import javax.swing.*;

public class ConnectionUtil {
    PreparedStatement preparedStatement = null;

    Connection conn = null;

    public static Connection connectDB() {
      
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Cookbook", "root", "root");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}