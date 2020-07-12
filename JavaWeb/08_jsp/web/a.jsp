<%@ page import="javax.swing.text.Keymap" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 小布丁
  Date: 2020/6/11
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
  private int id=5;
  private  Date date = new Date();
%>

<%=12.3%><br>
<%=date%><br>
<%=request.getParameter("username")%><br>

<table border="1" cellspacing="0">
    <%
        for(int i=1;i<=10;i++){
    %>
    <tr>
        <td>第<%=i%>行</td>
    </tr>
    <%
        }
    %>
    <%=request.getParameter("aaa")%>
</table>
</body>
</html>
