<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable,beans.Livre " %>
<link href="file.css" rel="stylesheet" type="text/css"  media="screen">
<% 	String logged = (String)session.getAttribute("Logged");
%>

	<%-- Partie ajouter --%>
	<h3>Ajouter un livre</h3>
	<form class="form-inline" action='Controleur' method='POST'>
		<div class="form-group">
    	<label for="auteur">Auteur:</label>
    	<input type='text' name='auteur' class="form-control"/> 
  		</div>
  		<div class="form-group">
    	<label for="titre">Titre:</label>
    	<input type='text' name='titre' class="form-control"/> 
  		</div>
		<input type='submit' class="btn btn-default" value='Ajouter'/> 
		<input type='hidden' name='FORM' value='ajoutLivre'/> 
	</form>
