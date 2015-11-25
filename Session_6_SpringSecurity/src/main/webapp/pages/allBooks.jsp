<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <td><a href="/library/reports/bybook/${book.id}">${book.title}</a></td>
            <td>${book.author}</td>
            <td><a href="/library/reports/byuser/${book.user.id}">${book.user.firstName} ${book.user.lastName}</a></td>
            <c:choose>
                <c:when test="${book.status=='taken'}">
                    <td align="center">(taken)</td>
                    <td align="center">
                        <form action="returnbook" method="post">
                        <input type="hidden" name="bookId" value="${book.id}">
                        <input type="submit" value="Return">
                        </form>
                    </td>
                </c:when>
                <c:otherwise>
                    <td></td>
                    <td align="center">
                        <form action="setholderform" method="post">
                            <input type="hidden" name="bookId" value="${book.id}">
                            <input type="submit" value="Take">
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>

</table>

<br>

<input type="button" onclick="location.href='/library/books/add'" value="Add book" />
<c:if test="${not empty popularBook}">
    <input type="button" onclick="location.href='/library/reports/bybook/${popularBook.id}'" value="Most popular book: ${popularBook.title}" />
</c:if>


</body>
</html>
