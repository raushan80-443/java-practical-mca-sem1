<%--
    Q19: Calculate the Sum of Two Numbers Using JSP
    Question: Implement an interactive web form in JSP that receives two numeric inputs from user and dynamically calculates their sum.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Addition Demo</title>
</head>
<body style="font-family: Roboto, sans-serif; padding: 20px;">
    <h2>Add Two Numbers (JSP)</h2>
    <%-- Form submits back to this same JSP (addition.jsp) via HTTP POST --%>
    <form method="POST" action="q19.jsp">
        <label>Number 1:</label><br>
        <input type="number" name="num1" required /><br><br>
        <label>Number 2:</label><br>
        <input type="number" name="num2" required /><br><br>
        <input type="submit" value="Calculate Sum" />
    </form>

    <%-- JSP Scriptlet <% ... %> runs Java code on the server during request --%>
    <%
        // Read form parameters by their HTML 'name' attributes
        String n1 = request.getParameter("num1");
        String n2 = request.getParameter("num2");
        if (n1 != null && n2 != null) {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
            double sum = num1 + num2;
    %>
            <%-- JSP Expression tags print the computed values --%>
            <h3>Result: <%= num1 %> + <%= num2 %> = <%= sum %></h3>
    <%
        }
    %>
</body>
</html>
