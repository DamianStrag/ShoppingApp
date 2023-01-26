<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ProductList</title>
</head>
<body>
<p>Produkty</p>
<table>
  <tr>
    <th>nazwa</th>
    <th>jednostka</th>
    <th>ilosc</th>
    <th>cena</th>
    <th>link</th>
    <th></th>
  </tr>
<c:forEach items="${products}" var="product">
<tr>
<td>${product.nazwa}</td>
<td>${product.jednostka}</td>
<td>${product.ilosc}</td>
<td>${product.cena}</td>
<td>${product.link}</td>
<td><a href="/products/delete?productId=${product.id}">usun</a></td>

</tr>
</c:forEach>
</table>
</body>
</html>