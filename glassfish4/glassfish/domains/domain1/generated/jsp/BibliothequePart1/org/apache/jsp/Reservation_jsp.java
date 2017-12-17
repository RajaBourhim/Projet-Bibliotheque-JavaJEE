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

public final class Reservation_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<link href=\"file.css\" rel=\"stylesheet\" type=\"text/css\"  media=\"screen\">\r\n");
 	Livre livresReservation[] = (Livre[]) request.getAttribute("ListResa"); 
	String statut = request.getParameter("statut");
	String logged = (String)session.getAttribute("Logged");

      out.write("\t\r\n");
      out.write("\t<form class=\"form-inline\" action='Controleur' method='POST'>\r\n");
      out.write("\t\t<input class=\"btn btn-info\" type='submit' value='Afficher mes réservations'/> \r\n");
      out.write("\t\t<input type='hidden' name='FORM' value='affichageResa'/> \r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write('\r');
      out.write('\n');
 if(livresReservation != null) { 
      out.write("\r\n");
      out.write("<h3>Vous avez réservé ");
      out.print(livresReservation.length);
      out.write(" livres (ci-dessous)</h3>\r\n");
      out.write("\t<table class=\"table\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("       \t\t<td>Auteur</td>\r\n");
      out.write("       \t\t<td>Titre</td>\r\n");
      out.write("        \t<td>Action</td> \t\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("\t");
 
		Livre listR[] = new Livre[livresReservation.length];
		for(int i = 0; i<	livresReservation.length; i++){
		Livre livre = livresReservation[i];
		int total = livre.getNbLivresDispo() + livre.getNbLivresReserves() + livre.getNbLivresEmpruntes(); 
		
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td> <span class=\"auteur\">");
      out.print(livre.getAuteur());
      out.write("</span> </td>\r\n");
      out.write("\t\t\t<td> <span class=\"titre\">");
      out.print(livre.getTitre());
      out.write("</span> </td>\r\n");
      out.write("\t\t\t<td> \r\n");
      out.write("\t\t\t<form action=\"Controleur\" method=\"POST\">\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");
 if (livre.getTitre()!= null){ 
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
      out.write(" \t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t\t<button type=\"submit\" name=\"FORM\" class=\"btn btn-warning\" value=\"deReserver\">Dé-réserver</button>\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t    </td>  \t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write(" ");
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
