<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 07.04.2023
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD BOOKS</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    AUTHOR :
    <form:input path="author"/>
    <form:errors path="author"/><br>
    ISBN :
    <form:input path="isbn"/>
    <form:errors path="isbn"/><br>
    PUBLISHER :
    <form:input path="publisher"/>
    <form:errors path="publisher"/><br>
    TITLE :
    <form:input path="title"/>
    <form:errors path="title"/><br>
    TYPE :
    <form:input path="type"/>
    <form:errors path="type"/><br>
    <input type="submit" value="Submit"><br>
</form:form>
</body>
</html>
