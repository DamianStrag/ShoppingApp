<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ProductList</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
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
</body>
</html>