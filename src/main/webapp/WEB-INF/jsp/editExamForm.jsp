<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Exam</title>
</head>
<body>
<h2>Edit Exam</h2>
<form action="/exam/edit" method="post">
    <input type="hidden" name="_method" value="put">

    <input type="hidden" name="id" value="${exam.id}">

    <label>Course ID:</label>
    <input type="number" name="courseId" value="${exam.courseId}" required><br><br>

    <label>Exam Name:</label>
    <input type="text" name="name" value="${exam.name}" required><br><br>

    <label>Max Score:</label>
    <input type="number" name="maxScore" value="${exam.maxScore}" required><br><br>

    <button type="submit">Update Exam</button>
</form>

<br>
<a href="/exam/all">Back to Exams List</a>
</body>
</html>
