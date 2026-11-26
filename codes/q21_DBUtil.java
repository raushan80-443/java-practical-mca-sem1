/*
 * Q21: Login & Registration Web Application - MVC (Database Utility)
 * Question: Architect and implement a multi-page web application featuring Database Persistence, Servlets, JSP Views, and Session Management under the MVC architecture.
 */

package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Centralized JDBC connection helper for the MVC app
public class q21_DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Static initializer loads the MySQL JDBC driver once when the class is loaded
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Returns a new database connection for servlets to use
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
