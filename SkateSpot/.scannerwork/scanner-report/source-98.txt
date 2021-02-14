<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.controllers.UserContainer" %>
<%@page import="logic.controllers.LeaveSpotController" %>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Join-Leave Spot</title>
</head>
<body>
	<% 
	if(UserContainer.getInstance()!=null)
	{
		if(UserContainer.getInstance().getSpot()==null)
		{
		%>
			<jsp:forward page="joinSpot.jsp" />
		<%
		}
		else
		{
			LeaveSpotController.getInstance().leaveSpot();
			%>
			<jsp:forward page="leaveSpotCheck.jsp" />
			<%
		}
	}
	else
	{
	%>
		<jsp:forward page="joinLeaveSpotDenied.jsp" />
	<%	
	}
	%>
</body>
</html>