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

public final class AjoutLivre_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<h3>Ajouter un livre</h3>\r\n");
      out.write("\t<form class=\"form-inline\" action='Controleur' method='POST'>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("    \t<label for=\"auteur\">Auteur:</label>\r\n");
      out.write("    \t<input type='text' name='auteur' class=\"form-control\"/> \r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t<div class=\"form-group\">\r\n");
      out.write("    \t<label for=\"titre\">Titre:</label>\r\n");
      out.write("    \t<input type='text' name='titre' class=\"form-control\"/> \r\n");
      out.write("  \t\t</div>\r\n");
      out.write("\t\t<input type='submit' class=\"btn btn-default\" value='Ajouter'/> \r\n");
      out.write("\t\t<input type='hidden' name='FORM' value='ajoutLivre'/> \r\n");
      out.write("\t</form>\r\n");
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
