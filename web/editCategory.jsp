<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/2
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据回显页面</title>
    <%--1. 导入以下文件--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/kindEditor/themes/default/default.css" />
    <script src="${pageContext.request.contextPath}/kindEditor/lang/zh-CN.js"></script>
    <script src="${pageContext.request.contextPath}/kindEditor/kindeditor-all-min.js"></script>
</head>
<script>
    //默认模式  注意：下方中的content属性值要与textarea的name属性值相同才可以
    var editor;
    KindEditor.ready(function(K) {
        editor = K.create('textarea[name="description"]', {
            allowFileManager : true,
            uploadJson:'${pageContext.request.contextPath}/kindeditorUploadServlet',
            fileManagerJson:'${pageContext.request.contextPath}/kindeditorFileManagerServlet'
        });
        K('input[name=getHtml]').click(function(e) {
            alert(editor.html());
        });
        K('input[name=isEmpty]').click(function(e) {
            alert(editor.isEmpty());
        });
        K('input[name=getText]').click(function(e) {
            alert(editor.text());
        });
        K('input[name=selectedHtml]').click(function(e) {
            alert(editor.selectedHtml());
        });
        K('input[name=setHtml]').click(function(e) {
            editor.html('<h3>Hello KindEditor</h3>');
        });
        K('input[name=setText]').click(function(e) {
            editor.text('<h3>Hello KindEditor</h3>');
        });
        K('input[name=insertHtml]').click(function(e) {
            editor.insertHtml('<strong>插入HTML</strong>');
        });
        K('input[name=appendHtml]').click(function(e) {
            editor.appendHtml('<strong>添加HTML</strong>');
        });
        K('input[name=clear]').click(function(e) {
            editor.html('');
        });
    });
</script>
<body>
<form action="${pageContext.request.contextPath}/categoryServlet?method=updateCategory&id=${data.id}" method="post">

    <table border="1" width="600px">
        <tr>
            <td>分类名称:</td>
            <td>
                <input type="text" value="${data.name}" name="name" />
            </td>
        </tr>
        <tr>
            <td>分类描述</td>
            <td>
                    <textarea name="description">
                        ${data.description}
                    </textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交" />
            </td>
        </tr>
    </table>

</form>
</body>
</html>
