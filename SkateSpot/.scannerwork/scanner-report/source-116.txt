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
	int dim=spots.size();
	//utilizzo array paralleli per memorizzare lel informazioni e accedervi dal client
	String[] nomi= new String[dim];
	String[] numeri= new String[dim];
	String[] indirizzi= new String[dim];
	String[] zone= new String[dim];
	String[] municipi= new String[dim];
	String[] descrizioni= new String[dim];
	String[] username= new String[dim];
	String[] date= new String[dim];
	for(int i=0;i<dim;i++)
	{
		nomi[i]=spots.get(i).getNome();
		numeri[i]=String.valueOf(spots.get(i).getNumeroDiSkater());
		indirizzi[i]=spots.get(i).getIndirizzo();
		zone[i]=spots.get(i).getZona();
		municipi[i]=spots.get(i).getComune();
		descrizioni[i]=spots.get(i).getComune();
		username[i]=spots.get(i).getUsername();
		date[i]=sdf.format(spots.get(i).getData());		
	}
	int i=0;
	
%>
<script type="text/javascript">
	var i=0;
	var first=1;
	
	var nomiJ= new Array();
	
	var numeriJ=new Array();
	
	var indirizziJ=new Array();
	
	var zoneJ=new Array();
	
	var municipiJ=new Array();
	
	var descrizioniJ=new Array();
	
	var usernameJ=new Array();
	
	var dateJ=new Array();
	
	<%for(int j=0; j<dim; j++){%>
	nomiJ[<%=j%>] = "<%=nomi[j]%>";
	numeriJ[<%=j%>] = "<%=numeri[j]%>";
	indirizziJ[<%=j%>] = "<%=indirizzi[j]%>";
	zoneJ[<%=j%>] = "<%=zone[j]%>";
	municipiJ[<%=j%>] = "<%=municipi[j]%>";
	descrizioniJ[<%=j%>] = "<%=descrizioni[j]%>";
	usernameJ[<%=j%>] = "<%=username[j]%>";
	dateJ[<%=j%>] = "<%=date[j]%>";
	<%}%>
	
	function previous()
	{
		if(first==1)
		{
			setLabels();
			first=0;
		}
		else
		{
			i--;
			if(i<0)
			{
				i=<%=dim%>-1;
				setLabels();
			}
			else
			{
				setLabels();
			}	
		}
	}
	function next()
	{
		if(first==1)
		{
			setLabels();
			first=0;
		}
		else
		{
			i++;
			if(i==<%=dim%>)
			{
				i=0;
				setLabels();
			}
			else
			{
				setLabels();
			}
		}
	}
	function setLabels()
	{
		var nome = document.getElementById("name");
		nome.innerHTML=nomiJ[i];
		
		var numero = document.getElementById("number");
		numero.innerHTML=numeriJ[i];
		
		var indirizzo = document.getElementById("address");
		indirizzo.innerHTML=indirizziJ[i];
		
		var zona = document.getElementById("area");
		zona.innerHTML=zoneJ[i];
		
		var municipio = document.getElementById("municipality");
		municipio.innerHTML=municipiJ[i];
		
		var descrizione = document.getElementById("description");
		descrizione.innerHTML=descrizioniJ[i];
		
		var username = document.getElementById("username");
		username.innerHTML=usernameJ[i];
		
		var data = document.getElementById("data");
		data.innerHTML=dateJ[i];
	}
</script>

	<div>
		<h1 id = "title" >SkateSpot</h1>
		<a href="index.jsp">
			<img src="../images/home_icon.png" alt="BACK"/>
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