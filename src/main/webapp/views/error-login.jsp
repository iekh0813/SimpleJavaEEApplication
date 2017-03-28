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

    <a href="/" class="navbar-brand">Java EE Application</a>

    <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="/todo.do">Todos</a></li>
        <li><a href="http://www.google.com">Google</a></li>
    </ul>

    <ul class="nav navbar-nav navbar-right">
        <li><a href="/logout.do">Logout</a></li>
    </ul>

</nav>

<div class="container">

    <div class="alert alert-danger" role="alert">
        <div class="text-center">${errorMessage}</div>
    </div>

    <div class="panel panel-default">
        <div class="panel-body">
            <form class="form-horizontal" action="/login.do" method="post">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success">Login</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

<footer class="footer">
    <p>footer content</p>
</footer>

<script scr="webjars/jquery/3.2.0/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
