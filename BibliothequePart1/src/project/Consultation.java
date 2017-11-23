package project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Consultation
 */
@WebServlet("/Consultation")
public class Consultation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Bibliotheque bibli;
	protected int indexUser = -1;
	protected int indexLivre = -1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consultation() {
        super();
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
		Utilisateur user2 = new Utilisateur(2, "Marion", "test", true);
		Utilisateur user3 = new Utilisateur(3, "Logan", "Planche", false);

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

		bibli = new Bibliotheque(listLivres, listUsers, listOccupations);
		indexUser = -1;
		indexLivre = -1;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		int j = 0;
		ArrayList<Livre> listResult = new ArrayList<>();
		ArrayList<Livre> listResultFinal = new ArrayList<>();
		
		if (request.getParameter("EnterResearch") != null) {
			indexLivre = -1;
			listResult = new ArrayList<>();
			listResultFinal = new ArrayList<>();
			j = 0;
			if (request.getParameter("auteur") != null) {
				for (j = 0; j < bibli.listLivres.size(); j++) {
					if (bibli.listLivres.get(j).auteur.equals(request.getParameter("auteur"))) {
						indexLivre= j;
						listResult.add(bibli.listLivres.get(j));
					}
				}
			}
			String valueTitre = request.getParameter("titre");
			System.out.println(
					"Value of J: " +request.getParameter("titre").length() );
			if (request.getParameter("titre").length()!=0) {
				
				if (listResult.size() > 0) {
					j = 0;
					for (j = 0; j < listResult.size(); j++) {
						
						if (listResult.get(j).titre.equals(request.getParameter("titre"))) {
							indexLivre = j;
							listResultFinal.add(listResult.get(j));
						}
					}

				} else {
					j = 0;
					for (j = 0; j < bibli.listLivres.size(); j++) {
						if (bibli.listLivres.get(j).titre.equals(request.getParameter("titre"))) {
							indexLivre = j;
							listResultFinal.add(bibli.listLivres.get(j));
						}
					}
				}
			} else {
				listResultFinal = listResult;
			}
			
			if(request.getParameter("auteur") == null && request.getParameter("titre").length()==0){
				
				listResultFinal = bibli.listLivres;
			}
			
			
			for (j = 0; j < listResultFinal.size(); j++) {
				System.out.println(
						"Auteur: " + listResultFinal.get(j).auteur + " Titre: " + listResultFinal.get(j).titre);
			}
			if(listResultFinal.size()>0){
				Livre listR[] = new Livre[listResultFinal.size()];
				String page = "/Accueil.jsp";
				for (int k = 0; k<listResultFinal.size(); k++){
					listR[k] = listResultFinal.get(k);
				}
				
				if(request.getParameter("Statut")!=null){
					System.out.println("BLABLA" +request.getParameter("Statut"));
					if(request.getParameter("Statut").equals("Bibliothecaire")){
						page = "/Bibliothecaire.jsp";
					} else if (request.getParameter("Statut").equals("Adherent")){
						page = "/Adherent.jsp";
					}
				}
				
			    request.setAttribute("listData", listR);
			    RequestDispatcher rd = getServletContext()
			                               .getRequestDispatcher(page);
			    rd.forward(request, response);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
