<%--
    Q18: Display a Welcome Message Using JSP
    Question: Write a Java Server Page (JSP) file that dynamically renders a customizable welcome header and execution timestamp on a client web browser.
--%>

<%-- Page directive: sets Java as scripting language and UTF-8 HTML output --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Import java.util.Date so we can display the current server timestamp --%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome JSP Page</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
        .card { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
        h1 { color: #2C5282; }
    </style>
</head>
<body>
    <div class="card">
        <h1>Welcome to MCA 1st Semester Java Web Programming!</h1>
        <p>This dynamic response was generated directly by Java Server Pages (JSP).</p>
        <%-- JSP Expression tag <%= ... %> evaluates and prints the Java value into HTML --%>
        <p><strong>Current Server Time:</strong> <%= new Date() %></p>
    </div>
</body>
</html>
