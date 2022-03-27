

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp"%>
<h1><%= "Hello World!!!" %>
</h1>
<h1><%= "Welcome to my page"%></h1>
<br/>
<a href="hello-servlet">Hello-servlet-week1</a>
<br/>
<a href="hello.js">Student info Servlet-week2</a>
<br/>
<a href="life">Life Cycle Servlet-week3</a>
<br/>
<a href="register.jsp">Register-getParamester-week3</a>
<br/>
<a href="jdbc">Config parameter-week4</a>
<br/>
<a href="register.jsp">Register JDBC -week5</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>
<a href="logo.jpg">login-week5</a>


<a href="hello-servlet">Hello Servlet</a>
<form>
    <span style="...">New User Registration</span><br/><br/>
    <span style="...">Username</span><input type="text" name="name" required="true" style="..."><br/><br/>
    <span style="...">Password</span><input type="password" name="password" required="true" style="..."><br/><br/>
    <span style="...">Username</span><input type="email" name="email" required="true" style="..."><br/><br/>
    <span style="...">Gender</span>
    <span style="...">Male</span><input type="radio">
    <span style="...">Female</span><input type="radio"><br/><br/>
    <span style="...">Date of birth(yyy-mm-dd)</span><input type="date" pattern="yyy-mm-dd"required="true" style="..."><br/><br/>
    <input type="submit " value="register" style="...">
</form>
<%@include file="footer.jsp"%>
