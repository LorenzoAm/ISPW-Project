<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="logic.controllers.UserContainer" %>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Login Check</title>
</head>
<body>
	<div>
		<h1 id = "title" >SkateSpot</h1>
		<a href="index.jsp">
			<img src="../images/home_icon.png" alt="Home"/>
		</a>
	</div>
	
	<h2> Welcome back <%out.println(UserContainer.getInstance().getNome());%>!</h2>
	
	<br><br>
	<% 
	if(UserContainer.getInstance().getSpot()!=null)
	{
		%>
		<h2>You're currently skating in a spot! </h2>
		<%
	}
	%>

</body>
</html>