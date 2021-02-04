<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Join Spot</title>
</head>
<body>
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
  			<input type="text" id="street" name="street"><br><br>
  			<label>Street number: </label>
  			<input type="text" id="number" name="number"><br><br>
  			<label >City: </label>
  			<input type="text" id="city" name="city"><br><br><br>
  			
  			<input type="submit" value="Join Spot">
  			<input type="reset" value="reset all">
		</form>
	</div>
</body>
</html>