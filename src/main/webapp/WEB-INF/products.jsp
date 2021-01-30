<%@ page import="storage.Products" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 1/30/2021
  Time: 1:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Products page</h1>
<ol>
    <c:forEach items="${Products.products}" var="product">
        <li>
            ${product.name} is so cheap it is $${product.price}
            <form action="${pageContext.request.contextPath}/user/product" method="post">
                <input type="hidden" name="product" value="${product.name}">
                <input type="submit" name="Add">
            </form>
        </li>
    </c:forEach>
</ol>
<h4>My shopping cart</h4>
<c:forEach items="${me.shoppingCart.products}" var="product">
    <li>
        ${product.name}, $${product.price} is my product now.
    </li>
</c:forEach>
</body>
</html>
