<%--
  Created by IntelliJ IDEA.
  User: Bekezhan
  Date: 16.10.2020
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty cookie['user']}">
    <c:redirect url="IndexServlet" />
</c:if>
<html>
<head>
    <meta charset="utf-8">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-type" name="viewport" content="width-device=width, initial-scale=1">
    <title>NIS SHOP</title>
</head>
<body>
<div class="overlay" id="login">
    <div class="login form">
        <label><h3>Login</h3></label>
        <form method="post" action="LoginServlet">
            <label>Username</label>
            <input type="text" id="username" name="login" required>
            <label>Password</label>
            <input type="password" id="userpassword" name="password" required>
            <input type="submit" id="log-btn"  name="log-in" class="submit" value="Login">
            <a href="registration.jsp">Sign up</a>
        </form>
    </div>
</div>
</body>
</html>
