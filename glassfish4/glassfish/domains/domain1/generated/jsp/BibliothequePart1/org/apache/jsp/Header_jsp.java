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

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 	String logged = (String)session.getAttribute("Logged");
	String statut = (String)request.getParameter("Statut");

      out.write("\r\n");
      out.write("\r\n");
 if(logged==null){
	String message = "Connexion interrompue";
	request.setAttribute("message", message);
	RequestDispatcher rd = getServletContext()
            .getRequestDispatcher("/Accueil.jsp");
   rd.forward(request, response);	
	} 
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\t<table>\r\n");
      out.write("\t<tr> \r\n");
      out.write("\t\t<td><h3> Accès ");
      out.print(statut);
      out.write("</h3></td>\r\n");
      out.write("\t\t<td><form class=\"form-inline\" action='Controleur' method='POST'>\r\n");
      out.write("\t\t\t\t<input class=\"btn btn-danger\" type='submit' value='Déconnexion'/> \r\n");
      out.write("\t\t\t\t<input type='hidden' name='FORM' value='deconnexion'/> \r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr> \r\n");
      out.write("\t\t<td><h2> Bonjour ");
      out.print(logged);
      out.write(", bienvenue dans votre espace personnel</h2></td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>");
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
