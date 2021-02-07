<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.time.LocalDate" %>
<%@page import="java.time.ZoneId" %>    
<%@page import="java.util.ArrayList" %>
<%@page import="logic.controllers.ViewShopController" %>
<%@page import="logic.entities.Shop" %>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>View Shops</title>
</head>
<body>
<%!
	ArrayList<Shop> shops;
	int i=0;
	
	public void nextShop()
	{
		shops = ViewShopController.getInstance().getList();
		if(shops==null)
		{
			//out.println("There is no dhop in our Data Base");
		}
		else
		{
			if(i>=shops.size())
			{
				i=0;
			}
			if(i<0)
			{
				i=shops.size()-1;
			}
			this.setLabels();
		}
		i++;
	}
	
	public void previousShop()
	{
		shops = ViewShopController.getInstance().getList();
		if(shops==null)
		{
			%>
			<p>There is no shop in our database</p>
			<%!
		}
		else
		{
			if(i>=shops.size())
			{
				i=shops.size()-2;
			}
			if(i<0)
			{
				i=shops.size()-1;
			}
			this.setLabels();
		}
		i--;
	}
	
	public void setLabels()
	{
		SimpleDateFormat sdf; 
		
		//application.setAttribute("name",shops.get(i).getNome());
		//request.setAttribute("address",shops.get(i).getIndirizzo());
		//request.setAttribute("area",shops.get(i).getZona());
		//request.setAttribute("municipality",shops.get(i).getComune());
		//request.setAttribute("username",shops.get(i).getUsername());
		//String date = new SimpleDateFormat("dd-MM-yyyy").format(shops.get(i).getData());
		//request.setAttribute("data",date);
		//request.setAttribute("descrizione",shops.get(i).getDescrizione());
	}
	
	
%>
	<div>
		<h1 id = "title" >SkateSpot</h1>
		<a href="index.jsp">
			<img src="images/home_icon.png" alt="BACK"/>
		</a>
	</div>
	
	<div>
		<h1>Shop details</h1> <br><br>
		<label>Shop name : </label>
		<label for="name" id="name"> Name </label> <br><br>
		<label>Address : </label>
		<label for="address" id="address"> Address </label> <br><br>
		<label>Area : </label>
		<label for="area" id="area"> Area </label> <br><br>
		<label>Municipality : </label>
		<label for="municipality" id="municipality"> Municipality </label> <br><br>
		<label>Description : </label>
		<label for="description" id="description"> Description </label> <br><br>
		<label> Added by :</label>
		<label for="owner" id="owner"> Owner </label><br><br>
		<label> On :</label>
		<label for="date" id="date"> Date </label><br><br><br>
		<input type="submit" value="PREVIOUS" onClick="previousShop()"/>
		<input type="submit" value="NEXT" onClick="nextShop()"/>
		
	</div>
	
</body>
</html>