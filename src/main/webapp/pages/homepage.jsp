<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Homepage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<h3>Welcome to the University</h3>
<a href="/admin/registration" class="btn btn-primary">Register as Admin</a>
<a href="/admin/login" class="btn btn-primary">Login as Admin</a>
<a href="/admin/adminPage" class="btn btn-primary">Admin page</a>
<br>
<br>
<a href="/student/registration" class="btn btn-primary">Register as a Student</a>
<a href="/student/login" class="btn btn-primary">Login as Student</a>
<br>
<br>
<a href="/teacher/registration" class="btn btn-primary">Register as a Teacher</a>
<a href="/teacher/login" class="btn btn-primary">Login as Teacher</a>
<a href="/teacher/teacherPage" class="btn btn-primary">Teacher page</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>