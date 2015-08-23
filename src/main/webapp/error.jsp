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
    <%= message%>
    </h1>

  <form name="Error login" action="home" method="get">
    <br>
    <input type="submit" value="Back to login page" />
  </form>
</body>
</html>
