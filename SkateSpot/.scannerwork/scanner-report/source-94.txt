<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="logic.controllers.UserContainer" %>
<% 	if(UserContainer.getInstance()!=null)
	{

		%>
			<jsp:forward page="addSpot.jsp"/>
		<%
	}
	else
	{
		%>
		<jsp:forward page="addSpotDenied.jsp"/>
		<%
	}
%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Add Spot Control</title>
</head>
<body>

</body>
</html>