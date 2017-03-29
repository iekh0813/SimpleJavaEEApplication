<%@include file="common/header.jspf" %>
<%@include file="common/navbar.jspf" %>

<div class="container">

    <div class="panel panel-default">
        <div class="panel-body">
            <form class="form-horizontal" action="/add-todo.do" method="post">
                <div class="form-group">
                    <label for="todo" class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="todo" name="todo">
                    </div>
                </div>
                <div class="form-group">
                    <label for="category" class="col-sm-2 control-label">Category</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="category" name="category">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success">Add</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="common/footer.jspf" %>
