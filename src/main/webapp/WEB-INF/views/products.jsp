
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ShoppingApp</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="head.jsp"/>
</head >
<body>
<jsp:include page="menu.jsp"/>
<div class="container">

<p>Produkty</p>
<table class = "table">
  <tr>
    <th>nazwa</th>
    <th>jednostka</th>
    <th>ilosc</th>
    <th>cena</th>
    <th>link</th>
    <th><a class ="btn btn-sm btn-success" href="/products/add">Dodaj</a></th>
  </tr>
<c:forEach items="${products}" var="product">
<tr>
<td>${product.name}</td>
<td>${product.unit}</td>
<td>${product.quantity}</td>
<td>${product.price}</td>
<td>${product.link}</td>
<td><a class ="btn btn-sm btn-danger"  href="/products/delete?productId=${product.id}">usun</a></td>
<td><a class ="btn btn-sm btn-info" href="/products/edit?productId=${product.id}">edit</a></td>

</tr>
</c:forEach>
</table>
</div>
<jsp:include page="scripts.jsp"/>
</body>
</html>