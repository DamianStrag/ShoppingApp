<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="container">
<p>${productList.data}</p>
<form action="update" method = "post">
<c:forEach items="${productList.position}" var="position">
        <p>${position.product.name} <input type="checkbox"/></p>
    </c:forEach>
</form>
</body>