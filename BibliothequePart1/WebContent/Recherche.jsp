<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable, Beans.Livre " %>
<% 	Livre livresRecherches[] = (Livre[]) request.getAttribute("listData"); 
	String statut = request.getParameter("statut");
	Livre livresReservation[] = (Livre[]) request.getAttribute("ListResa"); 
%>
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
		<input type='hidden' name='FORM' value='consultation'/> 
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
		int total = livre.getNbLivresDispo() + livre.getNbLivresReserves() + livre.getNbLivresEmpruntes(); 
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
        			<% 	if (livre.getNbLivresDispo()>0){ %>
        			<button type="submit" name="FORM" value="supprimer" class="btn btn-danger">Supprimer*</button>
        			<button type="submit" name="FORM" value="supprimerTout" class="btn btn-danger"> Tout Supprimer*</button>
					<button type="submit" name="FORM" value="emprunter" class="btn btn-success">Emprunter</button>
					<% } 
        				if (livre.getNbLivresEmpruntes()>0){ %>
        
        				 
					<button type="submit" name="FORM" value="restituer" class="btn btn-warning">Restituer</button>
					<% } %>
        	    </td>  		
       			<%} %>
       			
       							
				<%-- Si la personne est adherente--%>
				<% if(statut.equals("Adherent") ){ 
					boolean index = false;
					if(livresReservation!=null){
						for(int k = 0; k<	livresReservation.length; k++){
							Livre monlivre = livresReservation[k];
							if(monlivre.getAuteur().equals(livre.getAuteur()) && monlivre.getTitre().equals(livre.getTitre())){
								index = true;
							}
						}
					}
						%>	
        		<td> 
        			<% if (livre.getNbLivresDispo()>0){ %>
        			<button type="submit" name="FORM" class="btn btn-success" value="reserver">Réserver</button>
					<% } 
        			if (livre.getNbLivresEmpruntes()>0 && index){ %> 
					
					<button type="submit" name="FORM" class="btn btn-warning" value="deReserver">Dé-réserver</button>
					<% } %>
        	    </td>  		
       			<%} %>
       			
       			

			</form>
			<% } %>
					</tr>
	</table>
		 <p> *Seuls les livres disponible peuvent être supprimés </p>
		<% } %>