<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<fieldset>
    <legend>Please enter holder name:</legend>
<form:form modelAttribute="book" action="setholdername" method="post">

    <form:select path="user.id" items="${usersMap}"/>
        <br>
        <br>

        <input type="submit" value="OK">
        <input type="button" onclick="location.href='/library/books/allbooks';" value="Cancel" />

</form:form>


</fieldset>
</body>
</html>