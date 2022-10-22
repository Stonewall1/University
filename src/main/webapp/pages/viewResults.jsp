<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Results</title>
</head>
<body>
<h2>Your results :</h2>
<c:forEach var="result" items="${allResults}">
    <p>Subject: ${result.lesson.subject.subjectName} Theme: ${result.lesson.lessonTheme} Mark: ${result.performance} Teacher: ${result.lesson.teacher.surname}</p>
</c:forEach>
<h2>Your GPA: ${gpa}</h2>
<a href="/student/studentPage">Back</a>
</body>
</html>
