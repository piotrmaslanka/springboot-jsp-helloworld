<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
    <h2 class="hello-title">Hello ${name}!</h2>
    <c:forEach items="${books}" var="book">
        ${book.getId()} - ${book.getTitle()}<br>
    </c:forEach>
    <br>
    <form action="/book" method="POST">
        <label for="title">Tytuł: </label><input type="text" name="title"><br>
        <label for="id">ID: </label><input type="number" name="id"><br>
        <input type="submit">
    <script src="/js/main.js"></script>
</body>
</html>