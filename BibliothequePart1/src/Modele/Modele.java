package Modele;
import beans.*;

import java.awt.List;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Modele {
	
	//java:global/BibliothequePart1/UtilisateurBean!beans.Utilisateur
	

	public static Livre creerLivre(int idLivre, String titre, String auteur, int nblivresDispo, int nbLivresReserves, int nbLivresEmpruntes) {
		Livre livre = null;
		
		InitialContext ctx = null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			livre = (Livre)ctx.lookup("java:global/BibliothequePart1/LivreBean!beans.Livre");
			livre.newLivre(idLivre, titre, auteur, nblivresDispo, nbLivresReserves, nbLivresEmpruntes);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livre;
	}
	
	public static Bibliotheque creerBibliotheque() {
		Bibliotheque bibli = null;
		
		InitialContext ctx = null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Utilisateur user1=null;
		Utilisateur user2=null;
		Utilisateur user3=null;
		Utilisateur user4=null;
		
		Livre livre1 = null;
		Livre livre2 = null;
		Livre livre3 = null;
		Livre livre4 = null;
		Livre livre5 = null;
		Livre livre6 = null;
		
		
		try {
			
			user1 = (Utilisateur)ctx.lookup("java:global/BibliothequePart1/UtilisateurBean!beans.Utilisateur");			 
			user2 = (Utilisateur)ctx.lookup("java:global/BibliothequePart1/UtilisateurBean!beans.Utilisateur");
			user3 = (Utilisateur)ctx.lookup("java:global/BibliothequePart1/UtilisateurBean!beans.Utilisateur");
			user4 = (Utilisateur)ctx.lookup("java:global/BibliothequePart1/UtilisateurBean!beans.Utilisateur");
			
			user1.newUtilisateurBean(1, "Raja", "toto", false);
			user2.newUtilisateurBean(2, "Marion", "test", false);
			user3.newUtilisateurBean(3, "Logan", "Planche", false);
			user4.newUtilisateurBean(4, "adm", "adm", true);
			
			livre1 = (Livre)ctx.lookup("java:global/BibliothequePart1/LivreBean!beans.Livre");
			livre2 = (Livre)ctx.lookup("java:global/BibliothequePart1/LivreBean!beans.Livre");
			livre3 = (Livre)ctx.lookup("java:global/BibliothequePart1/LivreBean!beans.Livre");
			livre4 = (Livre)ctx.lookup("java:global/BibliothequePart1/LivreBean!beans.Livre");
			livre5 = (Livre)ctx.lookup("java:global/BibliothequePart1/LivreBean!beans.Livre");
			livre6 = (Livre)ctx.lookup("java:global/BibliothequePart1/LivreBean!beans.Livre");
			
			livre1.newLivre(1, "L'art de la guerre", "Sun Tzu", 1, 0, 3);
			livre2.newLivre(2, "Autre monde", "Maxime CHATTAM", 5, 0, 3);
			livre3.newLivre(3, "Le livre de la jungle", "Mowgli", 16, 0, 0);
			livre4.newLivre(4, "Le livre de la jungle 2", "Mowgli", 10, 2, 0);
			livre5.newLivre(5, "Le livre de la jungle 3", "Mowgli", 0, 1, 2);
			livre6.newLivre(6, "Logan", "Logan Planche", 0, 1, 2);
					
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Occupation occup1 = new Occupation(1, 1, Statut.EMPRUNTE);
		Occupation occup2 = new Occupation(2, 1, Statut.EMPRUNTE);
		Occupation occup3 = new Occupation(3, 1, Statut.EMPRUNTE);
		Occupation occup4 = new Occupation(3, 2, Statut.EMPRUNTE);
		Occupation occup5 = new Occupation(2, 2, Statut.EMPRUNTE);
		Occupation occup6 = new Occupation(1, 2, Statut.EMPRUNTE);
		Occupation occup7 = new Occupation(1, 4, Statut.RESERVE);
		Occupation occup8 = new Occupation(2, 4, Statut.RESERVE);
		Occupation occup9 = new Occupation(2, 5, Statut.RESERVE);
		Occupation occup10 = new Occupation(3, 5, Statut.EMPRUNTE);
		Occupation occup11 = new Occupation(1, 5, Statut.EMPRUNTE);
		Occupation occup12 = new Occupation(1, 6, Statut.RESERVE);
		Occupation occup13 = new Occupation(2, 6, Statut.EMPRUNTE);
		Occupation occup14 = new Occupation(3, 6, Statut.EMPRUNTE);
		
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
		listUsers.add(user4);


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

		return bibli;
	}

	// Permet de verifier si les identifiant et password entrés sont correctes
	public static boolean verifieConnexion(String loginConnect, String passConnect, Bibliotheque bibli) {

	
		boolean connect = false;
		int indexUser = -1;
		int j;
		boolean Login = false;
		boolean Pass = false;

		System.out.println("size" +bibli.getListUsers().size());
		for (j = 0; j < bibli.getListUsers().size(); j++) {
			System.out.println("un user" +bibli.getListUsers().get(j).getIdentifiant());
			if (bibli.getListUsers().get(j).getIdentifiant().equals(loginConnect)) {
				indexUser = j;
			}
		}
		if (indexUser != -1) {
			Login = true;
		}
		if (Login) {
			String passConnectBDD = bibli.getListUsers().get(indexUser).getPassword();
			if (passConnect.equals(passConnectBDD)) {
				Pass = true;
			}
		}

		if (Login && Pass) {
			connect = true;
		}

		System.out.println("value" +connect);
		return connect;
	}

	//Retourne la liste de livre resultant de la recherche
	public static Livre[] consulteLivres(String auteur, String titre, Bibliotheque bibli) {
		ArrayList<Livre> listResult = new ArrayList<>();
		ArrayList<Livre> listResultFinal = new ArrayList<>();
		Livre listR[] = null;
		int indexLivre = -1;
		int j =0;
		
		// On recherche par auteur si un nom d'auteur a été saisi
		if (auteur != null) {
			for (j = 0; j < bibli.getListLivres().size(); j++) {
				if (bibli.getListLivres().get(j).getAuteur().equals(auteur)) {
					indexLivre= j;
					listResult.add(bibli.getListLivres().get(j));
				}
			}
		}
		// On recherche par titre si un titre a été saisi
		if (titre.length()!=0) {
			//Si la recherche par auteur a obtenu des resultats - on va se baser sur ces derniers
			if (listResult.size()>0 & auteur!=null) {
				j = 0;
				for (j = 0; j < listResult.size(); j++) {
					if (listResult.get(j).getTitre().equals(titre)) {
						indexLivre = j;
						listResultFinal.add(listResult.get(j));
					}
				}
				// Sinon on va recherche a partir de la liste de livres de la bibli
			} else {
				j = 0;
				for (j = 0; j < bibli.getListLivres().size(); j++) {
					if (bibli.getListLivres().get(j).getTitre().equals(titre)) {
						indexLivre = j;
						listResultFinal.add(bibli.getListLivres().get(j));
					}
				}
			}
		} else {
			listResultFinal = listResult;
		}
		// On ajoute les résultats dans notre tableau si il y en a
		if(listResultFinal.size()>0){
			listR = new Livre[listResultFinal.size()];
			for (int k = 0; k<listResultFinal.size(); k++){
				listR[k] = listResultFinal.get(k);
				
			}
		} 
		return listR;
	}

	// Methode qui permet de récupérer la liste des livres reserves 
	public static Livre[] recupererLivreReserves(String login, Bibliotheque bibli){
		ArrayList<Occupation> listResultOccup = new ArrayList<>();
		ArrayList<Livre> listResultFinal = new ArrayList<>();
		Livre listR[] = null;
		int indexResa = -1;
		//On récupère l'idAdherent du user;
		int idAdherent = recupererIdUser(login,bibli);
		
		if(idAdherent!=-1 && login !=null){
			for (int j = 0; j < bibli.getListOccupations().size(); j++) {
				if (bibli.getListOccupations().get(j).getIdAdherent()==idAdherent && bibli.getListOccupations().get(j).getStatutLivre().equals(Statut.RESERVE)) {
						indexResa= j;
						listResultOccup.add(bibli.getListOccupations().get(j));
				}
				
			}
			if(listResultOccup.size()>0){
				// On va récuperer la liste de livre 
				for (int j = 0; j <listResultOccup.size(); j++) {
					// On va récupérer un livre à partir de son id
					listResultFinal.add(recupererLivreParId(listResultOccup.get(j).getIdLivre(), bibli));
				}			
			}
			
		}
		
		// On ajoute les résultats dans notre tableau si il y en a
		if(listResultFinal.size()>0){
			listR = new Livre[listResultFinal.size()];
			for (int k = 0; k<listResultFinal.size(); k++){
				listR[k] = listResultFinal.get(k);		
			}
		} 
		return listR;
	}
	
	// Methode qui permet de récupérer la liste utilisateur ayant emprunte un livre 
	public static Utilisateur[] recupererUsersEmprunt(String auteur,String titre, Bibliotheque bibli){
		ArrayList<Occupation> listResultOccup = new ArrayList<>();
		ArrayList<Utilisateur> listResultFinal = new ArrayList<>();
		Utilisateur[] listR = null;
		//On récupère l'id du livre;
		int idLivre = recupererIdLivre(titre, auteur, bibli);
		if(idLivre!=-1){
			for (int j = 0; j < bibli.getListOccupations().size(); j++) {
				if (bibli.getListOccupations().get(j).getIdLivre()==idLivre && bibli.getListOccupations().get(j).getStatutLivre().equals(Statut.EMPRUNTE)) {
					if(recupererUserParId(bibli.getListOccupations().get(j).getIdAdherent(), bibli)!=null){
						listResultFinal.add(recupererUserParId(bibli.getListOccupations().get(j).getIdAdherent(), bibli));
					}
				}
				
			}
		}
		// On ajoute les résultats dans notre tableau si il y en a
		if(listResultFinal.size()>0){
			listR = new Utilisateur[listResultFinal.size()];
			for (int k = 0; k<listResultFinal.size(); k++){
				listR[k] = listResultFinal.get(k);		
			}
		} 
		return listR;
	}
	
	// Methode qui permet de reserver un livre 
	public static Bibliotheque reserveLivre(String auteur, String titre, String login, Bibliotheque bibli) {
		int idUser = recupererIdUser(login, bibli);
		int idLivre = recupererIdLivre(titre, auteur, bibli);
		int indexLivre = recupererIndexLivre(titre, auteur, bibli);
		int nbLivreReserves = bibli.getListLivres().get(indexLivre).getNbLivresReserves();
		int nbLivresDispo = bibli.getListLivres().get(indexLivre).getNbLivresDispo();
		Occupation monOccup = new Occupation(idUser, idLivre, Statut.RESERVE);
		bibli.getListLivres().get(indexLivre).setNbLivresReserves(nbLivreReserves++);
		bibli.getListLivres().get(indexLivre).setNbLivresDispo(nbLivresDispo--);
		bibli.getListOccupations().add(monOccup);
		return bibli;
	}

	// Methode qui permet l'annulation d'un livre
	public static Bibliotheque annulerReservationLivre(String auteur, String titre, String login, Bibliotheque bibli) {
		int idUser = recupererIdUser(login, bibli);
		int idLivre = recupererIdLivre(titre, auteur, bibli);
		int indexLivre = recupererIndexLivre(titre, auteur, bibli);
		int nbLivreReserves = bibli.getListLivres().get(indexLivre).getNbLivresReserves();
		int nbLivresDispo = bibli.getListLivres().get(indexLivre).getNbLivresDispo();
		bibli.getListLivres().get(indexLivre).setNbLivresReserves(nbLivreReserves-1); 
		bibli.getListLivres().get(indexLivre).setNbLivresDispo(nbLivresDispo + 1);
		bibli.getListOccupations().remove(trouverOccupation(idUser, idLivre, bibli,Statut.RESERVE));
		return bibli;
	}
	
	//Methode qui permet d'emprunter un livre 
	public static Bibliotheque emprunterLivre(String auteur, String titre, String login, Bibliotheque bibli){
		Bibliotheque maBibli =null;
		int idUser = recupererIdUser(login, bibli);
		int idLivre = recupererIdLivre(titre,auteur,bibli);
		int indexLivre = recupererIndexLivre(titre, auteur, bibli);
		int nbLivreReserves = bibli.getListLivres().get(indexLivre).getNbLivresReserves();
		int nbLivresDispo = bibli.getListLivres().get(indexLivre).getNbLivresDispo();
		int nbLivresEmpruntes = bibli.getListLivres().get(indexLivre).getNbLivresEmpruntes();
		Occupation monOccup = trouverOccupation(idUser,idLivre,bibli,Statut.RESERVE);
		if(idUser!=-1 && idLivre!=-1){
			maBibli =bibli;
			if(monOccup!=null){
				maBibli.getListOccupations().remove(monOccup);	
				maBibli.getListLivres().get(indexLivre).setNbLivresReserves(nbLivreReserves-1);
			} else {
				maBibli.getListLivres().get(indexLivre).setNbLivresDispo(nbLivresDispo-1);
			}			
			monOccup = new Occupation(idUser,idLivre,Statut.EMPRUNTE);		
			maBibli.getListOccupations().add(monOccup);
			maBibli.getListLivres().get(indexLivre).setNbLivresEmpruntes(nbLivresEmpruntes+1);
		}
		return maBibli ;
	}
	
	//Methode qui permet d'emprunter un livre 
	public static Bibliotheque restituerLivre(String auteur, String titre, String login, Bibliotheque bibli){		
		Bibliotheque maBibli = bibli;
		int idUser = recupererIdUser(login, bibli);
		int idLivre = recupererIdLivre(titre,auteur,bibli);
		int indexLivre = recupererIndexLivre(titre, auteur, bibli);
		int nbLivresDispo = bibli.getListLivres().get(indexLivre).getNbLivresDispo();
		int nbLivresEmpruntes = bibli.getListLivres().get(indexLivre).getNbLivresEmpruntes();
		Occupation monOccup = trouverOccupation(idUser,idLivre,bibli,Statut.EMPRUNTE);
		if(idUser!=-1 && idLivre!=-1 && monOccup!=null){
			maBibli =bibli;
			maBibli.getListOccupations().remove(monOccup);			
			maBibli.getListLivres().get(indexLivre).setNbLivresEmpruntes(nbLivresEmpruntes-1);
			maBibli.getListLivres().get(indexLivre).setNbLivresDispo(nbLivresDispo+1);
		}
		return maBibli ;
	}
	
	public static int recupererIdUser(String login, Bibliotheque bibli) {
		int idUser = -1;
		int indexUser = -1;

		for (int i = 0; i < bibli.getListUsers().size(); i++) {
			if (bibli.getListUsers().get(i).getIdentifiant().equals(login)) {
				indexUser = i;
			}
		}

		if (indexUser != -1) {
			idUser = bibli.getListUsers().get(indexUser).getIdUtilisateur();
		} else {
			System.out.println("Login non trouvé.");
		}

		return idUser;
	}

	public static int recupererIdLivre(String titre, String auteur, Bibliotheque bibli) {
		int idLivre = -1;
		int indexLivre = -1;

		indexLivre = recupererIndexLivre(titre, auteur, bibli);
		// BLINDER SI PLUSIEURS LIVRES ONT LE MEME TITRE
		if (indexLivre != -1) {
			idLivre = bibli.getListLivres().get(indexLivre).getIdLivre();
		} else {
			System.out.println("Titre non trouvé.");
		}

		return idLivre;
	}

	public static int recupererIndexLivre(String titre, String auteur, Bibliotheque bibli) {
		int indexLivre = -1;
		for (int i = 0; i < bibli.getListLivres().size(); i++) {
			if (bibli.getListLivres().get(i).getTitre().equals(titre)) {
				indexLivre = i;
			}
		}
		return indexLivre;
	}
	
	public static Livre recupererLivreParId(int idLivre, Bibliotheque bibli){
		Livre monLivre = null;
		
		for (int i = 0; i < bibli.getListLivres().size(); i++) {
			if (bibli.getListLivres().get(i).getIdLivre() == idLivre) {
				monLivre = bibli.getListLivres().get(i);
			}
		}
		return monLivre;
	}
	
	public static Utilisateur recupererUserParId(int idUser, Bibliotheque bibli){
		Utilisateur User = null;
		
		for (int i = 0; i < bibli.getListUsers().size(); i++) {
			if (bibli.getListUsers().get(i).getIdUtilisateur() == idUser) {
				User = bibli.getListUsers().get(i);
			}
		}
		return User;
	}
	
	public static int recupererIndexUser(String login, Bibliotheque bibli) {
		int indexUser = -1;
		for (int i = 0; i < bibli.getListUsers().size(); i++) {
			if (bibli.getListUsers().get(i).getIdentifiant().equals(login)) {
				indexUser = i;
			}
		}
		return indexUser;
	}

	public static Occupation trouverOccupation(int idAdherent, int idLivre, Bibliotheque bibli, Statut monStatut) {

		Occupation occupationARetourner = null;
		ArrayList<Occupation> listOccup = new ArrayList();

		for (int i = 0; i < bibli.getListOccupations().size(); i++) {
			if (bibli.getListOccupations().get(i).getIdLivre() == idLivre && bibli.getListOccupations().get(i).getStatutLivre().equals(monStatut)) {
				listOccup.add(bibli.getListOccupations().get(i));
			}
		}

		for (int i = 0; i < listOccup.size(); i++) {
			if (listOccup.get(i).getIdAdherent() == idAdherent) {
				occupationARetourner = listOccup.get(i);
			}
		}

		return occupationARetourner;
	}

	public static Bibliotheque ajouterLivre(String auteur, String titre, Bibliotheque bibli) {
		int indexLivre = -1;
		int j;
		//On verifie que le livre n'existe pas 
	for (j = 0; j < bibli.getListLivres().size(); j++) {
			if (bibli.getListLivres().get(j).getAuteur().equals(auteur) && bibli.getListLivres().get(j).getTitre().equals(titre)) {
				indexLivre = j;
			}
		}
		if (indexLivre != -1) {
			int nbLivresDispo = bibli.getListLivres().get(indexLivre).getNbLivresDispo();
			bibli.getListLivres().get(indexLivre).setNbLivresDispo(nbLivresDispo ++);
		} else {
			int idLivre = bibli.getListLivres().size()+1;
			Livre monLivre = creerLivre(idLivre,titre,auteur,1,0,0);
			bibli.getListLivres().add(monLivre);
			
		}
		return bibli;
	}

	//On supprime un livre dispo
	public static Bibliotheque supprimerLivre (String auteur, String titre, Bibliotheque bibli){
		if(auteur != null && titre !=null){
			int indexLivre = recupererIndexLivre(titre,auteur,bibli);
			int nbLivresDispo = bibli.getListLivres().get(indexLivre).getNbLivresDispo();
			
			bibli.getListLivres().get(indexLivre).setNbLivresDispo(nbLivresDispo - 1);
			if(bibli.getListLivres().get(indexLivre).getNbLivresDispo()==0 && 
					bibli.getListLivres().get(indexLivre).getNbLivresEmpruntes()==0 && 
					bibli.getListLivres().get(indexLivre).getNbLivresReserves()==0) {				
				bibli.getListLivres().remove(indexLivre);
			}
		}
		
		return bibli;	
	}
	
	//On supprime uniquement les livres dispo
	public static Bibliotheque supprimerTout (String auteur, String titre, Bibliotheque bibli){
		if(auteur != null && titre !=null){
			int indexLivre = recupererIndexLivre(titre,auteur,bibli);
			bibli.getListLivres().get(indexLivre).setNbLivresDispo(0);
			if(bibli.getListLivres().get(indexLivre).getNbLivresDispo()==0 && 
					bibli.getListLivres().get(indexLivre).getNbLivresEmpruntes()==0 && 
					bibli.getListLivres().get(indexLivre).getNbLivresReserves()==0) {				
				bibli.getListLivres().remove(indexLivre);
			}
		}
		return bibli;
	}
	
	
}