<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
<form action="/saveproduct" method = "post">

    <input class="form-control" name="id" type="hidden" value="${product.id}"/>
<div class="form-group">
    <label>Name</label>
    <input class="form-control" placeholder="nazwa" name ="name" value="${product.name}"/>
</div>
<div class="form-group">
    <label>Jednostka</label>
    <input class="form-control" placeholder="jednostka" name="unit" value="${product.unit}"/>
</div>
<div class="form-group">
    <label>Ilosc</label>
    <input class="form-control" name="quantity" type="number" min="1" lang="en" value="${product.quantity}"/>
</div>
<div class="form-group">
    <label>Link</label>
    <input class="form-control" name="link" value="${product.link}"/>
</div>

    <button class="btn btn-sm btn-info" type="submit">Zapisz</button>

</form>
</div>
<jsp:include page="scripts.jsp"/>
</body>
</html>