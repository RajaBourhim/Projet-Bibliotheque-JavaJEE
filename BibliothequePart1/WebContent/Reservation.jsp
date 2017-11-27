<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable, project.Livre " %>
<link href="file.css" rel="stylesheet" type="text/css"  media="screen">

	<form class="form-inline" action='Controleur' method='POST'>
		<input class="btn btn-info" type='submit' value='Afficher mes réservations'/> 
		<input type='hidden' name='LivreResa' value='true'/> 
	</form>

<% 	Livre livresReservation[] = (Livre[]) request.getAttribute("ListResa"); 
	String statut = request.getParameter("statut");
	String logged = (String)session.getAttribute("Logged");
	String messageResa = (String)request.getAttribute("MessageResa");

%>
<%-- Partie liste Reservation --%>
<% if(livresReservation != null) { %>
<h3>Vous avez réservé <%=livresReservation.length%> livres (ci-dessous)</h3>
	<table class="table">
		<tr>
       		<td>Auteur</td>
       		<td>Titre</td>
        	<td>Action</td> 	
   		</tr>
	<% 
		Livre listR[] = new Livre[livresReservation.length];
		for(int i = 0; i<	livresReservation.length; i++){
		Livre livre = livresReservation[i];
		int total = livre.getNblivresDispo() + livre.getNbLivresReserves() + livre.getNbLivresEmpruntes(); 
		%>
		<tr>
			<td> <span class="auteur"><%=livre.getAuteur()%></span> </td>
			<td> <span class="titre"><%=livre.getTitre()%></span> </td>
			<form action="Reserver" method="POST">
				<%-- input type="hidden" name="livre" value="<%=livre.getIdLivre()%>"/> --%>
				<% if (request.getParameter("titre") != null){ %>
				<input type="hidden" name="titre" value="<%=request.getParameter("titre")%>"/>
				<% } if (request.getParameter("auteur") != null){ %> 
				<input type="hidden" name="auteur" value="<%=request.getParameter("auteur")%>"/>
				<% } %> 							
        		<td> 
        			<button type="submit" name="DeReserver" class="btn btn-warning" value="DeReserver">Dé-réserver</button>
        	    </td>  		
			</form>
			<% } %>
					</tr>
	</table>
		<% } %>
		
		 <% if(messageResa!=null){%> <p> MESSAGE <%=messageResa%><%} %></p>

 