package beans;
import Modele.Statut;
public class Occupation {
	
	protected int idAdherent;
	protected int idLivre;
	protected Statut statutLivre;
	
	
	public Occupation(int idAdherent, int idLivre, Statut statutLivre) {
		super();
		this.idAdherent = idAdherent;
		this.idLivre = idLivre;
		this.statutLivre = statutLivre;
	}
	
	
	public int getIdAdherent() {
		return idAdherent;
	}
	public void setIdAdherent(int idAdherent) {
		this.idAdherent = idAdherent;
	}
	public int getIdLivre() {
		return idLivre;
	}
	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}
	public Statut getStatutLivre() {
		return statutLivre;
	}
	public void setStatutLivre(Statut statutLivre) {
		this.statutLivre = statutLivre;
	}
	
	

}
