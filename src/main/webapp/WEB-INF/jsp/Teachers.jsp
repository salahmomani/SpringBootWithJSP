<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Teachers</title>
</head>
<body>

<h1>All Teachers</h1>

<c:if test="${not empty teachers}">
    <table border="1" cellpadding="5">
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
</c:if>

<c:if test="${empty teachers}">
    <p>No teachers found.</p>
</c:if>

<br>

<form action="/getByIDTeacher" method="get">
    <input type="number" name="id" placeholder="Enter Teacher ID" required>
    <button type="submit">Find Teacher</button>
</form>

<br>
<!-- Go to the controller to show add form -->
<a href="/addTeacherForm">Add Teacher</a>

</body>
</html>
