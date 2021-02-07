<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="logic.beans.LoginBean" %>
<%@page import="logic.controllers.LoginController" %>

<jsp:useBean id="loginBean" scope="request" class="logic.beans.LoginBean"/>
<jsp:setProperty name="loginBean" property="*"/>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<%
		if(request.getParameter("sign")!=null)
		{
			if(loginBean.check())
			{
				LoginController.getInstance().login(loginBean);
				%>
					<jsp:forward page="loginCheck.jsp"/>
					
				<%
			}
			else
			{
				%>
				  <p> Wrong email or password, try again! </p>
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
		<h1>Enter your data</h1> <br>
		<form action="" method="get">
  			<label >Email: </label>
  			<input type="text" id="email" name="email"><br><br>
  			<label>Password: </label>
  			<input type="password" id="password" name="password"/>
  			<br><br><br>
  			<input type="submit" value="Sign in" name="sign"/>
  			<input type="reset" value="Reset all" name="reset"/>
		</form>
	</div>
	

</body>
</html>