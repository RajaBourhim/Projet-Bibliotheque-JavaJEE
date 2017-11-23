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
@WebServlet("/ProcessConnexion")
public class ProcessConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Bibliotheque bibli;
	protected String loginConnect = "";
	protected String passConnect = "";
	protected boolean Login = false;
	protected boolean Pass = false;
	protected int indexUser = -1;
	/**
	 * Default constructor.
	 */
	public ProcessConnexion() {
		// TODO Auto-generated constructor stub
		Livre livre1 = new Livre(1,"L'art de la guerre", "Sun Tzu", 1,0,3);
		Livre livre2 = new Livre(2,"Autre monde", "Maxime CHATTAM", 5,0,3);
		Livre livre3 = new Livre(3,"Le livre de la jungle", "Mowgli", 16,0,0);
		Livre livre4 = new Livre(4,"Le livre de la jungle 2", "Mowgli", 10,2,0);
		Livre livre5 = new Livre(5,"Le livre de la jungle 3", "Mowgli", 0,1,2);
		Livre livre6 = new Livre(6,"Logan", "Logan Planche",0,1,2);
		
		Occupation occup1 = new Occupation(1,1,Statut.EMPRUNTE);
		Occupation occup2 = new Occupation(2,1,Statut.EMPRUNTE);
		Occupation occup3 = new Occupation(3,1,Statut.EMPRUNTE);
		Occupation occup4 = new Occupation(3,2,Statut.EMPRUNTE);
		Occupation occup5 = new Occupation(2,2,Statut.EMPRUNTE);
		Occupation occup6 = new Occupation(1,2,Statut.EMPRUNTE);
		Occupation occup7 = new Occupation(1,4,Statut.RESERVE);
		Occupation occup8 = new Occupation(2,4,Statut.RESERVE);
		Occupation occup9 = new Occupation(2,5,Statut.RESERVE);
		Occupation occup10 = new Occupation(3,5,Statut.EMPRUNTE);
		Occupation occup11 = new Occupation(1,5,Statut.EMPRUNTE);
		Occupation occup12 = new Occupation(1,6,Statut.RESERVE);
		Occupation occup13 = new Occupation(2,6,Statut.EMPRUNTE);
		Occupation occup14 = new Occupation(3,6,Statut.EMPRUNTE);

		Utilisateur user1 = new Utilisateur(1, "Raja", "toto", false);
		Utilisateur user2 = new Utilisateur(2, "Marion", "test", false);
		Utilisateur user3 = new Utilisateur(3, "Logan", "Planche", false);
		Utilisateur user4 = new Utilisateur(4, "Admin", "adminPass", true);

		ArrayList<Livre> listLivres = new ArrayList<>();
		ArrayList<Utilisateur> listUsers = new ArrayList<>();
		ArrayList<Occupation> listOccupations = new ArrayList<>();

		listLivres.add(livre1);
		listLivres.add(livre2);
		listLivres.add(livre3);
		listLivres.add(livre4);
		listLivres.add(livre5);
		listLivres.add(livre6);
		
		listUsers.add(user1);
		listUsers.add(user2);
		listUsers.add(user3);
		
		listOccupations.add(occup1);
		listOccupations.add(occup2);
		listOccupations.add(occup3);
		listOccupations.add(occup4);
		listOccupations.add(occup5);
		listOccupations.add(occup6);
		listOccupations.add(occup7);
		listOccupations.add(occup8);
		listOccupations.add(occup9);
		listOccupations.add(occup10);
		listOccupations.add(occup11);
		listOccupations.add(occup12);
		listOccupations.add(occup13);
		listOccupations.add(occup14);
		
		bibli = new Bibliotheque(listLivres, listUsers,listOccupations);
		indexUser = -1;

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int j = 0;

		if (request.getParameter("login") != null && request.getParameter("password") != null) {
			indexUser = -1;
			loginConnect = request.getParameter("login");

			for (j = 0; j < bibli.listUsers.size(); j++) {
				if (bibli.listUsers.get(j).identifiant.equals(loginConnect)) {
					indexUser = j;
				}
			}
			if (indexUser != -1) {
				Login = true;
			}
			if (Login) {
				passConnect = bibli.listUsers.get(indexUser).password;
				if (request.getParameter("password").equals(passConnect)) {
					Pass = true;
				}
			}

			if (Login && Pass) {
				session.setAttribute("Logged", request.getParameter("login"));
				session.setAttribute("Login", "true");
				session.setMaxInactiveInterval(30);
				if (!bibli.listUsers.get(indexUser).type) {
					response.sendRedirect("Adherent.jsp");
				} else {
					response.sendRedirect("Bibliothecaire.jsp");
				}

			} else {
				System.out.println("Les identifiants ne sont pas corrects");
				response.sendRedirect("Accueil.jsp");
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
