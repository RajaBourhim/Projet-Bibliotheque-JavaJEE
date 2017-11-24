<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable, project.Livre " %>
<link href="file.css" rel="stylesheet" type="text/css"  media="screen">
<% String statut = request.getParameter("statut");%>

<%-- Partie Connexion --%>
<h3>Connexion au portail</h3>
	<form action='Controleur' method='POST'>
		Login: <input type='text' name='login'/> 
		Password: <input type='password' name='password'/> 
		<input type='submit' value='Connecter'/> 
	</form>