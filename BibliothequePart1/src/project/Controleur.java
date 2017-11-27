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
	protected String LoginValue = "";
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

		// Connexion du User
		if (request.getParameter("login") != null && request.getParameter("password") != null) {
			logged = Modele.verifieConnexion(request.getParameter("login"),request.getParameter("password"),bibli);
			page = "Accueil.jsp";
			if (logged) {
				indexUser = Modele.recupererIndexUser(request.getParameter("login"), bibli);
				session.setAttribute("Logged", request.getParameter("login"));
				session.setAttribute("Login", "true");
				LoginValue = request.getParameter("login");
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
		// Consulation des livres
		} else if (request.getParameter("EnterResearch") != null) {
			Livre listR[] = Modele.consulteLivres(request.getParameter("auteur"), request.getParameter("titre"), bibli);
			page = "Accueil.jsp";
			String test = request.getParameter("Statut");
			if(request.getParameter("Statut")!=null){
				if(request.getParameter("Statut").equals("Bibliothecaire/")){
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
			
		// Ajout d'un livre
		}  else if (request.getParameter("AddBook") != null) {
			String messageResearch = "ERROR: L'auteur et ou le titre n'ont pas été correctement definis";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				bibli = Modele.ajouterLivre(request.getParameter("auteur"),request.getParameter("titre"), bibli);
				messageResearch = "INFO: Ajout du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" terminé";
			}
			request.setAttribute("MessageResearch", messageResearch);
		    RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/Bibliothecaire.jsp");
		    rd.forward(request, response);
		//Affichage des réservation
		}  else if (request.getParameter("LivreResa") != null) {		
			Livre listResa[] = Modele.recupererLivreReserves(LoginValue, bibli);
			request.setAttribute("ListResa", listResa);
			page = "Adherent.jsp";
		    RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/"+page);
		    rd.forward(request, response);	
		//Suppression d'un livre
		} else if (request.getParameter("Supprimer") != null) {	
			String messageResearch = "ERROR: Cet exemplaire n'a pas pu être supprimé";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				bibli = Modele.supprimerLivre(request.getParameter("auteur"), request.getParameter("titre"), bibli);
				messageResearch = "INFO: Suppression d'un exemplaire du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" terminé";
			}
			request.setAttribute("MessageResearch", messageResearch);
		    RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/Bibliothecaire.jsp");
		    rd.forward(request, response);
		// Suppression de tous les livre
		}else if (request.getParameter("SupprimerTout") != null) {
			String messageResearch = "ERROR: Ce livre n'a pas pu être supprimé";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				bibli = Modele.supprimerTout(request.getParameter("auteur"), request.getParameter("titre"), bibli);
 				messageResearch = "INFO: Suppression de tous les exemplaires disponibles du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" terminé";
			}
			request.setAttribute("MessageResearch", messageResearch);
		    RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/Bibliothecaire.jsp");
		    rd.forward(request, response);    
		// Emprunt dun livre
		}else if (request.getParameter("Emprunter") != null) {
			System.out.println("EMPRUNTER");
			RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/Bibliothecaire.jsp");
		    rd.forward(request, response);
		// Reservation d'un livre 
		} else if (request.getParameter("Reserver") != null){
			String messageResa = "ERROR: Cette réservation n'a pas pu être réalisée";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				bibli = Modele.reserveLivre(request.getParameter("auteur"), request.getParameter("titre"),LoginValue, bibli);
 				messageResa = "INFO: Reservation du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" effectuée";
			}
			request.setAttribute("MessageResa", messageResa);
			Livre listResa[] = Modele.recupererLivreReserves(LoginValue, bibli);
			request.setAttribute("ListResa", listResa);
			page = "Adherent.jsp";
		    RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/"+page);
		    rd.forward(request, response);	
			
		} else if (request.getParameter("DeReserver") != null){
			String messageResa = "ERROR: Cette réservation n'a pas pu être annulée";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				bibli = Modele.annulerReservationLivre(request.getParameter("auteur"), request.getParameter("titre"),LoginValue, bibli);
 				messageResa = "INFO: Annulation de la réservation du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" terminé";
			}
			request.setAttribute("MessageResa", messageResa);
			Livre listResa[] = Modele.recupererLivreReserves(LoginValue, bibli);
			request.setAttribute("ListResa", listResa);
			page = "Adherent.jsp";
		    RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/"+page);
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
