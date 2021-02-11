<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.time.LocalDate" %>
<%@page import="java.time.ZoneId" %>
<%@page import="logic.beans.SignUpBean" %>
<%@page import="logic.controllers.SignUpController" %>
<%@page import="logic.exception.ExistingEmailException" %>

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
 		SignUpBean bean= new SignUpBean(request.getParameter("name"),request.getParameter("surname"),request.getParameter("username"),request.getParameter("email"),request.getParameter("password"),request.getParameter("confirmPassword"));
 		if(request.getParameter("data")!=null)
 		{
 			String data = request.getParameter("data");
 			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 			Date realDate = dateFormat.parse(data);
 			LocalDate dateInLocalType=realDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
 			bean.control(dateInLocalType,request.getParameter("gender"),request.getParameter("typeOfAccount"));
 			
 		}
 		if(bean.check())
 		{
 			try
 			{
 				SignUpController.getInstance().signUp(bean);
 		%>
 			<jsp:forward page="signUpCheck.jsp"/>
 		<% 
 			}
 			catch(ExistingEmailException e)
 			{
 				%>
 	 			<jsp:forward page="signUpException.jsp"/>
 	 		<%
 			}
 		}
 		else
 		{
 			%>
 			 <p> Wrong data entered! </p>
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
		<h1>Create a new account</h1> <br>
		<form action="" method="get">
  			<label >Name: </label>
  			<input type="text" id="name" name="name" required>
  			<label>Surname: </label>
  			<input type="text" id="surname" name="surname" required><br><br>
  			<label >Username: </label>
  			<input type="text" id="username" name="username" required><br><br>
  			<label >Email: </label>
  			<input type="text" id="email" name="email" required><br><br>
  			<label >New password: </label>
  			<input type="password" id="password" name="password" required><br><br>
  			<label >Confirm password: </label>
  			<input type="password" id="confirmPassword" name="confirmPassword" required><br><br>
  			<label >Date of birth: </label>
  			<input type="date" id="data" name="data" required><br><br>
  			<label>Gender:</label><br>
  			<input type="radio" id="maleButton" name="gender" value="M" required>
  			<label>Male</label><br>
  			<input type="radio" id="femaleButton" name="gender" value="F">
  			<label>Female</label><br><br>
  			<label>Type of account :</label> <br>
  			<input type="radio" id="skaterButton" name="typeOfAccount" value="Skater" required>
  			<label>Skater(free)</label><br>
  			<input type="radio" id="ownerButton" name="typeOfAccount" value="Owner">
  			<label>Shop owner</label><br><br><br>
  			<input type="submit" value="Sign up" name="signUp">
  			<input type="reset" value="reset all">
		</form>
	</div>

</body>
</html>