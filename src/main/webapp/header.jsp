<%--
  Created by IntelliJ IDEA.
  User: Bekezhan
  Date: 17.10.2020
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="auth-bar">
    <ul>
        <a><li>${cookie['user'].value}</li></a>
        <a href="LogoutServlet"><li>Выход</li></a>
    </ul>
</div>
<header>
    <label><a href="index.php"><img class="header-logo" src="images/nislogo.png">SHOP</a></label>
    <ul>
        <form method="GET" action="" style="border-bottom:1px solid black"><div class="fa fa-search"></div><input type="text" class="search-input" name="search" placeholder="Поиск одежды"></form>
        <a><li>Мужское</li></a>
        <a><li>Женское</li></a>
        <a><li>Корзина()</li></a>
    </ul>
</header>
