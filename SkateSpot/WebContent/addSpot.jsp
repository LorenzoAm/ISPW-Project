<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Add Spot</title>
</head>
<body>
	<div>
		<h1 id = "title" >SkateSpot</h1>
		<a href="index.jsp">
			<img src="images/home_icon.png" alt="Home"/>
		</a>
	</div>
	
	<div>
		<h1>Add a new spot</h1> <br>
		<form action="" method="get">
  			<label >Spot name: </label>
  			<input type="text" id="name" name="name"><br><br>
  			<label>Street: </label>
  			<input type="text" id="street" name="street"><br><br>
  			<label >Street number: </label>
  			<input type="text" id="number" name="number"><br><br>
  			<label >City: </label>
  			<input type="text" id="city" name="city"><br><br>
  			<label >Area: </label>
  			<input type="text" id="area" name="area"><br><br>
  			<label >Municipality: </label>
  			<input type="text" id="municipality" name="municipality"><br><br>
  			<label >Type (street,skatepark...): </label>
  			<input type="text" id="type" name="type"><br><br>
  			<label>Description (max 200 characters):</label><br>
  			<input type="text" id="description" name="description">
  			<br><br><br>
  		
  			<input type="submit" value="Register spot">
  			<input type="reset" value="reset all">
		</form>
	</div>
	
</body>
</html>