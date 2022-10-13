<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teacher Registration</title>
</head>
<body>
<s:form action="/teacher/teacherRegistration" method="post" modelAttribute="newTeacher">
    <s:input path="name" placeholder="Input name"/>
    <br>
    <s:errors path="name" cssStyle="color: red"/>
    <br>
    <s:input path="surname" placeholder="Input surname"/>
    <br>
    <s:errors path="surname" cssStyle="color: red"/>
    <br>
    <s:input path="password" type="password" placeholder="Input password"/>
    <br>
    <s:errors path="password" cssStyle="color: red"/>
    <br>
    <p>Choose subjects you want to teach:</p>
    <s:checkbox path="subjects" value="MATHS"/>Maths<br/>
    <s:checkbox path="subjects" value="FOREIGN_LANGUAGE"/>Foreign language<br/>
    <s:checkbox path="subjects" value="PHYSICS"/>Physics<br/>
    <s:checkbox path="subjects" value="CHEMISTRY"/>Chemistry<br/>
    <s:checkbox path="subjects" value="PE"/>PE<br/>
    <s:checkbox path="subjects" value="HISTORY"/>History<br/>
    <s:checkbox path="subjects" value="IT"/>IT<br/>
    <s:checkbox path="subjects" value="AUTOMATICS"/>Automatics<br/>
    <br>
    <s:button>Register</s:button>
    <a href="/startpage" class="btn btn-primary">Back</a>
</s:form>
<p style="color: red">${message}</p>
</body>
</html>
