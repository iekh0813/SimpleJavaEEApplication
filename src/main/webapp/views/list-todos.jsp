<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>

<div class="container">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Todo</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.name}</td>
                <td>${todo.category}</td>
                <td><a href="/delete-todo.do?todo=${todo.name}&category=${todo.category}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<%@include file="common/footer.jspf" %>

