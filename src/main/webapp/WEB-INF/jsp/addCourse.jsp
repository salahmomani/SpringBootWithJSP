<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Course</title>
</head>
<body>

<h2>Add a New Course</h2>

<form action="addCourse" method="post">
    <label>Course Code:</label>
    <input type="text" name="code" required><br><br>

    <label>Course Title:</label>
    <input type="text" name="title" required><br><br>

    <button type="submit">Add Course</button>
</form>

<br>
<a href="courses">View All Courses</a>

</body>
</html>
