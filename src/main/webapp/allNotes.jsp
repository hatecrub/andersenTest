<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="database.Note" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.08.2015
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>All <c:out value="${sessionScope.get('username')}" />'s notes</title>
</head>
<body>
<a href="/notes">Back to notes</a>
<table bgcolor="28822f" align="center" width="70%" border="0" cellspacing="5" cellpadding="5">

<c:forEach items="${requestScope.get('allNotes')}" var="note" >
    <tr><td><c:out value="${note.id}" /></td><td><c:out value="${note.note}" /></td></tr>
</c:forEach>
</table>
<a href="/logout">LogOut</a>
</body>
</html>
