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
    <th> Taken Date </th>
    <th> Returned Date </th>
  </tr>

  <c:forEach var="uReport" items="${userReport}" >
    <tr>
      <td>${uReport.bookTitle}</td>
      <td>${uReport.takenDate}</td>
      <td>${uReport.returnedDate}</td>
    </tr>
  </c:forEach>

</table>

<br>

<input type="button" onclick="location.href='/library/books/allbooks';" value="Back" />

</body>
</html>
