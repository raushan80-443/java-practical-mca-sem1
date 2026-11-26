<%--
    Q21: Login & Registration Web Application - MVC (Register JSP)
    Question: Architect and implement a multi-page web application featuring Database Persistence, Servlets, JSP Views, and Session Management under the MVC architecture.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Register</title></head>
<body>
    <h2>User Registration</h2>
    <%-- Submits registration data via POST to RegisterServlet (/register) --%>
    <form action="register" method="POST">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        Full Name: <input type="text" name="fullname" required><br><br>
        <input type="submit" value="Register">
    </form>
    <a href="login.jsp">Already have an account? Login here</a>
</body>
</html>
