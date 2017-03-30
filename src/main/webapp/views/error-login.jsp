<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>

<div class="container">

    <% System.out.println("error-login.jsp"); %>

    <div class="alert alert-danger" role="alert">
        <div class="text-center">${errorMessage}</div>
    </div>

    <div class="panel panel-default">
        <div class="panel-body">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/login.do" method="post">
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

<%@include file="common/footer.jspf" %>
