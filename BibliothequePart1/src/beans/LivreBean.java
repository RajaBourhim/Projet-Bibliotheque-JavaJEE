package beans;

import javax.ejb.Stateful;

@Stateful
public class LivreBean implements Livre {
	
	protected int idLivre;
	protected String titre;
	protected String auteur; 
	protected int nbLivresDispo;
	protected int nbLivresReserves;
	protected int nbLivresEmpruntes;

	
	/* public Livre(int idLivre, String titre, String auteur, int nblivresDispo, int nbLivresReserves,int nbLivresEmpruntes) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.idLivre = idLivre;
		this.nbLivresDispo = nblivresDispo;
		this.nbLivresReserves = nbLivresReserves;
		this.nbLivresEmpruntes = nbLivresEmpruntes;
		
	}*/
	
	@Override
	public void newLivre(int idLivre, String titre, String auteur, int nblivresDispo, int nbLivresReserves,int nbLivresEmpruntes) {
		this.titre = titre;
		this.auteur = auteur;
		this.idLivre = idLivre;
		this.nbLivresDispo = nblivresDispo;
		this.nbLivresReserves = nbLivresReserves;
		this.nbLivresEmpruntes = nbLivresEmpruntes;
		
	}


	@Override
	public String getTitre() {
		return titre;
	}
	
	@Override
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	@Override
	public String getAuteur() {
		return auteur;
	}
	
	@Override
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
    
	@Override
	public int getIdLivre() {
		return idLivre;
	}

	@Override
	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}

	@Override
	public int getNbLivresDispo() {
		return nbLivresDispo;
	}

	@Override
	public void setNbLivresDispo(int nblivresDispo) {
		this.nbLivresDispo = nblivresDispo;
	}


	@Override
	public int getNbLivresReserves() {
		return nbLivresReserves;
	}

	@Override
	public void setNbLivresReserves(int nbLivresReserves) {
		this.nbLivresReserves = nbLivresReserves;
	}

	@Override
	public int getNbLivresEmpruntes() {
		return nbLivresEmpruntes;
	}

	@Override
	public void setNbLivresEmpruntes(int nbLivresEmpruntes) {
		this.nbLivresEmpruntes = nbLivresEmpruntes;
	}

}
