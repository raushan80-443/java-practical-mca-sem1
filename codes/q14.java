/*
 * Q14: JDBC Connectivity (MySQL Database Operations)
 * Question: Establish database connectivity between Java applications and MySQL database using JDBC API and execute standard CRUD operations.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class q14 {
    // JDBC connection string: jdbc:<driver>://<host>:<port>/<database>
    private static final String URL = "jdbc:mysql://localhost:3306/mca_db";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // 1. Load MySQL JDBC Driver class into memory
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Establish connection to the MySQL server
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to MySQL Database.");

            // 3. CREATE / INSERT using PreparedStatement (prevents SQL injection via '?' placeholders)
            String insertQuery = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, "John Doe");       // Bind 1st '?'
            pstmt.setString(2, "john@example.com"); // Bind 2nd '?'
            pstmt.executeUpdate();                  // Use executeUpdate() for INSERT/UPDATE/DELETE
            System.out.println("Inserted record into database.");

            // 4. READ using SELECT and ResultSet
            String selectQuery = "SELECT * FROM users";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            ResultSet rs = selectStmt.executeQuery(); // Use executeQuery() for SELECT
            while (rs.next()) { // Advance cursor row-by-row
                System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("name") + " | Email: " + rs.getString("email"));
            }

            // 5. Close database connection
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("JDBC Error: " + e.getMessage());
        }
    }
}
