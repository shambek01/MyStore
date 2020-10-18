<%--
  Created by IntelliJ IDEA.
  User: Bekezhan
  Date: 18.10.2020
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty cookie['user']}">
    <c:redirect url="LoginServlet" />
</c:if>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Number of visits:${stats.visits}<br>
    Number of sessions:${stats.sessions}<br>
    Last visit:${stats.last_visit}
</body>
</html>
