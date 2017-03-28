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
        <li><a href="/logout.do">Logout</a></li>
    </ul>

</nav>

<div class="container">
    <p>Welcome ${name}</p>
    <p>Your Todo's are:</p>

    <ol>
        <c:forEach items="${todos}" var="todo">
            <li>${todo.name} &nbsp; &nbsp; <a href="/delete-todo.do?todo=${todo.name}">Delete</a></li>
        </c:forEach>
    </ol>

    <form action="/add-todo.do" method="post">
        <input type="text" name="todo"/>
        <input type="submit" value="Add"/>
    </form>
</div>

<footer class="footer">
    <div>Welcome <strong>${name}</strong></div>
    <div>Logged at ${loginDate}</div>
</footer>

<script scr="webjars/jquery/3.2.0/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
