<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sanwich</title>
  </head>
  <body>

  <h1 style="text-transform: capitalize; color: blueviolet">Gia vi cho sandwich </h1>

  <form method="post" action="/save">
    <div class="condiment">
      <input id="radio-1" name="condiment"  value="lettuce" type="checkbox">
      <label for="radio-1" class="radio-label" >Lettuce</label>
    </div>
    <div class="condiment">
      <input id="radio-2" name="condiment"  value="tomato" type="checkbox">
      <label  for="radio-2" class="radio-label">Tomato</label>
    </div>

    <div class="condiment">
      <input id="radio-3" name="condiment"  value="mustard" type="checkbox" >
      <label for="radio-3" class="radio-label">Mustard</label>
    </div>
    <div class="condiment">
      <input id="radio-4" name="condiment" type="checkbox" value="sprouts">
      <label for="radio-4" class="radio-label">Sprouts</label>
    </div>
    <input type="submit"  value="submit"/>
  </form>

  <table>
    <thead>
      <tr>
        <th>Danh sach gia vi chon</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach items="${result}" var="condiment">
        <tr>
          <td>${condiment}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  </body>
</html>
