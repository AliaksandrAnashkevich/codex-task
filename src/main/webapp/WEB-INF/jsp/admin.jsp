<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
Admin User
${message}
<div>
    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/admin/selectAll" method="get">
                    <button type="submit">Select All</button>

                </form>
            </td>
        </tr>
        <tr>
            <form action="${pageContext.request.contextPath}/admin/selectByTag" method="post">
                <td><input type="text" name="tag" placeholder="tag"/></td>
                <td>
                    <button type="submit">Select By Tag</button>
                </td>
            </form>
        </tr>
        <tr>
            <form action="${pageContext.request.contextPath}/admin/selectByDescription" method="post">
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