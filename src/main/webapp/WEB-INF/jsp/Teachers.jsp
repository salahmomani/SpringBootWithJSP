<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All Teachers</title>
</head>
<body>

<h1>All Teachers</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>

    <c:forEach var="t" items="${teachers}">
        <tr>
            <td>${t.id}</td>
            <td>${t.name}</td>
            <td>${t.email}</td>
        </tr>
    </c:forEach>
</table>

<br><br>

<form action="/getByIDTeacher" method="get">
    <input type="number" name="id" placeholder="Enter Teacher ID" required>
    <button type="submit">Find Teacher</button>
</form>

<br>
<a href="addTeacherForm.jsp">Add Teacher</a>

</body>
</html>
