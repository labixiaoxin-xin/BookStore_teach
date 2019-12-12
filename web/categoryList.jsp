<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/2
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>分类显示页码</title>
</head>
<body>
<table border="1px" width="438px" cellpadding="0" cellspacing="0" style="border: red;text-align: center;margin: auto;border-radius:25px; " >
    <tr>
        <th>分类序号</th>
        <th>分类名称</th>
        <th>分类描述</th>
        <th>操作</th>
    </tr>

    <c:forEach  items="${data}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.description}</td>
            <td>
                <a href="JavaScript:edit('${c.id}')">修改</a>
                <a href="JavaScript:del('${c.id}')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
<script type="text/javascript">
    function  del(id) {
        var sure = window.confirm("您确定要删除该项吗?");
        if (sure){
            window.location.href="${path}/categoryServlet?method=delCategory&id="+id;
        }
    }

    function  edit(id) {
        var sure = window.confirm("您确定要修改该项吗?");
        if (sure){
            window.location.href="${path}/categoryServlet?method=updateCategoryView&id="+id;
        }
    }
</script>