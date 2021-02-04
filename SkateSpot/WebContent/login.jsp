<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div>
		<h1 id = "title" >SkateSpot</h1>
		<a href="index.jsp">
			<img src="images/home_icon.png" alt="Home"/>
		</a>
	</div>
	
	<div>
		<h1>Enter your data</h1> <br>
		<form action="" method="get">
  			<label >Email: </label>
  			<input type="text" id="email" name="email"><br><br>
  			<label>Password: </label>
  			<input type="password" id="password" name="password">
  			<br><br><br>
  			
  			<input type="submit" value="Sign in">
  			<input type="reset" value="reset all">
		</form>
	</div>
	

</body>
</html>