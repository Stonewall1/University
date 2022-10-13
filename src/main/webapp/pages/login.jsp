<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.10.2022
  Time: 1:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<br>
<s:form action="/login" method="post" >
    <s:input path="name" size="50" placeholder="Name"/>
    <br>
    <s:errors path="name" cssStyle="color: red"/>
    <br>
    <s:input path="password" size="50" type="password" placeholder="Password"/>
    <br>
    <s:errors path="password" cssStyle="color: red"/>
    <br>
    <s:button>Login</s:button>
</s:form>
<p style="color: red">${message}</p>
</body>
</html>
