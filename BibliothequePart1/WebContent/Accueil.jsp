<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable, project.Livre" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>

<%-- Partie Connexion --%>
<h3>Connexion au portail</h3>
	<form action='Controleur' method='POST'>
		Login: <input type='text' name='login'/> 
		Password: <input type='password' name='password'/> 
		<input type='submit' value='Connecter'/> 
	</form>


 <jsp:include page="Recherche.jsp">
        <jsp:param name="statut" value="Accueil"/>
  </jsp:include>

<body>

</body>
</html>