package beans;

public interface Utilisateur {

	void newUtilisateurBean(int idUtilisateur, String identifiant, String password, boolean type);
	int getIdUtilisateur();
	void setIdUtilisateur(int idUtilisateur);
	String getIdentifiant();
	void setIdentifiant(String identifiant);
	String getPassword();
	void setPassword(String password);
	boolean isType(); 
	void setType(boolean type);
}
