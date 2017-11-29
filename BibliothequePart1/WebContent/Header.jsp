<%@page import = "java.io.*,java.util.*,java.util.ArrayList,java.util.Enumeration,java.util.Hashtable,Beans.Livre " %>
<link href="file.css" rel="stylesheet" type="text/css"  media="screen">
<% 	String logged = (String)session.getAttribute("Logged");
	String statut = (String)request.getParameter("Statut");
%>

<% if(logged==null){
	String message = "Connexion interrompue";
	request.setAttribute("message", message);
	RequestDispatcher rd = getServletContext()
            .getRequestDispatcher("/Accueil.jsp");
   rd.forward(request, response);	
	} %>
}
	<table>
	<tr> 
		<td><h3> Accès <%=statut%></h3></td>
		<td><form class="form-inline" action='Controleur' method='POST'>
				<input class="btn btn-danger" type='submit' value='Déconnexion'/> 
				<input type='hidden' name='FORM' value='deconnexion'/> 
			</form>
		</td>
	</tr>
	<tr> 
		<td><h2> Bonjour <%=logged%>, bienvenue dans votre espace personnel</h2></td>
		<td>
		</td>
	</tr>
</table>