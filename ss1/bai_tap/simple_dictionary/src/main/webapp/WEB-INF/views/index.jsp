
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Dictionary</title>
  </head>
  <body>
  <h1 style=" color: green">Vietnamese Dictionary</h1>
  <form method="post" >
    <input type="text" name="search" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
  </form>
  <p>RESULT :${result}</p>
  </body>
</html>
