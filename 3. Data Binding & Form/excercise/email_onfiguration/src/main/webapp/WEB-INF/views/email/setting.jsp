<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/02/2023
  Time: 10:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<p>${msg}</p>
<form:form modelAttribute="email" action="/setting" method="post">
    <fieldset>
        <legend>SETTINGS</legend>
        <table>
            <tr>
                <td><form:hidden path="id" value="${email.id}"/></td>
            </tr>
            <tr>
                <td><form:hidden path="name" value="${email.name}"/></td>
            </tr>
            <tr>
                <td><b>Languages:</b></td>
                <td>
                    <form:select path="language" value="${email.language}">
                        <form:options items="${languages}"></form:options>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><b>Page Size:</b></td>
                <td>
                    Show
                    <form:select path="pageSize" value="${email.pageSize}">
                        <form:options items="${pageSize}"></form:options>
                    </form:select>
                    email per page
                </td>
            </tr>
            <tr>
                <td><b>Spams filter:</b></td>
                <td><form:checkbox path="spamsFilter" value="${email.spamsFilter}"/>Enable spams filter
            </tr>
            <tr>
                <td><b>Signature</b></td>
                <td>
                    <form:textarea path="signature" value="${email.signature}"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Update"/>
                </td>
                <td>
                    <input type="reset" value="Cancel">
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
