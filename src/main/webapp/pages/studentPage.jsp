<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Page</title>
</head>
<body>
<h2>Hello , ${sessionScope.currentStudent.name} ${sessionScope.currentStudent.surname}</h2>
<h2>Your subjects :</h2>
<c:forEach var="subject" items="${studentSubjects}">
    <p>${subject.id}.${subject.subjectName}</p>
</c:forEach>
<br>
<a href="/student/addSubjects">Add Subjects</a>
<br>
<h2>Your results :</h2>
<c:forEach var="result" items="${studentResults}">
    <p>${result}</p>
</c:forEach>
<a href="/student/logout">Logout</a>
<a href="/">Back</a>
</body>
</html>
