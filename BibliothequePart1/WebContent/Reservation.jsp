<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable, Beans.Livre " %>
<link href="file.css" rel="stylesheet" type="text/css"  media="screen">
<% 	Livre livresReservation[] = (Livre[]) request.getAttribute("ListResa"); 
	String statut = request.getParameter("statut");
	String logged = (String)session.getAttribute("Logged");
%>	
	<form class="form-inline" action='Controleur' method='POST'>
		<input class="btn btn-info" type='submit' value='Afficher mes r�servations'/> 
		<input type='hidden' name='FORM' value='affichageResa'/> 
	</form>
	
<%-- Partie liste Reservation --%>
<% if(livresReservation != null) { %>
<h3>Vous avez r�serv� <%=livresReservation.length%> livres (ci-dessous)</h3>
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
		int total = livre.getNbLivresDispo() + livre.getNbLivresReserves() + livre.getNbLivresEmpruntes(); 
		%>
		<tr>
			<td> <span class="auteur"><%=livre.getAuteur()%></span> </td>
			<td> <span class="titre"><%=livre.getTitre()%></span> </td>
			<form action="Controleur" method="POST">
				<%-- input type="hidden" name="livre" value="<%=livre.getIdLivre()%>"/> --%>
				<% if (livre.getTitre()!= null){ %>
				<input type="hidden" name="titre" value="<%=livre.getTitre()%>"/>
				<% } if (livre.getAuteur() != null){ %> 
				<input type="hidden" name="auteur" value="<%=livre.getAuteur()%>"/>
				<% } %> 							
        		<td> 
        			<button type="submit" name="FORM" class="btn btn-warning" value="deReserver">D�-r�server</button>
        	    </td>  		
			</form>
			<% } %>
					</tr>
	</table>
		<% } %>
 