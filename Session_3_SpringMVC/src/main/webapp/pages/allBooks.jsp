<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td> (taken) </td>
    <td> take/return </td>
    </tr>

    <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td> (taken) </td>
    <td> take/return </td>
    </tr>

  </table>

  <br>

  <input type="button" onclick="location.href='http://localhost:8080/library/addbookform';" value="Add book" />

</body>
</html>
