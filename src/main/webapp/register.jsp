<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2022-3-7
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
<h3>New User Registration</h3>
<form method="post" action="register">
    username<input type="text" name="username"  size="50"><br/>
    password<input type="text" name="password"  size="50"><br/>
    Email<input type="text" name="Email"  size="50"><br/>
    Gemder<td>Gender</td>
    <td>
        <label><input type="radio" name="gender" size="50"/>Male</label>
        <label><input type="radio" name="gender"  size="50"/>Female</label>
    </td><br/>
    birthdate<input type="text" name="birthdate" value="Date of birth(yyy-mm-dd)" size="50"><br/>
    <input type="submit" value="register"size="20" />
</form>
<%@include file="footer.jsp"%>


