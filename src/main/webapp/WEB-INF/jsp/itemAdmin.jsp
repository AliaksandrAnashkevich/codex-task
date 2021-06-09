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
    ${message}
    <div>
        <div>
            <a href="/admin/addItem">Add Item</a>
        </div>
        <table>
            <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Tag</th>
            <th>Edit</th>
            <th>Delete</th>
            </thead>
            <c:forEach items="${allItems}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.description}</td>
                    <td>${item.tag}</td>
                    <td><a href="/admin/editItem/${item.id}">Edit</a></td>
                    <td><a href="/admin/deleteItem/${item.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="/admin/select">Главная</a>
    </div>

</div>
</body>
</html>