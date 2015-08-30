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
  <title>Home page</title>
</head>
<body>
<table  bgcolor=gray align="center" width="70%" border="0" cellspacing="5" cellpadding="5">

    <caption><h1>Log In</h1></caption>

<form name="Name Input Form" action="/login" method="post">
    <tr>
        <td>Enter username:</td>
        <td><input type="text" name="name" /></td>
    </tr>
    <tr>
        <td>Enter password:</td>
        <td><input type="password" name="password" /></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="OK" /></td>
    </tr>

</form>
</table>
</body>
</html>

