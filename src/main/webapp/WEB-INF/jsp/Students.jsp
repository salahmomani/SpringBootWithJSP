<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Students</title>
</head>
<body>

<h1>All Students</h1>

<c:if test="${not empty students}">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <c:forEach var="s" items="${students}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty students}">
    <p>No students found.</p>
</c:if>

<br>

<form action="/getByIDStudent" method="get">
    <input type="number" name="id" placeholder="Enter Student ID" required>
    <button type="submit">Find Student</button>
</form>

<br>
<!-- Go to the controller to show add form -->
<a href="/addStudentForm">Add New Student</a>

</body>
</html>
