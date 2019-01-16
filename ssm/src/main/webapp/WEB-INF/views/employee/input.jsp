<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>


<form action="/employee/saveOrUpdate.do" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    姓名:<input type="text" name="name" value="${employee.name}"><<br>
    邮箱:<input type="text" name="email" value="${employee.email}"><<br>
    年龄:<input type="text" name="age" value="${employee.age}"><<br>
    <input type="submit" value="保存"/>

</form>
</table>
</body>
</html>