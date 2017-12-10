<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable, beans.Livre, beans.Utilisateur " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String logged = (String)session.getAttribute("Logged");
	String titre = request.getParameter("titre");
	String auteur = request.getParameter("auteur");
	String statut = (String)request.getParameter("Statut");
	Utilisateur UtilisateurEmprunt[] = (Utilisateur[]) request.getAttribute("ListUser");	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restitution</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<h2> Restitution d'un livre </h2>
<form action='Controleur' method='POST'>
  <div class="form-group row">
    <label for="inputAuteur" class="col-sm-2 col-form-label">Auteur</label>
    <div class="col-sm-10">
      <input class="form-control" type="text" value="<%=auteur%>" readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Titre</label>
    <div class="col-sm-10">
        <input class="form-control" type="text" value="<%=titre%>" readonly>
    </div>
  </div>
  

  <div>
<% if(UtilisateurEmprunt != null) { %>
  <h3> Ces personnes ont emprunté ce livre</h3>
	<table class="table"> 
		<tr>
       		<td> Utilisateur </td>
        	<td> </td>  		
   		</tr>
	<% for(int i = 0; i<UtilisateurEmprunt.length; i++){
			Utilisateur user = UtilisateurEmprunt[i]; 
		%>
		<tr>
			<td> <span class="User"><%=user.getIdentifiant()%></span> </td>			
        	<td> 
				<input type="hidden" name="titre" value="<%=titre%>"/>
				<input type="hidden" name="auteur" value="<%=auteur%>"/>
				<input type="hidden" name="identifiant" value="<%=user.getIdentifiant()%>"/>
				<input type='hidden' name='ValiderRestitution' value='true'/> 
				<button type="submit" name="FORM" value="validerRestitution" class="btn btn-warning">Restituer</button>
        	</td>  		
       			   			
			<%} %>
		</tr>
	</table>
<%} %>
	</div>
</form>

</body>
</html>