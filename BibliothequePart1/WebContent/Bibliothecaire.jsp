<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 	String logged = (String)session.getAttribute("Logged");
	String messageAjout = (String)request.getAttribute("MessageAjout");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Bibliothecaire</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<h1> Bonjour <%=logged%>, bienvenue dans votre espace personnel</h1>

<h2>Gestion des livres</h2>
<%-- Partie ajouter --%>
<h3>Ajouter un livre</h3>
	<form action='Controleur' method='POST'>
		auteur: <input type='text' name='auteur'/> 
		titre: <input type='text' name='titre'/> 
		<input type='submit' value='Ajouter'/> 
		<input type='hidden' name='AddBook' value='true'/> 
	</form>
	 <% if(messageAjout!=null){%> <p> MESSAGE <%=messageAjout%><%} %></p>
	
<%-- Partie rechercher --%>
 <jsp:include page="Recherche.jsp">
        <jsp:param name="statut" value="Bibliothecaire"/>
  </jsp:include>

<%-- Pour la liste des resultat afficher 2 boutons supprimer et reserver si le livre est dispo - emprunter si le livre est dispo ou reserve --%>

</body>
</html>