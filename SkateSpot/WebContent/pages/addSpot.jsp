<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.beans.SpotBean" %>
<%@page import="logic.controllers.AddSpotController" %>
<%@page import="logic.exception.ExistingSpotException" %>

<jsp:useBean id="spotBean" scope="request" class="logic.beans.SpotBean"/>
<jsp:setProperty name="spotBean" property="*"/>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Add Spot</title>
</head>
<body>

	<%
		if(request.getParameter("addSpot")!=null)
		{
			SpotBean bean = new SpotBean(request.getParameter("name"),request.getParameter("street"),request.getParameter("number"),request.getParameter("city"),request.getParameter("municipality"),request.getParameter("area"));
			bean.control(request.getParameter("type"),request.getParameter("description"));
			if(bean.check())
			{
				try
				{
					AddSpotController.getInstance().createSpot(bean);
				%>
					<jsp:forward page="addSpotCheck.jsp"/>
					
				<%
				}
				catch(ExistingSpotException e)
				{
					%>
					<jsp:forward page="spotException.jsp"/>
					
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
			<img src="../images/home_icon.png" alt="Home"/>
		</a>
	</div>
	
	<div>
		<h1>Add a new spot</h1> <br>
		<form action="" method="get">
  			<label >Spot name: </label>
  			<input type="text" id="name" name="name" required><br><br>
  			<label>Street: </label>
  			<input type="text" id="street" name="street" required><br><br>
  			<label >Street number: </label>
  			<input type="text" id="number" name="number" required><br><br>
  			<label >City: </label>
  			<input type="text" id="city" name="city" required><br><br>
  			<label >Area: </label>
  			<input type="text" id="area" name="area" required><br><br>
  			<label >Municipality: </label>
  			<input type="text" id="municipality" name="municipality" required><br><br>
  			<label >Type (street,skatepark...): </label>
  			<input type="text" id="type" name="type" required><br><br>
  			<label>Description (max 200 characters):</label><br>
  			<input type="text" id="description" name="description" required>
  			<br><br><br>
  		
  			<input type="submit" value="Register spot" name="addSpot">
  			<input type="reset" value="reset all">
		</form>
	</div>
	
</body>
</html>