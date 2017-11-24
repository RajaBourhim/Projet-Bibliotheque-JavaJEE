
<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable, project.Livre " %>
<link href="file.css" rel="stylesheet" type="text/css"  media="screen">
<% 	Livre livresRecherches[] = (Livre[]) request.getAttribute("listData"); 
	String statut = request.getParameter("statut");%>

<%-- Partie Consultation --%>
<h3>Rechercher un livre</h3>
	<form action='Controleur' method='POST'>
		auteur: <input type='text' name='auteur'/> 
		titre: <input type='text' name='titre'/> 
		<input type='submit' value='Rechercher'/> 
		<input type='hidden' name='EnterResearch' value='true'/> 
		<input type='hidden' name='Statut' value=<%=statut %>/> 
	</form>
<%=request.getParameter("statut")%>


<% if(livresRecherches != null) { %>
<h3>Livres correspondants à votre recherche</h3>
	<table>
		<tr>
       		<td>Auteur</td>
       		<td>Titre</td>
       		<td>Nombre de disponibilites</td>
       		<td>Nombre total</td>
        	<td> </td>  		

   		</tr>
	<% 
		Livre listR[] = new Livre[livresRecherches.length];
		for(int i = 0; i<	livresRecherches.length; i++){
		Livre livre = livresRecherches[i];
		int total = livre.getNblivresDispo() + livre.getNbLivresReserves() + livre.getNbLivresEmpruntes(); 
		%>
		<tr>
			<td> <span class="auteur"><%=livre.getAuteur()%></span> </td>
			<td> <span class="titre"><%=livre.getTitre()%></span> </td>
			<td> <span class="titre"><%=livre.getNblivresDispo()%></span> </td>
			<td> <span class="titre"><%=total%></span> </td>
			
			<form action="Recherche" method="POST">
				<%-- input type="hidden" name="livre" value="<%=livre.getIdLivre()%>"/> --%>
				<% if (request.getParameter("titre") != null){ %>
				<input type="hidden" name="titre" value="<%=request.getParameter("titre")%>"/>
				<% } if (request.getParameter("auteur") != null){ %> 
				<input type="hidden" name="auteur" value="<%=request.getParameter("auteur")%>"/>
				<% } %>
				
				<%-- Si la personne est bibliothecaire --%>
				<% if(statut.equals("Bibliothecaire") ){ %>
        		<td> 
        			<% if (livre.getNblivresDispo()>0){ %>
        			<button type="submit" name="action" value="supp">Supprimer*</button>
        			<button type="submit" name="action" value="ttsupp"> Tout Supprimer*</button>
					<button type="submit" name="action" value="emprunt" >Emprunter</button>
					<% } if (livre.getNbLivresEmpruntes()>0){ %> 
					<button type="submit" name="action" value="emprunt">Restituer</button>
					<% } %>
        	    </td>  		
       			<%} %>
       			
       							
				<%-- Si la personne est adherente--%>
				<% if(statut.equals("Adherent") ){ %>
        		<td> 
        			<% if (livre.getNblivresDispo()>0){ %>
        			<button type="submit" name="action" value="reserver">Reserver</button>
					<% } if (livre.getNbLivresEmpruntes()>0){ %> 
					<button type="submit" name="action" value="emprunt">Restituer</button>
					<% } %>
        	    </td>  		
       			<%} %>
       			
       			

			</form>
			<% } %>
					</tr>
	</table>
		 <p> *Seuls les livres disponible peuvent être supprimés </p>
		<% } %>

 