<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Add Subject</title>
</head>
<body>
<p>Add new subject to learn</p>
<form action="/admin/addSubject" method="post">
    <input type="text" name="subjectName" placeholder="SubjectName">
    <button>Add</button>
</form>
<p style="color: red">${message}</p>
<a href="/admin/adminPage"> Back</a>
</body>
</html>
