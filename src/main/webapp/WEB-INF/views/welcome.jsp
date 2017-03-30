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
<p>Welcome ${name}</p>
<p>Logged at: <%=date%>
</p>
<p>Your Todo's are:</p>
<p>${todos}</p>

</body>
</html>
