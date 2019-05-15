<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
        <head>
                <meta charset="UTF-8">
                <title>Hello ${name}!</title>
                <link href="/css/main.css" rel="stylesheet">
                <link rel='stylesheet' href='/webjars/bootstrap/css/bootstrap.min.css'>
                <script src="/webjars/jquery/2.1.4/jquery.min.js"></script>
                <script src="/js/main.js"></script>
                <script>
                        var id=${book.getId()};
                        $(function() {
                                $("#form").submit(on_submit_modifybook_form);
                        });
                </script>
        </head>
        <body>
                <h2 class="hello-title">${book.getTitle()}</h2>
                <form id="form">
                ID: ${book.getId()};<br>
                Title: <input type="text" value="${book.getTitle()}" id="form_title"><br>
                <input type="submit" value="Save">
                </form>
                <br>
                </form>
                <a href="javascript:kill(${book.getId()})">Delete this book</a><br>
                <a href="/">Go back</a>
        </body>
</html>