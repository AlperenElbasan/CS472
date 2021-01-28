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
<h2>Assignment 10</h2>
<a href="${pageContext.request.contextPath}/support">Support link</a>
<h2>Assignment 11</h2>
<form method="post" action="${pageContext.request.contextPath}/auth">
    <label>
        Name:
        <input type="text" name="name">
    </label>
    <label>
        Password:
        <input type="password" name="password">
    </label>
    <input type="submit">
</form>
</body>
</html>
