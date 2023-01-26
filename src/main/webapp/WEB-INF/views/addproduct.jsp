<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product</title>
</head>
<body>
<form action="/saveproduct" method = "post">



    Name:
    <input name ="nazwa"/>


    Jednostka:
    <input name="jednostka"/>


    Ilosc:
    <input name="ilosc" type = "number" lang = "en"/>


    Link:
    <input name="link"/>


    <button type="submit">Zapisz</button>

</form>
</body>
</html>