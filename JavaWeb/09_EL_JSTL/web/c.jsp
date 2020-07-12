<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: 小布丁
  Date: 2020/6/13
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person=new Person();
        person.setAge("123");
        person.setPhones(new String[]{"123456","222222","555555","655666"});
        List<String> cities=new ArrayList<String>();
        cities.add("深圳");
        cities.add("上海");
        cities.add("唐山");
        person.setCities(cities);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);
        pageContext.setAttribute("person",person);
    %>
    输出:${person.cities}<br>
    <c:forEach end=""></c:forEach>
</body>
</html>
