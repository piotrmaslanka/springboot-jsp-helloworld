<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
    <link href="/css/main.css" rel="stylesheet">
    <link rel='stylesheet' href='/webjars/bootstrap/css/bootstrap.min.css'>
    <script src="/webjars/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        function on_submit() {
            $.post('/book', {
                'title': $("#form_title").val
            }, function() {
                $("<div>"
            });
        }
    </script>
</head>
<body>
    <h2 class="hello-title">Hello ${name}!</h2>
    <div id="books">
        <c:forEach items="${books}" var="book">
            ${book.getId()} - ${book.getTitle()}<br>
        </c:forEach>
    </div>
    <br>
    <form action="/book" method="POST">
        <label for="title">Tytuł: </label><input type="text" name="title" id="form_title"><br>
        <input type="submit">
    <script src="/js/main.js"></script>
</body>
</html>