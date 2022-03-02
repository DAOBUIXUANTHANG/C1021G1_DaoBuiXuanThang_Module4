
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Spring</title>
  </head>
  <body>
  <h1 style="color: skyblue">Email Validate</h1>

  <h3 style="color: orange">${message} </h3>

  <form action="validate" method="post">
    <input type="text" name="email">
    <input type="submit" value="validate">
  </form>

  </body>
</html>
