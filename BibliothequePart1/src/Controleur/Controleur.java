package Controleur;

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

import Beans.Bibliotheque;
import Beans.Livre;
import Beans.Modele;
import Beans.Utilisateur;

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
		
		RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/"+page);
	   rd.forward(request, response);	

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		String page = "Accueil.jsp";
		String formulaire = request.getParameter("FORM");
		String message="";
		
		// Connexion
		if (request.getParameter("login") != null && request.getParameter("password") != null) {
			page = "Accueil.jsp";
			message = "Identifiants pas correctes";
			// Retourne true si le login et password sont bons
			logged = Modele.verifieConnexion(request.getParameter("login"),request.getParameter("password"),bibli);
			if (logged) {
				indexUser = Modele.recupererIndexUser(request.getParameter("login"), bibli);
				session.setAttribute("Logged", request.getParameter("login"));
				LoginValue = request.getParameter("login");
				session.setMaxInactiveInterval(200);
				
				if (!bibli.getListUsers().get(indexUser).isType()) {
					session.setAttribute("Statut", false);
					Livre listResa[] = Modele.recupererLivreReserves(request.getParameter("login"), bibli);
					request.setAttribute("ListResa", listResa);
					page = "Adherent.jsp";
					message = "Connexion reussie en tant qu'adherent";
				} else {
					session.setAttribute("Statut", true);
					page = "Bibliothecaire.jsp";
					message = "Connexion reussie en tant que bibliothecaire";
				}

			} 
		} else if (formulaire.equals("consultation")) {
			// Consulation des livres
			message = "Aucun livre ne correspondent a ces criteres";
			Livre listR[] = Modele.consulteLivres(request.getParameter("auteur"), request.getParameter("titre"), bibli);
			page = "Accueil.jsp";
			String test = request.getParameter("Statut");
			if(request.getParameter("Statut")!=null){
				if(request.getParameter("Statut").equals("Bibliothecaire/")){
					page = "Bibliothecaire.jsp";
				} else if (request.getParameter("Statut").equals("Adherent/")){
					Livre listResa[] = Modele.recupererLivreReserves(LoginValue, bibli);
					if(listResa!=null){ 
						request.setAttribute("ListResa", listResa); 
					}
					page = "Adherent.jsp";
				}
			}
			if(listR!=null){
				message = "Les resultats sont affiches ci dessous";
			    request.setAttribute("listData", listR);
			}
		} else if (formulaire.equals("ajoutLivre")){
			// Ajout d'un livre
			message = "ERROR: L'auteur et ou le titre n'ont pas été correctement definis";
			page = "Bibliothecaire.jsp";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				bibli = Modele.ajouterLivre(request.getParameter("auteur"),request.getParameter("titre"), bibli);
				message = "INFO: Ajout du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" terminé";	
			}			
		} else if (formulaire.equals("affichageResa")){
			//Affichage des reservations
			message="Vous avez fait aucune reservation";
			Livre listResa[] = Modele.recupererLivreReserves(LoginValue, bibli);
			if(listResa!=null){ 
				request.setAttribute("ListResa", listResa); 
				message="Voici vos reservations";
			}
			page = "Adherent.jsp";	
		} else if(formulaire.equals("supprimer")) {
			//Suppression d'un livre disponible
			message = "ERROR: Cet exemplaire n'a pas pu être supprimé";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				bibli = Modele.supprimerLivre(request.getParameter("auteur"), request.getParameter("titre"), bibli);
				message = "INFO: Suppression d'un exemplaire du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" terminé";		
			}
			page = "Bibliothecaire.jsp";
		}else if (formulaire.equals("supprimerTout")) {
			// Suppression de tous les livre disponibles
			message = "ERROR: Ce livre n'a pas pu être supprimé";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				bibli = Modele.supprimerTout(request.getParameter("auteur"), request.getParameter("titre"), bibli);
		 		message = "INFO: Suppression de tous les exemplaires disponibles du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" terminé";					
			}
			page = "Bibliothecaire.jsp"; 		
		} else if (formulaire.equals("emprunter")) {
			message = "INFO: Quel adherent veut emprunter ce livre ?";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				request.setAttribute("auteur", request.getParameter("auteur"));
				request.setAttribute("titre", request.getParameter("titre"));
				//On va rediriger vers la page emprunt
				page = "Emprunt.jsp";
			}
		}  else if (formulaire.equals("validerEmprunt")){
			// Valider emprunt d'un livre
			message = "ERROR: Cet exemplaire n'a pas pu être emprunté";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0 && request.getParameter("Identifiant")!=null) {
				bibli = Modele.emprunterLivre(request.getParameter("auteur"), request.getParameter("titre"), request.getParameter("Identifiant"), bibli);
				message = "INFO: Un exemplaire de "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" a été bien été emprunté par "+request.getParameter("Identifiant") ;
			}
			page = "Bibliothecaire.jsp";
		} else if(formulaire.equals("restituer")){
			message = "INFO: Quel adherent veut restituerce livre ?";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				Utilisateur listUser[] = Modele.recupererUsersEmprunt(request.getParameter("auteur"),request.getParameter("titre"),bibli);
				request.setAttribute("ListUser", listUser);
				request.setAttribute("auteur", request.getParameter("auteur"));
				request.setAttribute("titre", request.getParameter("titre"));
				page ="Restitution.jsp";
			}
			
		} else if(formulaire.equals("validerRestitution")){
			message = "ERROR: Cet exemplaire n'a pas pu être restitué";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0 && request.getParameter("identifiant")!=null) {
					bibli =Modele.restituerLivre(request.getParameter("auteur"), request.getParameter("titre"), request.getParameter("identifiant"), bibli);
					message = "INFO: Un exemplaire de "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" emprunté par "+request.getParameter("identifiant") +" a bien été restitué";
				}
			page ="Bibliothecaire.jsp";
		}  else if (formulaire.equals("reserver")){
			message = "ERROR: Cette réservation n'a pas pu être réalisée";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
					bibli = Modele.reserveLivre(request.getParameter("auteur"), request.getParameter("titre"),LoginValue, bibli);
					message = "INFO: Reservation du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" effectuée";
			}
			Livre listResa[] = Modele.recupererLivreReserves(LoginValue, bibli);
			request.setAttribute("ListResa", listResa);
			page = "Adherent.jsp";
			
		} else if(formulaire.equals("deReserver")){
			message = "ERROR: Cette réservation n'a pas pu être annulée";
			if (request.getParameter("auteur").length()>0 && request.getParameter("titre").length()>0) {
				bibli = Modele.annulerReservationLivre(request.getParameter("auteur"), request.getParameter("titre"),LoginValue, bibli);
 				message = "INFO: Annulation de la réservation du livre "+request.getParameter("titre")+" de "+request.getParameter("auteur")+" terminé";
			}
			Livre listResa[] = Modele.recupererLivreReserves(LoginValue, bibli);
			request.setAttribute("ListResa", listResa);
			page = "Adherent.jsp";
		} else if(formulaire.equals("deconnexion")){
			session.setAttribute("Logged", null);
			session.setAttribute("Statut", null);
			page = "Accueil.jsp";
			message = "Deconnexion effectuee";
		}else {
			page = "Accueil.jsp";
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/"+page);
	   rd.forward(request, response);	
		
	}
		

}
