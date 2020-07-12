<%--
  Created by IntelliJ IDEA.
  User: 小布丁
  Date: 2020/6/12
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","value");
    %>
    表达式脚本：<%=request.getAttribute("key")%><br>
    EL表达式：${key};
</body>
</html>
