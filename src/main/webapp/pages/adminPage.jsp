<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<a href="/admin/addSubject">Add new subject</a>
<h2>Subjects : </h2>
<c:forEach var="subject" items="${allSubjects}">
   <p>${subject.id}.${subject.subjectName}</p>
</c:forEach>
<a href="/admin/logout">Logout</a>
<a href="/">Back</a>
</body>
</html>
