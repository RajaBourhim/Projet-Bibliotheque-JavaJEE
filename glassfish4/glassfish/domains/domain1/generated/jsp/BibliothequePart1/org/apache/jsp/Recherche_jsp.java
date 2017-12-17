package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import beans.Livre;

public final class Recherche_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
 	Livre livresRecherches[] = (Livre[]) request.getAttribute("listData"); 
	String statut = request.getParameter("statut");
	Livre livresReservation[] = (Livre[]) request.getAttribute("ListResa"); 

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<h3>Rechercher un livre</h3>\r\n");
      out.write("\t<form class=\"form-inline\" action='Controleur' method='POST'>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("    \t<label for=\"auteur\">Auteur:</label>\r\n");
      out.write("    \t<input type='text' name='auteur' class=\"form-control\"/> \r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t<div class=\"form-group\">\r\n");
      out.write("    \t<label for=\"titre\">Titre:</label>\r\n");
      out.write("    \t<input type='text' name='titre' class=\"form-control\"/> \r\n");
      out.write("  \t\t</div>\r\n");
      out.write("\t\t<input class=\"btn btn-default\" type='submit' value='Rechercher'/> \r\n");
      out.write("\t\t<input type='hidden' name='FORM' value='consultation'/> \r\n");
      out.write("\t\t<input type='hidden' name='Statut' value=");
      out.print(statut );
      out.write("/> \r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
 if(livresRecherches != null) { 
      out.write("\r\n");
      out.write("<h3>Livres correspondants à votre recherche</h3>\r\n");
      out.write("\t<table class=\"table\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("       \t\t<td>Auteur</td>\r\n");
      out.write("       \t\t<td>Titre</td>\r\n");
      out.write("       \t\t<td>Nombre de livres empruntes</td>\r\n");
      out.write("       \t\t<td>Nombre total</td>\r\n");
      out.write("       \t\t");
 if(!statut.equals("Accueil")){ 
      out.write("\r\n");
      out.write("        \t<td> </td> \r\n");
      out.write("        \t");
 } 
      out.write(" \t\t\r\n");
      out.write("\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("\t");
 
		Livre listR[] = new Livre[livresRecherches.length];
		for(int i = 0; i<	livresRecherches.length; i++){
		Livre livre = livresRecherches[i];
		int total = livre.getNbLivresDispo() + livre.getNbLivresReserves() + livre.getNbLivresEmpruntes(); 
		
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td> <span class=\"auteur\">");
      out.print(livre.getAuteur());
      out.write("</span> </td>\r\n");
      out.write("\t\t\t<td> <span class=\"titre\">");
      out.print(livre.getTitre());
      out.write("</span> </td>\r\n");
      out.write("\t\t\t<td> <span class=\"titre\">");
      out.print(livre.getNbLivresEmpruntes());
      out.write("</span> </td>\r\n");
      out.write("\t\t\t<td> <span class=\"titre\">");
      out.print(total);
      out.write("</span> </td>\r\n");
      out.write("\t\t\t<td> \r\n");
      out.write("\t\t\t\t<form action=\"Controleur\" method=\"POST\">\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");
 if (livre.getTitre() != null){ 
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"titre\" value=\"");
      out.print(livre.getTitre());
      out.write("\"/>\r\n");
      out.write("\t\t\t\t");
 } if (livre.getAuteur() != null){ 
      out.write(" \r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"auteur\" value=\"");
      out.print(livre.getAuteur());
      out.write("\"/>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");
 if(statut.equals("Bibliothecaire") ){ 
      out.write("\r\n");
      out.write("        \t\r\n");
      out.write("        \t\t\t");
 	if (livre.getNbLivresDispo()>0){ 
      out.write("\r\n");
      out.write("        \t\t\t<button type=\"submit\" name=\"FORM\" value=\"supprimer\" class=\"btn btn-danger\">Supprimer*</button>\r\n");
      out.write("        \t\t\t<button type=\"submit\" name=\"FORM\" value=\"supprimerTout\" class=\"btn btn-danger\"> Tout Supprimer*</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" name=\"FORM\" value=\"emprunter\" class=\"btn btn-success\">Emprunter</button>\r\n");
      out.write("\t\t\t\t\t");
 } 
        				if (livre.getNbLivresEmpruntes()>0){ 
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \t\t\t\t \r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" name=\"FORM\" value=\"restituer\" class=\"btn btn-warning\">Restituer</button>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("        \t  </form>   \t\t\r\n");
      out.write("       \t\t\t");
} 
      out.write("\r\n");
      out.write("       \t\t</td> \t\r\n");
      out.write("       \t\t<td>\t\t\r\n");
      out.write("       \t\t<form action=\"Controleur\" method=\"POST\">\t\t\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");
 if(statut.equals("Adherent") ){ 
					boolean index = false;
					if(livresReservation!=null){
						for(int k = 0; k<	livresReservation.length; k++){
							Livre monlivre = livresReservation[k];
							if(monlivre.getAuteur().equals(livre.getAuteur()) && monlivre.getTitre().equals(livre.getTitre())){
								index = true;
							}
						}
					}
						
      out.write("\t\r\n");
      out.write("        \t\t \r\n");
      out.write("        \t\t\t");
 if (livre.getNbLivresDispo()>0){ 
      out.write("\r\n");
      out.write("        \t\t\t<button type=\"submit\" name=\"FORM\" class=\"btn btn-success\" value=\"reserver\">Réserver</button>\r\n");
      out.write("\t\t\t\t\t");
 } 
        			if (livre.getNbLivresEmpruntes()>0 && index){ 
      out.write(" \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" name=\"FORM\" class=\"btn btn-warning\" value=\"deReserver\">Dé-réserver</button>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("        \t    \t\t\r\n");
      out.write("       \t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>  \r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\t <p> *Seuls les livres disponible peuvent être supprimés </p>\r\n");
      out.write("\t\t");
 } 
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
