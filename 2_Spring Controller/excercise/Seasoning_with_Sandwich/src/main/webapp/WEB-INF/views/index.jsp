<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spices</title>
</head>
<body>
<fieldset>
    <legend>Sandwich Seasoning</legend>
<form action="/save" method="post">
        <input type="checkbox" value="lettuce" name="condiment">lettuce
    <input type="checkbox" value="tomato" name="condiment">tomato
    <input type="checkbox" value="mustand" name="condiment">mustand
    <input type="checkbox" value="sprouts" name="condiment">sprouts
    <br><hr>
    <input type="submit" name="condiment" value="" >Choice
</form>
    <p>Bạn đã chọn:</p>
<c:forEach var="a" items="${condiment}">
    <p>${a}</p>
</c:forEach>
<p>${msg}</p>
</fieldset>
</body>
</html>