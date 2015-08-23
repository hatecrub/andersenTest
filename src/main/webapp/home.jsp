<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.08.2015
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>
<body>
<h1>Entry Form</h1>

<form name="Name Input Form" action="/login" method="post">
    <br>
    Enter username:
    <input type="text" name="name" />
    <br>
    <br>
    Enter password:
    <input type="password" name="password" />
    <br>
    <br>
    <input type="submit" value="OK" />
</form>
</body>
</html>

