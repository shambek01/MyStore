<%--
  Created by IntelliJ IDEA.
  User: Bekezhan
  Date: 15.10.2020
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty cookie['user']}">
    <c:redirect url="LoginServlet" />
</c:if>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-type" name="viewport" content="width-device=width, initial-scale=1">

    <title>NIS SHOP</title>
</head>
<body>
<c:import url = "CategoryServlet"/>
<div class="main-wrapper">
    <div class="banner">
        <div class="banner-text">
            <span class="big-text" style="color:black">RANDOM SHOP</span>
        </div>
    </div>
    <div class="product-line">
        <h1>Products</h1>
        <!-- Popular products retrieved -->
        <div class="product-grid">
            <c:forEach var="product" items="${products}">
            <form method="post" action="AddToCartServlet">
                <div class="product-item">
                    <input type="hidden" name="productid" value="${product.productId}">
                    <img class="product-item-img" src='${product.productImage}'>
                    <label class="product-item-name">${product.description}
                    </label>
                    <label class="product-item-price">${product.price} tg</label>
                </div>
                <div class="controls-container">
                    <div class="controls-count">
                        <button class="input-button" onclick="decreaseValue('${product.productId}');return false">-</button>
                        <input type="number" id="${product.productId}" min="1" value="1" name="amount">
                        <button class="input-button" onclick="increaseValue('${product.productId}');return false">+</button>
                    </div>
                    <button class="basket-button" type="submit" name="submit"><i class="fas fa-shopping-cart"></i></button>
                </div>
            </form>
            </c:forEach>
        </div>
    </div>
</div>
<c:import url = "footer.jsp"/>
<script src="https://kit.fontawesome.com/a73d7e7c2a.js" crossorigin="anonymous"></script>
<script src="js/script.js"></script>
</body>
</html>
