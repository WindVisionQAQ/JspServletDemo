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
Object o = request.getAttribute("message");
if(o!=null){
	out.println(o);
}
%>
Login<br/>
<hr/>
<form method="post" action="login_do">
Username<input type="text" name="username"><br/>
Password<input type="password" name="password"><br/>
<input type="submit" value="Login">
</form>
</body>
</html>