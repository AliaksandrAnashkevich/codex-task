<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit Item</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <title>Edit</title>
</div>

<div>
    <form:form method="put"
               action="/admin/editItem"
               modelAttribute="item">
        <table>
            <form:hidden path="id" value="${item.id}"></form:hidden>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name" value="${item.name}"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="description">Description</form:label></td>
                <td><form:input path="description" value="${item.description}"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="tag">Tag</form:label></td>
                <td><form:input path="tag" value="${item.tag}"></form:input></td>
            </tr>
            <tr>
                <td>
                        ${messageForUpdate}
                </td>
                <td><form:button type="submit">Edit</form:button></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>