<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 	String logged = (String)session.getAttribute("Logged");
	String message = (String)request.getAttribute("message");
	String statut = "Bibliothecaire";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Bibliothecaire</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>


<%-- Partie header --%>
 <jsp:include page="Header.jsp">
        <jsp:param name="Statut" value="<%=statut%>"/>
        <jsp:param name="Logged" value="<%= logged %>"/>
  </jsp:include>

 <% if(message!=null){%> <p> MESSAGE <%=message%><%} %></p>
 
<h2>Gestion des livres</h2>
<%-- Partie ajouter --%>
<%-- Partie rechercher --%>
 <jsp:include page="AjoutLivre.jsp">
        <jsp:param name="statut" value="Bibliothecaire"/>
  </jsp:include>
	
<%-- Partie rechercher --%>
 <jsp:include page="Recherche.jsp">
        <jsp:param name="statut" value="Bibliothecaire"/>
  </jsp:include>

<%-- Pour la liste des resultat afficher 2 boutons supprimer et reserver si le livre est dispo - emprunter si le livre est dispo ou reserve --%>

</body>
</html>