<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 1/22/2021
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/auth">
    <label>
        Name:
        <input type="text" name="name">
    </label>
    <label>
        Password:
        <input type="password" name="password">
    </label>
    <label>
        Remember Me
        <input type="checkbox" name="rememberMe">
    </label>
    <input type="submit">
</form>
<p style="color: red">${msg}</p>
</body>
</html>
