package project;
public class Livre {
	
	protected int idLivre;
	protected String titre;
	protected String auteur; 
	protected int nblivresDispo;
	protected int nbLivresReserves;
	protected int nbLivresEmpruntes;

	
	public Livre(int idLivre, String titre, String auteur, int nblivresDispo, int nbLivresReserves,int nbLivresEmpruntes) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.idLivre = idLivre;
		this.nblivresDispo = nblivresDispo;
		this.nbLivresReserves = nbLivresReserves;
		this.nbLivresEmpruntes = nbLivresEmpruntes;
		
	}
<<<<<<< HEAD
=======

	public void reserver(){
		if(this.nblivresDispo==0){
			System.out.println("Il n'y a pas d'exemplaire de libre.");
		}else{
			//Mettre � jour le statut de l'exemplaire dans la classe Occupation
			this.nbLivresReserves++;
			this.nblivresDispo--;
			System.out.println("L'exemplaire a bien �t� r�serv�.");
		}
	}
	
	public void annulerReservation(){
		this.nbLivresReserves--;
		this.nblivresDispo++;
		System.out.println("La r�servation a bien �t� annul�e.");
	}
>>>>>>> ef9e38dfdfee5f6e618bfba734073dfa99f19e8b
	
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


	public int getNblivresDispo() {
		return nblivresDispo;
	}


	public void setNblivresDispo(int nblivresDispo) {
		this.nblivresDispo = nblivresDispo;
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
