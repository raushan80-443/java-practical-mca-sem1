/*
 * Q17: Connect Java to a Database Using JDBC
 * Question: Construct a complete JDBC application that connects to a MySQL database, queries records from a Students table, and displays them.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class q17 {
    public static void main(String[] args) {
        // MySQL connection URL, username, and password
        String dbUrl = "jdbc:mysql://localhost:3306/university";
        String user = "root";
        String password = "password";

        try {
            // Load MySQL JDBC Driver and open connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, user, password);
            // Create a Statement object for executing static SQL queries
            Statement stmt = con.createStatement();

            // Execute SELECT query and store rows in ResultSet
            ResultSet rs = stmt.executeQuery("SELECT roll_no, name, course FROM Students");

            System.out.println("Roll No\tName\t\tCourse");
            System.out.println("------------------------------------");
            // Iterate through all returned rows (1-based column indices)
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }

            con.close(); // Release DB connection
        } catch (Exception e) {
            System.err.println("Database Exception: " + e.getMessage());
        }
    }
}
