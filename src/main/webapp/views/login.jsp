<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <title>Todo's page</title>

    <style>
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 60px;
            background-color: #f5f5f5;
        }
    </style>
</head>

<body>
<nav class="navbar navbar-default">

    <a href="/" class="navbar-brand">Brand</a>

    <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="/todo.do">Todos</a></li>
        <li><a href="http://www.in28minutes.com">In28Minutes</a></li>
    </ul>

    <ul class="nav navbar-nav navbar-right">
        <li><a href="/login.do">Login</a></li>
    </ul>

</nav>

<div class="container">
    <div><font color="red">${errorMessage}</font></div>

    <div>
        <form action="/login.do" method="post">
            Enter your name: <input type="text" name="name">
            Enter your password: <input type="password" name="password">

            <input type="submit" value="Login">
        </form>
    </div>
</div>

<footer class="footer">
    <p>footer content</p>
</footer>

<script scr="webjars/jquery/3.2.0/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
