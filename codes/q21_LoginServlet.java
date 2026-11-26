/*
 * Q21: Login & Registration Web Application - MVC (Login Servlet)
 * Question: Architect and implement a multi-page web application featuring Database Persistence, Servlets, JSP Views, and Session Management under the MVC architecture.
 */

package com.app.servlet;

import com.app.util.q21_DBUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Controller Servlet mapped to /login (authenticates user and creates HttpSession)
@WebServlet("/login")
public class q21_LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Read credentials from login.jsp
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");

        try (Connection conn = q21_DBUtil.getConnection()) {
            // Verify username and password against the users table
            String sql = "SELECT full_name FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Valid user: store identity in server-side HttpSession
                HttpSession session = req.getSession();
                session.setAttribute("user", uname);
                session.setAttribute("name", rs.getString("full_name"));
                resp.sendRedirect("welcome.jsp");
            } else {
                // Invalid credentials: redirect back to login with error flag
                resp.sendRedirect("login.jsp?error=InvalidCredentials");
            }
        } catch (Exception e) {
            resp.sendRedirect("login.jsp?error=ServerError");
        }
    }
}
