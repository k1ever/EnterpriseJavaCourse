<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<form action="addbookaction">
    <fieldset>
    <legend>Book information:</legend>
        Title:<br>
        <input type="text" name="bookTitle">
        <br>

        Author:<br>
        <input type="text" name="author">
        <br>
        <br>

        <input type="submit" value="Add Book">
        <input type="button" onclick="location.href='http://localhost:8080/library/allbooks';" value="Cancel" />
  </fieldset>
</form>


</body>
</html>