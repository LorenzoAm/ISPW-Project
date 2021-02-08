<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.beans.JoinSpotBean" %>
<%@page import="logic.controllers.JoinSpotController" %>
<%@page import="logic.exception.SpotNotFoundException" %>
<%@page import="logic.exception.FullSpotException" %>

<jsp:useBean id="joinBean" scope="request" class="logic.beans.JoinSpotBean"/>
<jsp:setProperty name="joinBean" property="*"/>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Join Spot</title>
</head>
<body>
	<%
		if(request.getParameter("join")!=null)
		{
			JoinSpotBean bean = new JoinSpotBean(request.getParameter("street"),request.getParameter("number"),request.getParameter("city"));
			if(bean.check())
			{
				try
				{
					JoinSpotController.getInstance().joinSpot(bean);
					%>
						<jsp:forward page="joinSpotCheck.jsp"/>
					<%
				}
				catch(SpotNotFoundException e)
				{
					%>
					<jsp:forward page="spotNotFoundException.jsp"/>
					<%
				}
				catch(FullSpotException e)
				{
					%>
					<jsp:forward page="fullSpotException.jsp"/>
					<%
				}
			}
			else
			{
				%>
					<p>Wrong data entered !</p>
				<%
			}
		}
	%>
	<div>
		<h1 id = "title" >SkateSpot</h1>
		<a href="index.jsp">
			<img src="images/home_icon.png" alt="Home"/>
		</a>
	</div>
	
	<div>
		<h1>Enter the spot location</h1> <br>
		<form action="" method="get">
  			<label >Street: </label>
  			<input type="text" id="street" name="street" required><br><br>
  			<label>Street number: </label>
  			<input type="text" id="number" name="number" required><br><br>
  			<label >City: </label>
  			<input type="text" id="city" name="city" required><br><br><br>
  			
  			<input type="submit" value="Join Spot" name="join">
  			<input type="reset" value="reset all">
		</form>
	</div>
</body>
</html>