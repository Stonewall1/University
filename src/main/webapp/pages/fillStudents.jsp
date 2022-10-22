<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Fill Students</title>
</head>
<body>
<h5>All students:</h5>
<c:forEach var="student" items="${allStudents}">
  <p>${student.name} ${student.surname} ${student.subjects}<br/></p>
</c:forEach>
<form action="/teacher/fillStudents" method="post">
    <input type="text" name="studentSurname" placeholder="Student surname">
    <button>Add to lesson</button>
</form>
<p style="color: red">${message}</p>
<a href="/teacher/teacherPage"> Back</a>
</body>
</html>
