<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Users List</title>
</head>
<body>
<table border="1">
  <tr>
    <th>Id</th>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Age</th>
  </tr>
  <c:forEach var="user" items="${users}">
    <tr>
      <td><c:out value="${user.id}"/></td>
      <td><c:out value="${user.firstName}"/></td>
      <td><c:out value="${user.lastName}"/></td>
      <td><c:out value="${user.age}"/></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
