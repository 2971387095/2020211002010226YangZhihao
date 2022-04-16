<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2022-3-27
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if (!(request.getAttribute("mesage") ==null)){
        out.print(request.getAttribute("message"));
    }
%>
<br/>
<form method="post" action="register">
    username<input type="text" name="username"  size="50"><br/>
    password<input type="text" name="password"  size="50"><br/>
    <input type="submit" value="login"size="20" />
</form>
<%@include file="footer.jsp"%>
