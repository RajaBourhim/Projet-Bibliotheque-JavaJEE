<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable, beans.Livre " %>
<link href="file.css" rel="stylesheet" type="text/css"  media="screen">
<% String statut = request.getParameter("statut");
String message = (String)request.getAttribute("message");

%>

<%-- Partie Connexion --%>
<h3>Connexion au portail</h3>
	<form class="form-inline" action='Controleur' method='POST'>
		<div class="form-group">
    	<label for="login">Login:</label>
    	<input type='text' name='login'class="form-control"/> 
  		</div>
  		<div class="form-group">
    	<label for="pwd">Password:</label>
    	<input type='password' name='password' class="form-control"/> 
  		</div>
		<input class="btn btn-default" type='submit' value='Connecter'/> 
	</form>
	 <% if(message!=null){%> <p> MESSAGE <%=message%><%} %></p>