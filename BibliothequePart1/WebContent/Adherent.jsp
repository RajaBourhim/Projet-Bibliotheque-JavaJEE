<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 	String logged = (String)session.getAttribute("Logged");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Adh�rent</title>
</head>
<body>

<h1> Bonjour <%=logged%>, bienvenue dans votre espace personnel</h1>

<%-- Partie r�servation d'un livre --%>
<%-- afficher la liste des livres --%>

<%-- Partie rechercher --%>
 <jsp:include page="Recherche.jsp">
        <jsp:param name="statut" value="Adherent"/>
  </jsp:include>

<%-- Partie Gestion de mes livres --%>
 <jsp:include page="Reservation.jsp">
        <jsp:param name="statut" value="Adherent"/>
  </jsp:include>

<%-- Afficher la liste des livres r�serv�s avec un bouton d�r�server pour chaque livre--%>


</body>
</html>