<%--
    Q21: Login & Registration Web Application - MVC (Login JSP)
    Question: Architect and implement a multi-page web application featuring Database Persistence, Servlets, JSP Views, and Session Management under the MVC architecture.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
    <h2>User Login</h2>
    <%-- Submits login credentials via POST to LoginServlet (/login) --%>
    <form action="login" method="POST">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>
    <a href="register.jsp">Need an account? Register here</a>
</body>
</html>
