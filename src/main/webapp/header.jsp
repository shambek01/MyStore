<%--
  Created by IntelliJ IDEA.
  User: Bekezhan
  Date: 17.10.2020
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="auth-bar">
    <ul>
        <a><li>${cookie['user'].value}</li></a>
        <a href="LogoutServlet"><li>Выход</li></a>
    </ul>
</div>
<header>
    <label><a href="IndexServlet"><img class="header-logo" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRoOrFwnPTSi-n0Bep75ogLpIrLEDM-fg72cg&usqp=CAU">SHOP</a></label>
    <ul>
        <c:forEach var="category" items="${categories}">
        <a href="FetchByCategoryServlet?category=${category.categoryId}"><li>${category.categoryName}</li></a>
        </c:forEach>
        <a href="cart.jsp"><li>Cart</li></a>
    </ul>
</header>
