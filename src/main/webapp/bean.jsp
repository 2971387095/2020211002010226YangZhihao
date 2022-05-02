<%@ page import="com.YangZhihao.week10.StringBean" %><%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2022-5-1
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo-2-week10</title>
</head>
<body>
<h1>use java code to access String bean class</h1>
<jsp:useBean id="bean" class="com.YangZhihao.week10.StringBean"/>
<%
//    com.YangZhihao.week10.StringBean bean=new StringBean();
//    bean.setMessage("Hello Mr bean - from java code ");
%>
<jsp:setProperty name="bean" property="message" value='<%=request.getParameter("message")%>'/>
Message(using java code) :<%=bean.getMessage()%>
<h2>use usebean to access StringBean class in jsp</h2>
message(using getProperty) : <jsp:getProperty name="bean" property="message"/>
</body>
</html>
