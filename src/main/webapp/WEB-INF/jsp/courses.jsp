<%@ page import="java.util.List" %>
<%@ page import="com.Spring.SpringBootWithJSP.Model.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Courses</title>
</head>
<body>

<h2>All Courses</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Code</th>
        <th>Title</th>
    </tr>

    <%
        List<Course> list = (List<Course>) request.getAttribute("courses");
        if (list != null) {
            for (Course course : list) {
    %>
    <tr>
        <td><%= course.getId() %></td>
        <td><%= course.getCode() %></td>
        <td><%= course.getTitle() %></td>
    </tr>
    <%
            }
        }
    %>
</table>

<br>
<a href="/addCourse">Add New Course</a>

</body>
</html>
