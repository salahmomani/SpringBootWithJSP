<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Teacher Details</title>
</head>
<body>

<h2>Teacher Details</h2>

<c:choose>
    <c:when test="${not empty teacher}">
        <p><b>ID:</b> ${teacher.id}</p>
        <p><b>Name:</b> ${teacher.name}</p>
        <p><b>Email:</b> ${teacher.email}</p>
    </c:when>
    <c:otherwise>
        <p>Teacher not found.</p>
    </c:otherwise>
</c:choose>

<br>
<a href="/getAllTeachers">Back to Teachers</a>

</body>
</html>
