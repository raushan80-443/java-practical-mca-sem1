<%--
    Q21: Login & Registration Web Application - MVC (Welcome JSP)
    Question: Architect and implement a multi-page web application featuring Database Persistence, Servlets, JSP Views, and Session Management under the MVC architecture.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Auth guard: check if user is logged in via HttpSession --%>
<%
    String user = (String) session.getAttribute("user");
    String name = (String) session.getAttribute("name");
    if (user == null) {
        // Redirect unauthenticated visitors back to login page
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head><title>Dashboard</title></head>
<body>
    <%-- Display session attributes using JSP expression tags --%>
    <h1>Welcome, <%= name %>!</h1>
    <p>You have successfully logged into your portal (Username: <%= user %>).</p>
</body>
</html>
