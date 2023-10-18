<%--
  Created by IntelliJ IDEA.
  User: Dell 3500
  Date: 10/18/2023
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Thêm/Sửa Sinh viên</title>
</head>
<body>
<h1>Form Thêm/Sửa Sinh viên</h1>
<form action="StudentController" method="post">
    <input type="hidden" name="id" value="${student.id}"> <!-- Dùng để xác định id cho việc chỉnh sửa -->

    <label for="name">Tên:</label>
    <input type="text" name="name" id="name" value="${student.name}" required>
    <br><br>

    <label for="age">Tuổi:</label>
    <input type="number" name="age" id="age" value="${student.age}" required>
    <br><br>

    <label for="address">Địa chỉ:</label>
    <input type="text" name="address" id="address" value="${student.address}" required>
    <br><br>

    <input type="submit" value="Lưu">
</form>
<p><a href="StudentController">Trở lại danh sách</a></p>
</body>
</html>

