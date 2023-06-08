<%--
  Created by IntelliJ IDEA.
  User: seunggulee
  Date: 2023/06/08
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li>id=<%=((Member) request.getAttribute("member")).getId()%>
    </li>
    <li>username=<%=((Member) request.getAttribute("member")).getUsername()%>
    </li>
    <li>
        age=<%=((Member) request.getAttribute("member")).getAge()%>
    </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
