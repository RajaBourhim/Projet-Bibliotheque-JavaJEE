package beans;

import javax.ejb.Stateful;

@Stateful
public class UtilisateurBean implements Utilisateur {

	private int idUtilisateur;
	private String identifiant; 
	private String password; 
	private boolean type;

	
	/**public UtilisateurBean(int idUtilisateur, String identifiant, String password, boolean type) {
		super();
		this.identifiant = identifiant;
		this.password = password;
		this.type = type;
		this.idUtilisateur = idUtilisateur;
	}**/

	
	@Override
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	@Override
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Override
	public String getIdentifiant() {
		return identifiant;
	}
	
	@Override
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean isType() {
		return type;
	}
	
	@Override
	public void setType(boolean type) {
		this.type = type;
	}

	@Override
	public void newUtilisateurBean(int idUtilisateur, String identifiant, String password, boolean type) {
		// TODO Auto-generated method stub
		this.password = password;
		this.type = type;
		this.idUtilisateur = idUtilisateur;
		this.identifiant = identifiant;
		
	}
	
	
	

}
