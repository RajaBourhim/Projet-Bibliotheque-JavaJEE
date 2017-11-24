package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Servlet implementation class ProcessConnexion
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Bibliotheque bibli;
	protected boolean logged = false;
	protected boolean Login = false;
	protected boolean Pass = false;
	protected int indexUser;
	/**
	 * Default constructor.
	 */
	public Controleur() {
		// TODO Auto-generated constructor stub
		bibli = Modele.creerBibliotheque();
		indexUser = -1;

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (request.getParameter("login") != null && request.getParameter("password") != null) {
			logged = Modele.verifieConnexion(request.getParameter("login"),request.getParameter("password"),bibli);
			if (logged) {
				indexUser = Modele.recupererIndexUser(request.getParameter("login"), bibli);
				session.setAttribute("Logged", request.getParameter("login"));
				session.setAttribute("Login", "true");
				session.setMaxInactiveInterval(30);
				if (!bibli.listUsers.get(indexUser).type) {
					response.sendRedirect("Adherent.jsp");
					session.setAttribute("Adherent", "true");
				} else {
					response.sendRedirect("Bibliothecaire.jsp");
					session.setAttribute("Bibliothecaire", "true");
				}

			} else {
				System.out.println("Les identifiants ne sont pas corrects");
				response.sendRedirect("Accueil.jsp");
			}
		} else if (request.getParameter("EnterResearch") != null) {
			Livre listR[] = Modele.consulteLivres(request.getParameter("auteur"), request.getParameter("titre"), bibli);
			String page = "Accueil.jsp";
			String test = request.getParameter("Statut");
			if(request.getParameter("Statut")!=null){
				if(request.getParameter("Statut").equals("Bibliothecaire")){
					page = "Bibliothecaire.jsp";
				} else if (request.getParameter("Statut").equals("Adherent/")){
					page = "Adherent.jsp";
				}
			}
			if(listR!=null){
			    request.setAttribute("listData", listR);
			    RequestDispatcher rd = getServletContext()
			                               .getRequestDispatcher("/"+page);
			    rd.forward(request, response);
			} else {
				response.sendRedirect(page);
			}
			
		}
		// Log in failed
		else {
			response.sendRedirect("Accueil.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
