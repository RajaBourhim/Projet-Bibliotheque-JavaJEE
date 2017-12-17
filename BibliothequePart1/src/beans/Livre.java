package beans;

public interface Livre {
	
	public void newLivre(int idLivre, String titre, String auteur, int nblivresDispo, int nbLivresReserves,int nbLivresEmpruntes);
	public String getTitre();
	public void setTitre(String titre);	
	public String getAuteur();
	public void setAuteur(String auteur);	
	public int getIdLivre();
	public void setIdLivre(int idLivre);
	public int getNbLivresDispo();	
	public void setNbLivresDispo(int nblivresDispo);
	public int getNbLivresReserves();	
	public void setNbLivresReserves(int nbLivresReserves);	
	public int getNbLivresEmpruntes();
	public void setNbLivresEmpruntes(int nbLivresEmpruntes);

}
