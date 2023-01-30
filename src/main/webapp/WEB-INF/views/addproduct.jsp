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

    <input  name = "id" type = "hidden" value="${product.id}"/>

    Name:
    <input  name ="nazwa" value="${product.nazwa}"/>


    Jednostka:
    <input name="jednostka" value="${product.jednostka}"/>


    Ilosc:
    <input name="ilosc" type = "number" lang = "en" value="${product.ilosc}"/>


    Link:
    <input name="link" value="${product.link}"/>


    <button class ="btn btn-sm btn-info" type="submit">Zapisz</button>

</form>
</div>
</body>
</html>