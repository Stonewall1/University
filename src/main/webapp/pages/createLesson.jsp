<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lesson Creation</title>
</head>
<body>
<h2>Create a lesson</h2>
<h5>Your subjects :</h5>
<c:forEach var="subject" items="${teacherSubjects}">
    <p>${subject.subjectName}</p>
</c:forEach>
<br>
<s:form action="/teacher/createLesson" method="post" modelAttribute="newLesson">
    <s:input path="lessonTheme" placeholder="Lsson theme"/>
    <br>
    <br>
    <s:input path="subject" placeholder="Subject name"/>
    <br>
    <br>
<%--    <p>Checkout students :</p>--%>
<%--    <c:forEach var="student" items="${allStudents}">--%>
<%--        <s:checkbox path="students" value="${student}"/>${student.name} ${student.surname} ${student.subjects}<br/>--%>
<%--    </c:forEach>--%>
    <br>
    <s:button>Add students</s:button>
</s:form>
<a href="/teacher/teacherPage" class="btn btn-primary">Back</a>
<p style="color: red">${message}</p>
</body>
</html>
