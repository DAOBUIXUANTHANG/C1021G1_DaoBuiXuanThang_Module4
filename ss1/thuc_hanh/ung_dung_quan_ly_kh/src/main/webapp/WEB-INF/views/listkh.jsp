<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/searchCustomer" method="get">
    <input type="text" name="id" placeholder="Customer Id Enter:">
    <button  type="submit" name="action" value="search">Search</button>
</form>

<table border="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Update</th>
    </tr>
    <c:forEach items="${requestScope['customerList']}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td><a href="/ShowUpdateCustomer?cId=${customer.id}">edit</a>
                <a href="/ShowUpdateCustomer?cId=${customer.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>