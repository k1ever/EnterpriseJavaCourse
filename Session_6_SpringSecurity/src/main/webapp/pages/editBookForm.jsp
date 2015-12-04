<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<fieldset>
  <legend>Book info:</legend>
  <table>
  <form:form modelAttribute="book" action="savebook" method="post">
    <form:hidden path="id" value="${book.id}"/>
    <tr>
      <td>Title:</td>
      <td><form:input path="title" value="${book.title}"/></td>
    </tr>

    <tr>
      <td>Author:</td>
      <td><form:input path="author" value="${book.author}"/></td>
    </tr>

    <tr>
      <td>Status:</td>
      <td><form:select id="bstatus" name="bstatus"
                       path="status" value="${book.status}"
                       onchange="handleSelect()">
        <form:option label="Free" value=""/>
        <form:option label="Taken" value="taken"/>
      </form:select></td>
    </tr>

    <tr>
      <td>Holder:</td>
      <td><form:select id="holder" name="holder"
                       path="user.id" value="${book.user.id}"
                       items="${usersMap}"
                       disabled="${book.status == ''}">
      </form:select>
      </td>
    </tr>

    </table>

    <input type="submit" value="Save">
  </form:form>
    <form action="deletebook" method="post">
      <input type="hidden" name="bookId" value="${book.id}">
      <input type="submit" value="Delete">
    </form>
    <input type="button" onclick="location.href='/library/books/allbooks';" value="Cancel" />

</fieldset>
</body>
</html>

<script type="text/javascript">
  function handleSelect() {
    var bst = document.getElementById("bstatus");
    var status = bst.options[bst.selectedIndex].value;

    if (status == 'taken') {
      document.getElementById('holder').disabled = false;
    } else {
      document.getElementById('holder').disabled = true;
    }
  }
</script>