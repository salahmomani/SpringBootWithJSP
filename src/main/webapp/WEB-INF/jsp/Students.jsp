<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>All Students</title>
</head>
<body>
<h1>All Students</h1>

<table border="1">
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

<br>
<a href="addStudentForm.jsp">Add New Student</a>
<br><br>
<form action="/getByIDStudent" method="get">
    <input type="number" name="id" placeholder="Enter ID">
    <button type="submit">Get Student By ID</button>
</form>

</body>
</html>
