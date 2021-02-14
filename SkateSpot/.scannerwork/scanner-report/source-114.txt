<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.time.LocalDate" %>
<%@page import="java.time.ZoneId" %>    
<%@page import="java.util.ArrayList" %>
<%@page import="logic.controllers.ViewMyShopsController" %>
<%@page import="logic.entities.Shop" %>    
    
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>View My Shops</title>
</head>
<body>

<%
	ArrayList<Shop> shops;
	shops=ViewMyShopsController.getInstance().getList();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	int dim=shops.size();
	//utilizzo array paralleli per memorizzare lel informazioni e accedervi dal client
	String[] nomi= new String[dim];
	String[] indirizzi= new String[dim];
	String[] zone= new String[dim];
	String[] municipi= new String[dim];
	String[] descrizioni= new String[dim];
	String[] username= new String[dim];
	String[] date= new String[dim];
	for(int i=0;i<dim;i++)
	{
		nomi[i]=shops.get(i).getNome();
		indirizzi[i]=shops.get(i).getIndirizzo();
		zone[i]=shops.get(i).getZona();
		municipi[i]=shops.get(i).getComune();
		descrizioni[i]=shops.get(i).getComune();
		username[i]=shops.get(i).getUsername();
		date[i]=sdf.format(shops.get(i).getData());		
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
		
		var indirizzo = document.getElementById("address");
		indirizzo.innerHTML=indirizziJ[i];
		
		var zona = document.getElementById("area");
		zona.innerHTML=zoneJ[i];
		
		var municipio = document.getElementById("municipality");
		municipio.innerHTML=municipiJ[i];
		
		var descrizione = document.getElementById("description");
		descrizione.innerHTML=descrizioniJ[i];
		
		var username = document.getElementById("owner");
		username.innerHTML=usernameJ[i];
		
		var data = document.getElementById("date");
		data.innerHTML=dateJ[i];
	}
</script>

	<div>
		<h1 id = "title" >SkateSpot</h1>
		<a href="premiumArea.jsp">
			<img src="../images/back_icon.png" alt="BACK"/>
		</a>
	</div>
	
	<div>
		<h1>Shop details</h1> <br><br>
		<label>Shop name : </label>
		<label id="name"> Name </label> <br><br>
		<label>Address : </label>
		<label id="address"> Address </label> <br><br>
		<label>Area : </label>
		<label id="area"> Area </label> <br><br>
		<label>Municipality : </label>
		<label id="municipality"> Municipality </label> <br><br>
		<label>Description : </label>
		<label id="description"> Description </label> <br><br>
		<label> Added by :</label>
		<label id="owner"> Owner </label><br><br>
		<label> On :</label>
		<label id="date"> Date </label><br><br><br>
		<input type="submit" value="PREVIOUS" onClick="previous()"/>
		<input type="submit" value="NEXT" onClick="next()"/>
		
	</div>		

</body>
</html>