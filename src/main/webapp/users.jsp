<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>
<body>
<form action="users" method="get">
<table border="1">
    <tr>
        <td><b> ID </b></td>
        <td><b> First Name </b></td>
        <td><b> Last Name </b></td>
    </tr>

    <c:forEach items="${users}" var="users">
    <tr>
        <td>${users.id}</td>
        <td>${users.fName}</td>
        <td>${users.lName}</td>
        <td><Button>Удалить</Button></td>
    </tr>
    </c:forEach>
</table>
</form>
</body>
    </html>