<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 06.04.2023
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

    <title>Book List</title>

</head>

<body>
<a href="/admin/books/add">ADD BOOK</a>
<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>ACTIONS</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><a href='<c:url value="/admin/books/delete/${book.id}"/>'>DELETED</a>
            <a href='<c:url value="/admin/books/edit/${book.id}"/>'>EDIT</a>
                <a href='<c:url value="/admin/books/details/${book.id}"/>'>DETAILS BOOK</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
</body>
</html>
