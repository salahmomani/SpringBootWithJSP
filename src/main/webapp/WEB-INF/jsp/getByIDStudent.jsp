<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Details</title>
</head>
<body>

<h2>Student Details</h2>

<c:choose>
    <c:when test="${not empty student}">
        <p><b>ID:</b> ${student.id}</p>
        <p><b>Name:</b> ${student.name}</p>
        <p><b>Email:</b> ${student.email}</p>
    </c:when>
    <c:otherwise>
        <p>Student not found.</p>
    </c:otherwise>
</c:choose>

<br>
<a href="/getAllStudents">Back to Students</a>

</body>
</html>
