<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable, project.Livre " %>
<% 	Livre livresRecherches[] = (Livre[]) request.getAttribute("listData"); 
	String statut = request.getParameter("statut");
	String messageResearch = (String)request.getAttribute("MessageResearch");
	%>

<% if(messageResearch!=null){%> <p> MESSAGE <%=messageResearch%><%} %></p>
<%-- Partie Consultation --%>
<h3>Rechercher un livre</h3>
	<form class="form-inline" action='Controleur' method='POST'>
		<div class="form-group">
    	<label for="auteur">Auteur:</label>
    	<input type='text' name='auteur' class="form-control"/> 
  		</div>
  		<div class="form-group">
    	<label for="titre">Titre:</label>
    	<input type='text' name='titre' class="form-control"/> 
  		</div>
		<input class="btn btn-default" type='submit' value='Rechercher'/> 
		<input type='hidden' name='EnterResearch' value='true'/> 
		<input type='hidden' name='Statut' value=<%=statut %>/> 
	</form>


<% if(livresRecherches != null) { %>
<h3>Livres correspondants à votre recherche</h3>
	<table class="table">
		<tr>
       		<td>Auteur</td>
       		<td>Titre</td>
       		<td>Nombre de livres empruntes</td>
       		<td>Nombre total</td>
       		<% if(!statut.equals("Accueil")){ %>
        	<td> </td> 
        	<% } %> 		

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
			<td> <span class="titre"><%=livre.getNbLivresEmpruntes()%></span> </td>
			<td> <span class="titre"><%=total%></span> </td>
			
			<form action="Controleur" method="POST">
				<%-- input type="hidden" name="livre" value="<%=livre.getIdLivre()%>"/> --%>
				<% if (livre.getTitre() != null){ %>
				<input type="hidden" name="titre" value="<%=livre.getTitre()%>"/>
				<% } if (livre.getAuteur() != null){ %> 
				<input type="hidden" name="auteur" value="<%=livre.getAuteur()%>"/>
				<% } %>
				
				<%-- Si la personne est bibliothecaire --%>
				<% if(statut.equals("Bibliothecaire") ){ %>
        		<td> 
        			<% 	if (livre.getNblivresDispo()>0){ %>
        			<button type="submit" name="Supprimer" value="Supprimer" class="btn btn-danger">Supprimer*</button>
        			<button type="submit" name="SupprimerTout" value="ttsupp" class="btn btn-danger"> Tout Supprimer*</button>
					<button type="submit" name="Emprunter" value="emprunt" class="btn btn-success">Emprunter</button>
					<% } 
        				if (livre.getNbLivresEmpruntes()>0){ %> 
					<button type="submit" name="action" value="emprunt" class="btn btn-warning">Restituer</button>
					<% } %>
        	    </td>  		
       			<%} %>
       			
       							
				<%-- Si la personne est adherente--%>
				<% if(statut.equals("Adherent") ){ %>
        		<td> 
        			<% if (livre.getNblivresDispo()>0){ %>
        			<button type="submit" name="Reserver" class="btn btn-success" value="Reserver">Réserver</button>
					<% } if (livre.getNbLivresEmpruntes()>0){ %> 
					<button type="submit" name="DeReserver" class="btn btn-warning" value="DeReserver">Dé-réserver</button>
					<% } %>
        	    </td>  		
       			<%} %>
       			
       			

			</form>
			<% } %>
					</tr>
	</table>
		 <p> *Seuls les livres disponible peuvent être supprimés </p>
		<% } %>