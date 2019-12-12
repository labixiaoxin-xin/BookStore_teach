<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/12/12
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书显示</title>
</head>
<body>
<table border="1px" cellspacing="0" cellpadding="0" style="margin: 50px auto;">
    <tr>
        <th>序号</th>
        <th>图书名称</th>
        <th>图书作者</th>
        <th>图书厂家</th>
        <th>图书单价</th>
        <th>所属分类</th>
        <th>图书图片</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${page.record}" var="book">
        <tr>
            <td>
                <input type="checkbox"  >
            </td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.publish}</td>
            <td>${book.price}</td>
            <td>${book.category}</td>
            <td>
                <img src="${book.path}${book.photoName}">
            </td>
            <td>
                <a href="#">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<br/>
<br/>

共 ${page.totalRecord}条，
第${page.currentPage}页,共${page.totalPage} 页
<br/>
<a href="${pageContext.request.contextPath}/bookServlet?method=bookList&pageNum=1">首页</a>
<a href="${pageContext.request.contextPath}/bookServlet?method=bookList&pageNum=${page.prePageNumber}">上一页</a>

<a href="${pageContext.request.contextPath}/bookServlet?method=bookList&pageNum=${page.nextPageNumber}">下一页</a>
<a href="${pageContext.request.contextPath}/bookServlet?method=bookList&pageNum=${page.totalPage}">尾页</a>



</body>
</html>
