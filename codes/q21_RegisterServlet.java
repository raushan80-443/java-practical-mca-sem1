/*
 * Q21: Login & Registration Web Application - MVC (Register Servlet)
 * Question: Architect and implement a multi-page web application featuring Database Persistence, Servlets, JSP Views, and Session Management under the MVC architecture.
 */

package com.app.servlet;

import com.app.util.q21_DBUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller Servlet mapped to /register (handles POST from register.jsp)
@WebServlet("/register")
public class q21_RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Read form parameters submitted by register.jsp
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        String fname = req.getParameter("fullname");

        // Open DB connection using try-with-resources (auto-closes connection)
        try (Connection conn = q21_DBUtil.getConnection()) {
            // Parameterized INSERT prevents SQL injection
            String sql = "INSERT INTO users (username, password, full_name) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pass);
            ps.setString(3, fname);
            ps.executeUpdate();

            // Redirect to login page on success
            resp.sendRedirect("login.jsp?msg=RegisteredSuccessfully");
        } catch (Exception e) {
            // Redirect back to registration page on error (e.g., duplicate username)
            resp.sendRedirect("register.jsp?error=RegistrationFailed");
        }
    }
}
