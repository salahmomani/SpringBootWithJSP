<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Teacher</title>
</head>
<body>

<h2>Add Teacher</h2>

<form action="/addTeacher" method="post">
    Name: <input type="text" name="name" required/><br><br>
    Email: <input type="email" name="email" required/><br><br>
    <button type="submit">Add Teacher</button>
</form>

<br>
<a href="/getAllTeachers">Back to Teachers</a>

</body>
</html>
