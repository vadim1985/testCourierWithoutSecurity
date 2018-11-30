<%--
  Created by IntelliJ IDEA.
  User: comp
  Date: 29.11.2018
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обработка заявок.</title>
</head>
<body>
<table border="1">
    <tr><td>${orderByNumber.number}</td><td>${orderByNumber.date}</td></tr>
</table>
<form action="/operator/${orderByNumber.number}" method="post">
    <input type="submit" value="Снять заявку">
</form>
</body>
</html>
