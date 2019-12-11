<%@page import="com.luis.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Object o = session.getAttribute("user");
if(o!=null)
{
	User user = (User) o;
	out.println("Current User:"+user.getUsername()+"<br/>");
}
Object o1 = application.getAttribute("userNumber");
if(o1!=null)
{
	int userNumber = (int)o1;
	out.println("Login Number:"+userNumber+"<br/>");
}
%>
Welcome!
<a href="login.jsp">Login</a><br/>
<a href="register.jsp">Register</a><br/>
</body>
</html>