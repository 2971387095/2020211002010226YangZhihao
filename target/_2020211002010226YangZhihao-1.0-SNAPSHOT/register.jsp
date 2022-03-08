<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2022-3-7
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>New User Registration</h3>
<form>
    <input type="text" name="username" value="username" size="50"><br/>
    <input type="text" name="password" value="password" size="50"><br/>
    <input type="text" name="Email" value="Email" size="50"><br/>
    <td>Gender</td>
    <td>
        <label><input type="radio" name="sex" value="Male" size="50"/>Male</label>
        <label><input type="radio" name="sex" value="Female" size="50"/>Female</label>
    </td><br/>
    <input type="text" name="Email" value="Date of birth(yyy-mm-dd)" size="50"><br/>
    <input type="submit" value="Send data to server"size="20" bgcolor="#00CCCC"/>
</form>
</body>
</html>
