<%--
  Created by IntelliJ IDEA.
  User: Bekezhan
  Date: 18.10.2020
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty cookie['user']}">
    <c:redirect url="LoginServlet" />
</c:if>

<html>
<head>
    <meta charset="utf-8">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-type" name="viewport" content="width-device=width, initial-scale=1">
    <title>NIS SHOP</title>
    <script src="js/script.js"></script>
</head>
<body>
<c:import url = "CategoryServlet"/>

<div class="main-wrapper">
    <h1>Cart</h1>
        <div class="basket-wrapper">
            <div class="basket">
                <div class="basket-product-container">

<c:forEach var="product" items="${sessionScope.cart}">
                        <div class="basket-product">
                            <img src="${product.key.productImage}">
                            <div class="basket-product-description">
                                <p><a>${product.key.description}</a></p>
                            </div>
                            <div class="basket-product-count">
                                ${product.value} шт
                            </div>
                            <div class="basket-product-count">
                                ${product.key.price*product.value} тг
                            </div>
                        </div>
</c:forEach>
                    <c:if test="${not empty sessionScope}">
                        <form action="ConfirmationServlet" method="post">
                            <button class="save-button" type="submit" name="order">Оформить заказ</button>
                        </form>
                    </c:if>
                    <c:if test="${empty sessionScope}">
                        <h4 style='font-weight:100'>Cart is empty</h4>
                    </c:if>

                </div>
            </div>
        </div>
    </div>
</div>
<c:import url = "footer.jsp"/>
</body>
</html>
