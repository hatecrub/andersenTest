<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.08.2015
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error login!</title>
</head>
<body>
  <% String message = (String)request.getAttribute("message"); %>
  <h1>
    <c:out value="${requestScope.get('message')}" />
    </h1>

    <br>
    <a href="/home">Back to log in page</a>
</body>
</html>
