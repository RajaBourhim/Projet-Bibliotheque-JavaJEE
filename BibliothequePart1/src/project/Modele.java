package project;

import java.awt.List;
import java.util.ArrayList;

public class Modele {

	public static Bibliotheque creerBibliotheque() {
		Bibliotheque bibli = null;

		Livre livre1 = new Livre(1, "L'art de la guerre", "Sun Tzu", 1, 0, 3);
		Livre livre2 = new Livre(2, "Autre monde", "Maxime CHATTAM", 5, 0, 3);
		Livre livre3 = new Livre(3, "Le livre de la jungle", "Mowgli", 16, 0, 0);
		Livre livre4 = new Livre(4, "Le livre de la jungle 2", "Mowgli", 10, 2, 0);
		Livre livre5 = new Livre(5, "Le livre de la jungle 3", "Mowgli", 0, 1, 2);
		Livre livre6 = new Livre(6, "Logan", "Logan Planche", 0, 1, 2);

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

		bibli = new Bibliotheque(listLivres, listUsers, listOccupations);

		return bibli;
	}

	// Permet de verifier si les identifiant et password sont bons
	public static boolean verifieConnexion(String loginConnect, String passConnect, Bibliotheque bibli) {

		boolean connect = false;
		int indexUser = -1;
		int j;
		boolean Login = false;
		boolean Pass = false;

		for (j = 0; j < bibli.listUsers.size(); j++) {
			if (bibli.listUsers.get(j).identifiant.equals(loginConnect)) {
				indexUser = j;
			}
		}
		if (indexUser != -1) {
			Login = true;
		}
		if (Login) {
			String passConnectBDD = bibli.listUsers.get(indexUser).password;
			if (passConnect.equals(passConnectBDD)) {
				Pass = true;
			}
		}

		if (Login && Pass) {
			connect = true;
		}

		return connect;
	}

	public static Livre[] consulteLivres(String auteur, String titre, Bibliotheque bibli) {
		ArrayList<Livre> listResult = new ArrayList<>();
		ArrayList<Livre> listResultFinal = new ArrayList<>();
		Livre listR[] = null;
		int indexLivre = -1;
		int j =0;
		
		// On recherche par auteur si un nom d'auteur a été saisi
		if (auteur != null) {
			for (j = 0; j < bibli.listLivres.size(); j++) {
				if (bibli.listLivres.get(j).auteur.equals(auteur)) {
					indexLivre= j;
					listResult.add(bibli.listLivres.get(j));
				}
			}
		}
		// On recherche par titre si un titre a été saisi
		if (titre.length()!=0) {
			//Si la recherche par auteur a obtenu des resultats - on va se baser sur ces derniers
			if (listResult.size()>0) {
				j = 0;
				for (j = 0; j < listResult.size(); j++) {
					if (listResult.get(j).titre.equals(titre)) {
						indexLivre = j;
						listResultFinal.add(listResult.get(j));
					}
				}
				// Sinon on va recherche a partir de la liste de livres de la bibli
			} else {
				j = 0;
				for (j = 0; j < bibli.listLivres.size(); j++) {
					if (bibli.listLivres.get(j).titre.equals(titre)) {
						indexLivre = j;
						listResultFinal.add(bibli.listLivres.get(j));
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

	public static Bibliotheque reserveLivre(String auteur, String titre, String login, Bibliotheque bibli) {

		int idUser = recupererIdUser(login, bibli);
		int idLivre = recupererIdLivre(titre, auteur, bibli);
		Occupation monOccup = new Occupation(idUser, idLivre, Statut.RESERVE);

		Livre monLivre = bibli.listLivres.get(recupererIndexLivre(titre, auteur, bibli));

		monLivre.reserver();
		bibli.listOccupations.add(monOccup);

		return bibli;
	}

	public static Bibliotheque annulerReservationLivre(String auteur, String titre, String login, Bibliotheque bibli) {

		int idUser = recupererIdUser(login, bibli);
		int idLivre = recupererIdLivre(titre, auteur, bibli);

		Livre monLivre = bibli.listLivres.get(recupererIndexLivre(titre, auteur, bibli));

		monLivre.annulerReservation();
		bibli.listOccupations.remove(trouverOccupation(idUser, idLivre, bibli));

		return bibli;
	}

	public static int recupererIdUser(String login, Bibliotheque bibli) {
		int idUser = -1;
		int indexUser = -1;

		for (int i = 0; i < bibli.listUsers.size(); i++) {
			if (bibli.listUsers.get(i).identifiant.equals(login)) {
				indexUser = i;
			}
		}

		if (indexUser != -1) {
			idUser = bibli.listUsers.get(indexUser).idUtilisateur;
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
			idLivre = bibli.listLivres.get(indexLivre).idLivre;
		} else {
			System.out.println("Titre non trouvé.");
		}

		return idLivre;
	}

	public static int recupererIndexLivre(String titre, String auteur, Bibliotheque bibli) {
		int indexLivre = -1;
		for (int i = 0; i < bibli.listLivres.size(); i++) {
			if (bibli.listLivres.get(i).titre.equals(titre)) {
				indexLivre = i;
			}
		}
		return indexLivre;
	}
	
	public static int recupererIndexUser(String login, Bibliotheque bibli) {
		int indexUser = -1;
		for (int i = 0; i < bibli.listUsers.size(); i++) {
			if (bibli.listUsers.get(i).identifiant.equals(login)) {
				indexUser = i;
			}
		}
		return indexUser;
	}

	public static Occupation trouverOccupation(int idAdherent, int idLivre, Bibliotheque bibli) {
		Occupation occupationARetourner = null;
		ArrayList<Occupation> listOccup = new ArrayList();

		for (int i = 0; i < bibli.listOccupations.size(); i++) {
			if (bibli.listOccupations.get(i).idLivre == idLivre) {
				listOccup.add(bibli.listOccupations.get(i));
			}
		}

		for (int i = 0; i < listOccup.size(); i++) {
			if (listOccup.get(i).idAdherent == idAdherent) {
				occupationARetourner = listOccup.get(i);
			}
		}

		return occupationARetourner;
	}
}