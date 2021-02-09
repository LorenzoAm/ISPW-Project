<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList"%>
<%@ page import="logic.entities.Spot"%>
<%@ page import="logic.controllers.ViewSpotController"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>View Spots</title>
</head>
<body>
<%
	ArrayList<Spot> spots;
	spots=ViewSpotController.getInstance().getList();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	int i=0;
%>
<script type="text/javascript">
	function previous()
	{
		setLabels();
	}
	function next()
	{
		setLabels();
	}
	function setLabels()
	{
		var nome = document.getElementById("name");
		var s="<%=spots.get(i).getNome()%>";
		nome.innerHTML=s;
		
		var numero = document.getElementById("number");
	    s="<%=String.valueOf(spots.get(i).getNumeroDiSkater())%>";
		numero.innerHTML=s;
		
		var indirizzo = document.getElementById("address");
		s="<%=spots.get(i).getIndirizzo()%>";
		indirizzo.innerHTML=s;
		
		var zona = document.getElementById("area");
		s="<%=spots.get(i).getZona()%>";
		zona.innerHTML=s;
		
		var municipio = document.getElementById("municipality");
		s="<%=spots.get(i).getComune()%>";
		municipio.innerHTML=s;
		
		var descrizione = document.getElementById("description");
		s="<%=spots.get(i).getDescrizione()%>";
		descrizione.innerHTML=s;
		
		var username = document.getElementById("username");
		s="<%=spots.get(i).getUsername()%>";
		username.innerHTML=s;
		
		var data = document.getElementById("data");
		s="<%=sdf.format(spots.get(i).getData())%>";
		data.innerHTML=s;
	}
</script>
	<div>
		<h1 id = "title" >SkateSpot</h1>
		<a href="index.jsp">
			<img src="images/home_icon.png" alt="BACK"/>
		</a>
	</div>
	
	<div>
		<h1>Spot details</h1> <br><br>
		<label >Spot name : </label>
		<label id="name"> Nome </label> <br><br>
		<label>Number of skater : </label>
		<label id="number"> Number </label> <br><br>
		<label>Address : </label>
		<label id="address"> Address </label> <br><br>
		<label>Area : </label>
		<label id="area"> Area </label> <br><br>
		<label>Municipality : </label>
		<label id="municipality"> Municipality </label> <br><br>
		<label> Type :</label>
		<label id="type"> Type </label><br><br>
		<label> Description :</label>
		<label id="description"> Description </label><br><br>
		<label> Added by :</label>
		<label id="username"> Username </label><br><br>
		<label> On :</label>
		<label id="data"> Date </label>
		<br><br><br>
		<input type="button" value="PREVIOUS" onClick="previous()"/>
		<input type="button" value="NEXT" onClick="next()"/>
		
	</div>
</body>
</html>