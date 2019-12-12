<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/27
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页</title>
  </head>
  <body>
  <a href="addBook.jsp">添加图书</a>
  <a href="${pageContext.request.contextPath}/bookServlet?method=bookList&pageNum=1">点击查询所有图书</a>
  </body>
</html>
