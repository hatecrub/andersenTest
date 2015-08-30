<%@ page import="java.util.ArrayList" %>
<%@ page import="database.Note" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>
        <c:out value="${sessionScope.get('username')}" />'s notes
    </title>
</head>
<body>
<table align="center" width="70%" border="0" cellspacing="5" cellpadding="5">
    <tr bgcolor=gray>

        <form name="table" action="/notes" method="post">
        <td width="60%">
            <p>
            <table border="1">
                <caption>Notes</caption>
                <tr>
                    <th> </th>
                    <th>ID</th>
                    <th>Note</th>
                </tr>

                <c:forEach items="${requestScope.get('lastNotes')}" var="note" >

                    <c:choose>
                        <c:when test="${requestScope.get('activeRadio')!=null && requestScope.get('activeRadio') == note.id}">

                            <tr>
                                <td><input type="radio" name="number" value="${note.id}" checked /></td>
                                <td><c:out value="${note.id}" /></td>
                                <td><c:out value="${note.note}" /></td>
                            </tr>
                        </c:when>
                        <c:when test="${requestScope.get('activeRadio') == null || requestScope.get('activeRadio') != note.id}">
                            <tr>
                                <td><input type="radio" name="number" value="${note.id}" /></td>
                                <td><c:out value="${note.id}" /></td>
                                <td><c:out value="${note.note}" /></td>
                            </tr>
                        </c:when>

                    </c:choose>
                </c:forEach>
            </table>
            </p>

            <br/>

            <input name="editButton" type="submit" value="edit">
            <input name="removeButton" type="submit" value="remove">

            <br/>
            <a href="/allNotes">Show all notes</a>
        </td>
        <td width="40%">

            <p align="center">


                <c:choose>
                    <c:when test="${requestScope.get('editNote') != null }" >
                        <br/><input type="text" name="newNote" value="${requestScope.get('editNote')}" /><br/>
                    </c:when>
                    <c:when test="${requestScope.get('editNote') == null }" >
                        <br/><input type="text" name="newNote" /><br/>
                    </c:when>
                </c:choose>

                <input name="addButton" type="submit" value="add new note" />
                <input name="applyButton" type="submit" value="apply edit" />
            </p>
            <br/>


        </td>
        </form>
    </tr>
</table>
<c:if test="${sessionScope.get('username') != null}"><a href="/logout">LogOut</a> </c:if>

</body>
</html>
