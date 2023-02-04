<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/02/2023
  Time: 10:02 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <p style="color: red">${msg}</p>
    <table border="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Languages</th>
            <th>PageSize</th>
            <th>SpamsFilter</th>
            <th>Signature</th>
        </tr>
        <c:forEach var="a" items="${emailList}">
            <tr>
                <td>${a.getId()}</td>
                <td>${a.getName()}</td>
                <td>${a.getLanguage()}</td>
                <td>${a.getPageSize() }</td>
                <td>${a.isSpamsFilter()}</td>
                <td>${a.getSignature()}</td>
                <td><a href="/edit?id=${a.getId()}">Setting</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
