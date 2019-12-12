<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/2
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/bookServlet?method=addBook" method="post" enctype="multipart/form-data">
    图书名称: <input type="text" name="name" >
    <br/> 图书作者:  <input type="text" name="author" >
    <br/> 出版社:    <input type="text" name="publish" >
    <br/> 单&nbsp;&nbsp;&nbsp;&nbsp;价:      <input type="text" name="price" >
    <br/> 图&nbsp;&nbsp;&nbsp;&nbsp;片:
    <input type="file" name="photoName" >
    <br/> 分类列表:
    <select name="categoryId">
        <option>---请选择---</option>
        <option value="1">经典武侠</option>
    </select>
    <br/>
    <input type="submit" value="添加图书" >
</form>
</body>
</html>
