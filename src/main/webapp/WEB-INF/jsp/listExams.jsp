<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Spring.SpringBootWithJSP.Model.Exam" %>
<html>
<head>
    <title>All Exams</title>
</head>
<body>
<h2>Exams List</h2>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Course ID</th>
        <th>Name</th>
        <th>Max Score</th>
        <th>Actions</th>
    </tr>
    <%
        List<Exam> exams = (List<Exam>) request.getAttribute("exams");
        if(exams != null){
            for(Exam e : exams){
    %>
    <tr>
        <td><%= e.getId() %></td>
        <td><%= e.getCourseId() %></td>
        <td><%= e.getName() %></td>
        <td><%= e.getMaxScore() %></td>
        <td>
            <a href="/exam/edit?id=<%= e.getId() %>">Edit</a> |
            <a href="/exam/delete?id=<%= e.getId() %>">Delete</a>
        </td>
    </tr>
    <%  }
       }
    %>
</table>
<br>
<a href="/exam/add">Add New Exam</a>
</body>
</html>
