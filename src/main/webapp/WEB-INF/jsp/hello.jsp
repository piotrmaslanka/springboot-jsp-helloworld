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
        function on_submit(e) {
            $.post("/book", {
                'title': $("#form_title").val()
            }, function(data) {
                $('#books').append(
                    $('<div id="book'+data.id+'">'+data.id+' - '+data.title+' <a href="javascript:kill('+data.id+'")>Kasuj</a></div>')
                );
            });
            e.preventDefault();
        }
        function kill(id) {
            $.ajax({
                url: '/book',
                type: 'DELETE',
                data: {
                    id: id
                },
                success: function() {
                    $("#book"+id).remove();
                }
            });
        }

    </script>
</head>
<body>
    <h2 class="hello-title">Hello ${name}!</h2>
    <div id="books">
        <c:forEach items="${books}" var="book">
            <div id="book${book.getId()}">${book.getId()} - ${book.getTitle()}
            <a href="javascript:kill(${book.getId()})">Kasuj</a>
            </div>
        </c:forEach>
    </div>
    <br>
    <form id="form">
        <label for="title">Tytuł: </label><input type="text" name="title" id="form_title"><br>
        <input type="submit" value="Dodaj">
    <script src="/js/main.js"></script>
    <script>
        $('#form').submit(on_submit);
    </script>
</body>
</html>