<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teacher Page</title>
</head>
<body>
<h2>Hello , ${sessionScope.currentTeacher.name} ${sessionScope.currentTeacher.surname}</h2>
<a href="/teacher/addSubjects">Add subjects</a>
<h2>Subjects you teach : </h2>
<c:forEach var="subject" items="${teacherSubjects}">
    <p>${subject.id}.${subject.subjectName}</p>
</c:forEach>
<br>
<a href="/teacher/createLesson">Create Lesson</a>
<a href="/teacher/rateStudent">Rate a student</a>
<br>
<a href="/teacher/logout">Logout</a>
<a href="/">Back</a>
</body>
</html>
