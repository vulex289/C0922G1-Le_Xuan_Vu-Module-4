<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<fieldset>
    <legend>Calculator</legend>
    <form action="/calculator" method="post">
        <input type="number"  name="num1">
        <input type="number"  name="num2">
        <br>
        <br><hr>
        <input type="submit" name="calculator" value="Addition(+)" >
        <input type="submit" name="calculator" value="Subtraction(-)" >
        <input type="submit" name="calculator" value="Multiplication(*)" >
        <input type="submit" name="calculator" value="Division(/)" >
    </form>
    <p>Result: ${result}</p>
</fieldset>
</body>
</html>