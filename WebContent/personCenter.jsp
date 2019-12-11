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
Object o = request.getAttribute("user");
User user = (User) o;
%>
Username:<%= user.getUsername() %><br/>
Age:<%= user.getAge() %><br/>
Sex:<%= user.getSex() %><br/>
</body>
</html>