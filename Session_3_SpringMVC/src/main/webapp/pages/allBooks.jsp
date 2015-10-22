<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.mvc.library.model.BookEntity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<%--%>
<%--// retrieve your list from the request, with casting--%>
<%--ArrayList<BookEntity> books = (ArrayList<BookEntity>) request.getAttribute("books");--%>

<%--// print the information about every category of the list--%>
<%--for(BookEntity book : books) {--%>
<%--out.println(book.getTitle());--%>
<%--out.println(book.getAuthor());--%>
<%--out.println();--%>
<%--}--%>
<%--%>--%>

<c:forEach var="book" items="${books}" >
    <%--<tr>--%>
    <%--<td>${book.title}</td>--%>
    <%--<td>${book.author}</td>--%>
    <%--</tr>--%>
</c:forEach>



<html>
<head>
    <title>Library</title>
    <style>
        table {
            width:100%;
        }

        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        table tr:nth-child(even) {
            background-color: #eee;
        }
        table tr:nth-child(odd) {
            background-color:#fff;
        }
        table th	{
            background-color: LightBlue;
            color: black;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th> Book title </th>
        <th> Author </th>
        <th> Holder </th>
        <th> Status </th>
        <th> Action </th>
    </tr>

    <c:forEach var="book" items="${books}" >
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.holder}</td>
            <c:choose>
                <c:when test="${book.taken}">
                    <td>(taken)</td>
                    <td>return</td>
                </c:when>
                <c:otherwise>
                    <td></td>
                    <td>take</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>

</table>

<br>

<input type="button" onclick="location.href='http://localhost:8080/library/addbookform';" value="Add book" />

</body>
</html>
