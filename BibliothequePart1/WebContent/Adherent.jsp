<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Adhérent</title>
</head>
<body>

<%-- Partie réservation d'un livre --%>
<%-- afficher la liste des livres --%>

<%-- Partie rechercher --%>
 <jsp:include page="Recherche.jsp">
        <jsp:param name="statut" value="Adherent"/>
  </jsp:include>

<%-- Partie Gestion de mes livres --%>


<%-- Afficher la liste des livres réservés avec un bouton déréserver pour chaque livre--%>


</body>
</html>