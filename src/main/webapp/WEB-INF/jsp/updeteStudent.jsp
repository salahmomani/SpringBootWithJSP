<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student Updated</title>
</head>
<body>

<h2>Student updated successfully!</h2>

<a href="/getAllStudents">Back to Students</a>
<form action="/updateStudent" method="post">
    <input type="hidden" name="id" value="${student.id}" />
    Name: <input type="text" name="name" value="${student.name}" />
    Email: <input type="text" name="email" value="${student.email}" />
    <button type="submit">Update</button>
</form>
</body>
</html>
