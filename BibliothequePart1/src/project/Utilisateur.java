package project;

public class Utilisateur {
	
	protected int idUtilisateur;
	protected String identifiant; 
	protected String password; 
	protected boolean type;

	
	public Utilisateur(int idUtilisateur, String identifiant, String password, boolean type) {
		super();
		this.identifiant = identifiant;
		this.password = password;
		this.type = type;
		this.idUtilisateur = idUtilisateur;
	}
	
	
	
	
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	
	

}
