<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>User Page</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
    User Page
    ${message}
    <div>
        <table>
            <tr>
                <td>
                    <a href="/user/basket" >Basket</a>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/user/selectAll" method="get">
                        <button type="submit">Select All</button>
                    </form>
                </td>
            </tr>
            <tr>
                <form action="${pageContext.request.contextPath}/user/selectByTag" method="post">
                    <td><input type="text" name="tag" placeholder="tag"/></td>
                    <td>
                        <button type="submit">Select By Tag</button>
                    </td>
                </form>
            </tr>
            <tr>
                <form action="${pageContext.request.contextPath}/user/selectByDescription" method="post">
                    <td><input type="text" name="description" placeholder="description"/></td>
                    <td>
                        <button type="submit">Select By Description</button>
                    </td>
                </form>
            </tr>
        </table>
    </div>
    <a href="/">Главная</a>
</body>
</html>