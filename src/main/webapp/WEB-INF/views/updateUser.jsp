<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2022-4-23
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.YangZhihao.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");

%>

<form method="post" action="updateUser">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    username<input type="text" name="username" value="<%=u.getUsername()%>"  size="50"><br/>
    password<input type="text" name="password" value="<%=u.getPassword()%>"  size="50"><br/>
    Email<input type="text" name="Email" value="<%=u.getEmail()%>"  size="50"><br/>
    Gemder<td>Gender</td>
    <td>
        <label><input type="radio" name="gender" value="male" <%= "male".equals(u.getGender()) ?"checked" :""%> size="50"/>Male</label>
        <label><input type="radio" name="gender" value="female" <%= "female".equals(u.getGender()) ?"checked" :""%> size="50"/>Female</label>
    </td><br/>
    birthdate<input type="text" name="birthdate" value="<%=u.getBirthdate()%>" size="50"><br/>
    <input type="submit" value="Save Change"size="20" />
</form>
<%@include file="footer.jsp"%>
