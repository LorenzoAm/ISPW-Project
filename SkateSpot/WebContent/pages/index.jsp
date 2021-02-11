<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ page import="logic.controllers.UserContainer"%>   
    
    
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>

</head>
<body>
	<div>
		<h1 id="title">SkateSpot</h1>
	</div>
	
	<% 
	if(request.getParameter("premium")!=null)
    	{
    		if(UserContainer.getInstance()!=null)
    		{
    			if(UserContainer.getInstance().getTipo().equals("Owner"))
    			{
    				%>
    					<jsp:forward page="premiumArea.jsp"/>
    				<%
    			}
    			else
    			{
    				%>
					<p>You must have an Owner Account in order to access the premium area! </p>
					<%
    			}
    		}
    		else
    		{
    			%>
				<p>You must be logged in the system in order to access the premium area! </p>
				<%
    		}
    	}
	%>
	
	<div>
		<table>
			<tr>
				<th>
					<p></p>
				</th>
				<td >
					<img src="../images/menu_grey.png" alt="MENU"/>
				</td>
				<td>
					<img src="../images/Triangle.png" alt="DROP"/>
				</td>
				<td>
					<form>
								<input type="submit" value="PREMIUM AREA"  name="premium"/>
					</form>
				</td>
				<td>
					<img src="../images/blank.png" alt="SPACE"/>
				</td>
				<td>
					<img src="../images/blank.png" alt="SPACE"/>
				</td>
				<td>
					<img src="../images/blank.png" alt="SPACE"/>
				</td>
				<td>
					<table>
						<tr>
							<td>
							<a href="loginLogout.jsp">
								<img src="../images/login_logout.png" alt="LOGIN-LOGOUT" />
							</a>
							</td>
						</tr>
						<tr>
							<td>
								<p>OR</p>
							</td>
						</tr>
						<tr>
							<td>
								<a href="signUp.jsp">
									<img src="../images/sign_up.png" alt="SIGN UP" />
								</a>
							</td>
						</tr>
					</table>
				</td>
				<td>
						<img src="../images/user_icon.png" alt="ICON"/>
				</td>
			</tr>	
		</table>
		
		<a href="addSpotControl.jsp">
			Add Spot
		</a>
		<br><br>
		<a href="joinLeaveSpot.jsp">
			Join-Leave Spot
		</a>
		
	</div>
	
	<table>
		<tr>
		<th>
		</th>
			<td>
				<img src="../images/blank.png" alt="SPACE"/>
			</td>
			<td>
				<img src="../images/blank.png" alt="SPACE"/>
			</td>
			<td>
				<img src="../images/SkateSpot_Logo.png" alt="LOGO"/>
			</td>
			<td>
				<img src="../images/blank.png" alt="SPACE"/>
			</td>
		</tr>
	</table>
	
	<div id="view-sect">
		<table>
			<tr>
			<th>
			</th>
				<td>
					<a href="viewSpots.jsp">
						<img src="../images/view_spot_button.png" alt="VIEW SPOTS" />
					</a>
				</td>
				<td>
					<img src="../images/blank.png" alt="SPACE"/>
				</td>
				<td>
					<img src="../images/blank.png" alt="SPACE"/>
				</td>
				<td>
					<a href="viewShops.jsp">
						<img src="../images/view_shop_button.png" alt="VIEW SHOPS" />
					</a>
				</td>
			</tr>
		</table>
	</div>
	
</body>	
</html>