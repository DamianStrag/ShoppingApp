<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
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
</body>
</html>