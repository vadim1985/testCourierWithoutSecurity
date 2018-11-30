<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: comp
  Date: 29.11.2018
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Кабинет оператора.</title>
</head>
<body>
<table frame="border">
    <form action="operator" method="post">
    <tr>
        <td colspan="2"><input type="text" name="number" required></td>
    </tr>
        <tr>
            <td><input type="submit" value="Искать"></td></form>
    <form action="operator" method="get"><td align="right"><input type="submit" value="Очистить"></td>
        </tr>
    </form>
</table>

<% if (request.getAttribute("checkOrder").equals("ShowAll")){ %>
<table border="1">
<c:forEach items="${listOfOrderNumber}" var="list">
    <tr>
        <td>${list.number}</td><td>${list.date}</td><td><a href="operator/${list.number}">Данные по заявке</a></td>
    </tr>
</c:forEach>
</table>
<%}%>

<% if (request.getAttribute("checkOrder").equals("OrderIsFound")){ %>
<table border="1">
    <tr><td>${foundOrder.number}</td><td>${foundOrder.date}</td><td><a href="operator/${foundOrder.number}">Данные по заявке</a></td></tr>
</table>
<%}%>
<% if (request.getAttribute("checkOrder").equals("Not found")){ %>
    <h3>Заявка №${foundOrder} не найдеа.</h3>
<%}%>
</body>
</html>
