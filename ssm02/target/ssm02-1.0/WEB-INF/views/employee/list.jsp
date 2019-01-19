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

<form action="/employee/list.do" method="post">
    关键字:<input type="text" name="keyword" value="${qo.keyword}"/>
            <input type="submit" value="搜索"/><br>
    <a href="/employee/input.do"/>增加<<br>
        编号 姓名 邮箱 年龄 操作
    <br>
    <c:forEach var="emp" items="${pageResult.data}">
        ${emp.id}  ${emp.name} ${emp.email} ${emp.age}
        <a href="/employee/input.do?id=${emp.id}"/>编辑
        <a href="/employee/delete.do?id=${emp.id}"/>删除
        <br>
    </c:forEach>
    <br>
    <a href="/employee/list.do?currentPage=1"/>首页
    <a href="/employee/list.do?currentPage=${pageResult.prevPage}"/>上一页
    <a href="/employee/list.do?currentPage=${pageResult.nextPage}"/>下一页
    <a href="/employee/list.do?currentPage=${pageResult.endPage}"/>尾页
    总共${pageResult.pageCount}条
    当前${pageResult.currentPage}/${pageResult.endPage}页
</form>

</table>
</body>
</html>