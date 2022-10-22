<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rating student</title>
</head>
<body>
<h3>All lessons you taught :</h3>
<c:forEach var="lesson" items="${teacherLessons}">
    <p>${lesson.subject.subjectName} theme : ${lesson.lessonTheme}<br/> Students: ${lesson.students}</p>
</c:forEach>
<s:form action="/teacher/rateStudent" method="post" modelAttribute="result">
    <s:input path="lessonTheme" placeholder="Lesson theme"/>
    <br>
    <s:errors path="lessonTheme" cssStyle="color: red"/>
    <br>
    <s:input path="studentSurname" placeholder="Student surname"/>
    <br>
    <s:errors path="studentSurname" cssStyle="color: red"/>
    <br>
    <s:input path="performance" placeholder="Mark"/>
    <br>
    <s:errors path="performance" cssStyle="color: red"/>
    <br>
    <s:button>Rate</s:button>
</s:form>
<a href="/teacher/teacherPage" class="btn btn-primary">Back</a>
</body>
</html>
