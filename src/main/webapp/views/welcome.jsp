<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: iekh0813
  Date: 27.03.2017
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<%
    Date date = new Date();
%>
<body>
Welcome ${name}
<br>


Logged at: <%=date%>

</body>
</html>
