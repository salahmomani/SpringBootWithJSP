<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Scores</title>
</head>
<body>

<h2>Student Exam Scores</h2>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Student</th>
        <th>Email</th>
        <th>Course</th>
        <th>Exam</th>
        <th>Max Score</th>
        <th>Score</th>
    </tr>

    <c:forEach var="x" items="${scores}">
        <tr>
            <td>${x.id}</td>
            <td>${x.name}</td>
            <td>${x.email}</td>
            <td>${x.courseId}</td>
            <td>${x.name}</td>
            <td>${x.maxScore}</td>
        </tr>
    </c:forEach>
</table>

<br>
<a href="/addExamForm">Add Exam</a>

</body>
</html>
