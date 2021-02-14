<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.controllers.UserContainer" %>
<%@page import="logic.controllers.LogoutController" %>
<% 	if(UserContainer.getInstance()!=null)
	{

		LogoutController.getInstance().logout();
		%>
			<jsp:forward page="logout.jsp"/>
		<%
	}
	else
	{
		%>
		<jsp:forward page="login.jsp"/>
		<%
	}
%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Login Logout</title>
</head>
<body>

</body>
</html>