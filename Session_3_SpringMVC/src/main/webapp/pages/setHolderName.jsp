<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<form action="addholderaction" method="post">
  <fieldset>
    <legend>Please enter holder name:</legend>
    <input type="text" name="holderName">
    <br>
    <br>

    <input type="submit" value="OK">
    <input type="button" onclick="location.href='/library/books/allbooks';" value="Cancel" />
  </fieldset>
</form>

</body>
</html>