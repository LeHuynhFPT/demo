<%--
  Created by IntelliJ IDEA.
  User: Dell 3500
  Date: 10/18/2023
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>age</th>
        <th>address</th>
        <th>phone</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
            <td>
                <a href="StudentController?action=showEditForm&id=${student.id}">Chỉnh sửa</a>
                <a href="StudentController?action=delete&id=${student.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
