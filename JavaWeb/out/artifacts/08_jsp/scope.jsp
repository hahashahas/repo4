<%--
  Created by IntelliJ IDEA.
  User: 小布丁
  Date: 2020/6/11
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","pageContext");
        session.setAttribute("key","pageContext");
        application.setAttribute("key","pageContext");
    %>
    pageContext域是否有值<%=pageContext.getAttribute("key")%><br>
    request域是否有值<%=request.getAttribute("key")%><br>
    session域是否有值<%=session.getAttribute("key")%><br>
    application域是否有值<%=application.getAttribute("key")%><br>
    <%
        out.write(333);
    %>
    <br>
    <%
        out.print(123);
    %>
    <br>
    <%@ include file="/a.jsp"%><br>

    <jsp:include page="a.jsp">
        <jsp:param name="aaa" value="bbb"/>
    </jsp:include>
    --%>
<jsp:forward page="a.jsp"></jsp:forward>
</body>
</html>
