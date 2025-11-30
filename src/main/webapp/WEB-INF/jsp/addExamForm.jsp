<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Exam</title>
</head>
<body>

<h2>Add New Exam</h2>

<form action="/exam/add" method="post">

    <label>Course ID:</label>
    <input type="number" name="courseId" required><br><br>

    <label>Exam Name:</label>
    <input type="text" name="name" required><br><br>

    <label>Max Score:</label>
    <input type="number" name="maxScore" required><br><br>

    <button type="submit">Add Exam</button>
</form>

<br>
<a href="/exam/all">View All Exams</a>

</body>
</html>
