package beans;

public class Livre {
	
	protected int idLivre;
	protected String titre;
	protected String auteur; 
	protected int nbLivresDispo;
	protected int nbLivresReserves;
	protected int nbLivresEmpruntes;

	
	public Livre(int idLivre, String titre, String auteur, int nblivresDispo, int nbLivresReserves,int nbLivresEmpruntes) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.idLivre = idLivre;
		this.nbLivresDispo = nblivresDispo;
		this.nbLivresReserves = nbLivresReserves;
		this.nbLivresEmpruntes = nbLivresEmpruntes;
		
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public int getIdLivre() {
		return idLivre;
	}


	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}


	public int getNbLivresDispo() {
		return nbLivresDispo;
	}


	public void setNbLivresDispo(int nblivresDispo) {
		this.nbLivresDispo = nblivresDispo;
	}


	public int getNbLivresReserves() {
		return nbLivresReserves;
	}


	public void setNbLivresReserves(int nbLivresReserves) {
		this.nbLivresReserves = nbLivresReserves;
	}


	public int getNbLivresEmpruntes() {
		return nbLivresEmpruntes;
	}


	public void setNbLivresEmpruntes(int nbLivresEmpruntes) {
		this.nbLivresEmpruntes = nbLivresEmpruntes;
	}

}