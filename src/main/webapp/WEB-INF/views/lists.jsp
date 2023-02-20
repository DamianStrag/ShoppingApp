<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lists</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
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
    <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapse${productList.id}" role="button" aria-expanded="false" aria-controls="collapseExample">
        Pokaz(${fn:length(productList.position)})
      </a>
      <div class="collapse" id="collapse${productList.id}">
    <c:forEach items="${productList.position}" var="position">
        <p>${position.product.name}</p>
    </c:forEach>
    </div>
</td>
<td><a class ="btn btn-sm btn-info"  href="/lists/details?id=${productList.id}">szczegoly</a>
<a class ="btn btn-sm btn-danger"  href="/lists/delete?id=${productList.id}">usun</a>
<a class ="btn btn-sm btn-info" href="/lists/edit?id=${productList.id}">edit</a>
</td>
</tr>
</c:forEach>
</table>
<p>
</p>
</div>
<jsp:include page="scripts.jsp"/>
</body>
</html>