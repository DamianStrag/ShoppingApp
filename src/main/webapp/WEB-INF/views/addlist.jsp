<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
<form action="/${action}" method = "post">

    <input class="form-control" name="id" type="hidden" value="${productList.id}"/>
<div class="form-group">
    <label>Data</label>
    <input class="form-control" type="date" name="data" value="${productList.data}"/>
</div>
<div class="form-group">
    <label>Produkty</label>

    <select multiple name="array" class="form-control">
        <c:forEach items="${products}" var="product">
            <option <c:if test="${product.selected}">selected</c:if> value="${product.id}">${product.name}</option>
        </c:forEach>
     </select>
</div>



    <button  class="btn btn-sm btn-info" type="submit">Zapisz</button>

</form>
</div>
</body>
</html>