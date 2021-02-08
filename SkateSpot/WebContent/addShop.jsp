<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="logic.beans.ShopBean" %>
<%@page import="logic.controllers.AddShopController" %>
<%@page import="logic.exception.ExistingShopException" %>

<jsp:useBean id="shopBean" scope="request" class="logic.beans.ShopBean"/>
<jsp:setProperty name="shopBean" property="*"/>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Add shop</title>
</head>
<body>

	<%
		if(request.getParameter("addShop")!=null)
		{
			ShopBean bean = new ShopBean(request.getParameter("name"),request.getParameter("city"),request.getParameter("partitaIVA"),request.getParameter("municipality"),request.getParameter("area"),request.getParameter("description"));
			bean.control(request.getParameter("street"),request.getParameter("number"));
			if(bean.check())
			{
				try
				{
					AddShopController.getInstance().createShop(bean);
				%>
					<jsp:forward page="addShopCheck.jsp"/>
					
				<%
				}
				catch(ExistingShopException e)
				{
					%>
					<jsp:forward page="shopException.jsp"/>
					
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
		<a href="premiumArea.jsp">
			<img src="images/back_icon.png" alt="BACK"/>
		</a>
	</div>
	
	<div>
		<h1>Enter your shop details</h1> <br>
		<form action="" method="get">
  			<label >Shop name: </label>
  			<input type="text" id="name" name="name" required><br><br>
  			<label>VAT number: </label>
  			<input type="text" id="partitaIVA" name="partitaIVA" required><br><br>
  			<label >City: </label>
  			<input type="text" id="city" name="city" required><br><br>
  			<label >Street: </label>
  			<input type="text" id="street" name="street" required><br><br>
  			<label >Street number: </label>
  			<input type="text" id="number" name="number" required><br><br>
  			<label >Municipality: </label>
  			<input type="text" id="municipality" name="municipality" required><br><br>
  			<label >Area: </label>
  			<input type="text" id="area" name="area" required><br><br>
  			<label>Description (max 200 characters):</label><br>
  			<input type="text" id="description" name="description" required>
  			<br><br><br>
  		
  			<input type="submit" value="Register shop" name="addShop">
  			<input type="reset" value="reset all">
		</form>
	</div>
</body>
</html>