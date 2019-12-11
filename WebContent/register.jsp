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
Register
<form method="post" action="register_do">
Username <input type="text" name="username"/><br/>
Password <input type="password" name="password"/><br/>
Age <input type="text" name="age"> <br/>
Sex <input type="radio" name="sex" value="male">Male 
<input type="radio" name="sex" value="female">Female
<input type="submit" value="register">
</form>
</body>
</html>