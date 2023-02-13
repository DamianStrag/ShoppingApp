<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lists</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
<p>Lista Zakupow</p>
<table class = "table">
  <tr>
    <th>Data</th>
    <th>Pozycja</th>
    <th><a class ="btn btn-sm btn-success" href="/addlist">Dodaj</a></th>
  </tr>
<c:forEach items="${productlists}" var="productList">

<tr>
<td>${productList.data}</td>
<td>
    <c:forEach items="${productList.position}" var="position">
        <p>${position.product.name}</p>
    </c:forEach>
</td>
<td><a class ="btn btn-sm btn-danger"  href="/lists/delete?id=${productList.id}">usun</a></td>
<td><a class ="btn btn-sm btn-info" href="/lists/edit?id=${productList.id}">edit</a></td>

</tr>
</c:forEach>
</table>
</div>
</body>
</html>