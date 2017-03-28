<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo</title>
</head>

<body>
<p>Your Todo's are:</p>

<ol>
    <c:forEach items="${todos}" var="todo">
        <li>${todo.name}</li>
    </c:forEach>
</ol>

</body>
</html>
