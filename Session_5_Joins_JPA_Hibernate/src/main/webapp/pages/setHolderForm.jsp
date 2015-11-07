<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<form action="setholdername" method="post">
    <fieldset>
        <legend>Please enter holder name:</legend>
        <input type="text" name="holderName">
        <input type="hidden" name="bookId" value="${bookId}">
        <br>
        <br>

        <input type="submit" value="OK">
        <input type="button" onclick="location.href='/library/books/allbooks';" value="Cancel" />
    </fieldset>
</form>


</body>
</html>