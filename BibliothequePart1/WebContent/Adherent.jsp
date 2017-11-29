<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 	String logged = (String)session.getAttribute("Logged");
    String statut = "Adherent";
    String message = (String)request.getAttribute("message");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Adhérent</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<%-- Partie header --%>
 <jsp:include page="Header.jsp">
        <jsp:param name="Statut" value="<%=statut%>"/>
        <jsp:param name="Logged" value="<%= logged %>"/>
  </jsp:include>

 <% if(message!=null){%> <p> MESSAGE <%=message%><%} %></p>

<%-- Partie rechercher --%>
 <jsp:include page="Recherche.jsp">
        <jsp:param name="statut" value="<%=statut%>"/>
  </jsp:include>


<%-- Partie Gestion de mes livres --%>
 <jsp:include page="Reservation.jsp">
        <jsp:param name="statut" value="<%=statut%>"/>
  </jsp:include>

<%-- Afficher la liste des livres réservés avec un bouton déréserver pour chaque livre--%>


</body>
</html>