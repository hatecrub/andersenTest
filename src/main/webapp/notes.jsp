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
    <%
        String name = (String)session.getAttribute("username");
    %>
    <title>
        <%=name%>'s notes
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

                <%
                    ArrayList<Note>lastNotes = (ArrayList)request.getAttribute("lastNotes");
                    for (Note note : lastNotes) {
                        if(request.getAttribute("activeRadio")!=null && (Integer)request.getAttribute("activeRadio") == note.getId()) {
                %>




                    <tr><td>  <input type="radio" name="number" value="<%=note.getId()%>" checked></td>
                        <td><%=note.getId()%></td><td><%=note.getNote()%></td></tr>
                    <%
                        } else {
                    %>

                    <tr><td>  <input type="radio" name="number" value=<%=note.getId()%> ></td>
                        <td><%=note.getId()%></td><td><%=note.getNote()%></td></tr>

                <%
                    }
                }
                %>

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

                <%if(request.getAttribute("editNote")!=null) {%>
                <br/><input type="text" name="newNote" value="<%=(String)request.getAttribute("editNote")%>" /><br/>
                <%} else {%>
                <br/><input type="text" name="newNote" /><br/>
                <%}%>

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
