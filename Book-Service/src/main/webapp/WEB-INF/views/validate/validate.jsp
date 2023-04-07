<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 07.04.2023
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VALIDATE</title>
</head>
<body>
<table>
    <tr>
        <th>FIELD BOOK</th>
        <th>MESSAGE</th>

    </tr>
    <c:forEach items="${validationsBook}" var="bok">
        <tr>
                <%--            <td>${val.interpolatedMessage}</td>--%>
            <td>${bok.getPropertyPath()}</td>
            <td>${bok.getMessage()}</td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
