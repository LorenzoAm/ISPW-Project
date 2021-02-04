<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<div>
		<h1 id = "title" >SkateSpot</h1>
		<a href="index.jsp">
			<img src="images/home_icon.png" alt="Home"/>
		</a>
	</div>
	
	<div>
		<h1>Create a new account</h1> <br>
		<form action="" method="get">
  			<label >Name: </label>
  			<input type="text" id="name" name="name">
  			<label>Surname: </label>
  			<input type="text" id="surname" name="surname"><br><br>
  			<label >Username: </label>
  			<input type="text" id="username" name="username"><br><br>
  			<label >Email: </label>
  			<input type="text" id="email" name="email"><br><br>
  			<label >New password: </label>
  			<input type="password" id="password" name="password"><br><br>
  			<label >Confirm password: </label>
  			<input type="password" id="confirmPassword" name="confirmPassword"><br><br>
  			<label >Date of birth: </label>
  			<input type="date" id="data" name="data"><br><br>
  			<label>Gender:</label><br>
  			<input type="radio" id="maleButton" name="radio1">
  			<label>Male</label><br>
  			<input type="radio" id="femaleButton" name="radio1">
  			<label>Female</label><br><br>
  			<label>Type of account :</label> <br>
  			<input type="radio" id="skaterButton" name="radio2">
  			<label>Skater(free)</label><br>
  			<input type="radio" id="ownerButton" name="radio2">
  			<label>Shop owner</label><br><br><br>
  			
  			
  			
  			
  			<input type="submit" value="Sign up">
  			<input type="reset" value="reset all">
		</form>
	</div>

</body>
</html>