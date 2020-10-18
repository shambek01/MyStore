<%--
  Created by IntelliJ IDEA.
  User: Bekezhan
  Date: 16.10.2020
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="overlay" id="registration">
    <div class="registration form">
        <label><h3>Регистрация</h3></label>
        <form method="post" action="RegistrationServlet">
            <label for="login">Username</label>
            <input type="text" name="login" required>
            <label for="password" >Password</label>
            <input type="password" name="password" required>
            <label for="name" >Name</label>
            <input type="text" name="name" required>
            <label for="surname" >Surname</label>
            <input type="text" name="surname" required>
            <label for="email">Email</label>
            <input type="text" name="email" required>
            <input type="submit" id="reg-btn" class="submit" value="register" name="register">
            <a href="login.jsp">Login</a>
            <p id="message"></p>
        </form>
    </div>
</div>
</body>
</html>
