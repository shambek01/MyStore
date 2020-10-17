<%--
  Created by IntelliJ IDEA.
  User: Bekezhan
  Date: 16.10.2020
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <span onclick="closeForm('registration')"
                      class="close">&times;
                </span>
        <label><h3>Регистрация</h3></label>
        <form method="post" action="reg.php">
            <label for="uname">Логин</label>
            <input type="text" name="uname" id="uname">
            <label for="upassword" >Пароль</label>
            <input type="password" name="upassword" id="upassword">
            <label for="email">Номер телефона</label>
            <input type="text" name="email" id="phone">
            <button type="button" id="reg-btn" class="submit" name="register">Зарегистрироваться</button>
            <p id="message"></p>
        </form>
    </div>
</div>
</body>
</html>
