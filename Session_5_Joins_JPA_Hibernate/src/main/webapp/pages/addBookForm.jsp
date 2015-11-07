<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<form:form modelAttribute="book" action="add" method="post">
    <fieldset>
        <legend>Book information:</legend>
        Title:<br>
        <form:input path="title"/>
        <br>

        Author:<br>
        <form:input path="author"/>
        <br>
        <br>

        <input type="submit" value="Add Book">
        <input type="button" onclick="location.href='/library/books/allbooks';" value="Cancel" />
    </fieldset>
</form:form>


</body>
</html>