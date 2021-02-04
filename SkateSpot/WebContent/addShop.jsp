<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Add shop</title>
</head>
<body>
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
  			<input type="text" id="name" name="name"><br><br>
  			<label>VAT number: </label>
  			<input type="text" id="partitaIVA" name="partitaIVA"><br><br>
  			<label >City: </label>
  			<input type="text" id="city" name="city"><br><br>
  			<label >Street: </label>
  			<input type="text" id="street" name="street"><br><br>
  			<label >Street number: </label>
  			<input type="text" id="number" name="number"><br><br>
  			<label >Municipality: </label>
  			<input type="text" id="municipality" name="municipality"><br><br>
  			<label >Area: </label>
  			<input type="text" id="area" name="area"><br><br>
  			<label>Description (max 200 characters):</label><br>
  			<input type="text" id="description" name="description">
  			<br><br><br>
  		
  			<input type="submit" value="Register shop">
  			<input type="reset" value="reset all">
		</form>
	</div>
</body>
</html>