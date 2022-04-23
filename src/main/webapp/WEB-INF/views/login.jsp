<%@ page import="jakarta.servlet.http.Cookie" %><%--
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
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVale="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVale=c.getValue();
            }
        }
    }
%>
<br/>
<form method="post" action="register">
    Username<input type="text" name="username"  value="<%=username%>" size="50"><br/>
    Password<input type="text" name="password" value="<%=password%>"  size="50"><br/>
            <input type="checkbox" name="rememberMe" value="1"<%=rememberMeVale.equals("1")?"checked":""%>checked/>RememberMe<br/>
    <input type="submit" value="login"size="20" />
</form>
<%@include file="footer.jsp"%>
