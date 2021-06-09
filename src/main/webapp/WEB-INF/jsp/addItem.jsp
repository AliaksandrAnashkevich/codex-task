<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Add Item</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
        <title>Add</title>
</div>

<div>
    <form:form method="post"
               action="/admin/addItem"
               modelAttribute="item">
        <table>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name" placeholder="Name"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="description">Description</form:label></td>
                <td><form:input path="description" placeholder="Description"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="tag">Tag</form:label></td>
                <td><form:input path="tag" placeholder="Tag"></form:input></td>
            </tr>
            <th>
                <td><input type="submit">Add</td>
            </th>
        </table>
    </form:form>
</div>
</body>
</html>