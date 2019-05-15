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
        </head>
        <body>
        <h2 class="hello-title">Hello bookkeeper!</h2>
        <div id="books">
        ... loading ...
        </div>
        <br>
        <form id="form">
        <label for="title">Title: </label>
        <input type="text" name="title" id="form_title"><br>
        <input type="submit" value="Add">
        </form>
        </body>
        </html>