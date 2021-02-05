<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@page import="logic.beans.SignUpBean" %>
<%@page import="logic.controllers.SignUpController" %>

<jsp:useBean id="signUpBean" scope="request" class="logic.beans.SignUpBean"/>
<jsp:setProperty name="signUpBean" property="*"/>
    
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<%
 	if(request.getParameter("signUp")!=null)
 	{
 		if(signUpBean.check())
 		{
 			SignUpController.getInstance().signUp(signUpBean);
 		%>
 			<jsp:forward page="index.jsp"/>
 		<% 
 		}
 		else
 		{
 			%>
 				<p>entered data aren't correct</p>
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
  			<input type="radio" id="maleButton" name="gender">
  			<label>Male</label><br>
  			<input type="radio" id="femaleButton" name="gender">
  			<label>Female</label><br><br>
  			<label>Type of account :</label> <br>
  			<input type="radio" id="skaterButton" name="typeOfAccount">
  			<label>Skater(free)</label><br>
  			<input type="radio" id="ownerButton" name="typeOfAccount">
  			<label>Shop owner</label><br><br><br>
  			<input type="submit" value="Sign up" name="signUp">
  			<input type="reset" value="reset all">
		</form>
	</div>

</body>
</html>