<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Item List</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>

    <div>
        <table>
            <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Tag</th>
            <th>Delete to basket</th>
            </thead>
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.description}</td>
                    <td>${item.tag}</td>
                    <td><a href="/user/deleteToBasket/${item.id}">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
        <div>
            <a href="/user/pay">Pay</a>
        </div>
        <div>
            <a href="/user/select">Главная</a>
        </div>

    </div>

</div>
</body>
</html>