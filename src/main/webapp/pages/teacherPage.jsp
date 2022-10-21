<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teacher Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<h2>Hello , ${sessionScope.currentTeacher.name} ${sessionScope.currentTeacher.surname}</h2>
<a href="/teacher/addSubjects">Add subjects</a>
<h2>Subjects you teach : </h2>
<c:forEach var="subject" items="${teacherSubjects}">
    <p>${subject.id}.${subject.subjectName}</p>
</c:forEach>
<a href="/teacher/createLesson"  class="btn btn-info">Create Lesson</a>
<a href="/teacher/rateStudent"  class="btn btn-warning">Rate a student</a>
<br>
<a href="/teacher/logout">Logout</a>
<a href="/">Back</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
