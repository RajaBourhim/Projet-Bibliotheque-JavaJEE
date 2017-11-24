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
		String page = "Accueil.jsp";

		if (request.getParameter("login") != null && request.getParameter("password") != null) {
			logged = Modele.verifieConnexion(request.getParameter("login"),request.getParameter("password"),bibli);
			page = "Accueil.jsp";
			if (logged) {
				indexUser = Modele.recupererIndexUser(request.getParameter("login"), bibli);
				session.setAttribute("Logged", request.getParameter("login"));
				session.setAttribute("Login", "true");
				session.setMaxInactiveInterval(30);
				
				if (!bibli.listUsers.get(indexUser).type) {
					Livre listResa[] = Modele.recupererLivreReserves(request.getParameter("login"), bibli);
					request.setAttribute("ListResa", listResa);
					page = "Adherent.jsp";
				} else {
					page = "Bibliothecaire.jsp";
				}
			    RequestDispatcher rd = getServletContext()
			                               .getRequestDispatcher("/"+page);
			    rd.forward(request, response);

			} else {
				System.out.println("Les identifiants ne sont pas corrects");
				response.sendRedirect(page);
			}
		} else if (request.getParameter("EnterResearch") != null) {
			Livre listR[] = Modele.consulteLivres(request.getParameter("auteur"), request.getParameter("titre"), bibli);
			page = "Accueil.jsp";
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
			
		}  else if (request.getParameter("AddBook") != null) {
			String messageAjout = "ERROR: L'auteur et ou le titre n'ont pas été correctement definis";
			if (request.getParameter("auteur") != null && request.getParameter("titre") != null) {
				bibli = Modele.ajouterLivre(request.getParameter("auteur"),request.getParameter("titre"), bibli);
 				messageAjout = "INFO: Ajout du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" terminé";
			}
			request.setAttribute("MessageAjout", messageAjout);
		    RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/Bibliothecaire.jsp");
		    rd.forward(request, response);
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
