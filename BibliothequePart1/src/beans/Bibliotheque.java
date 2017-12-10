package beans;
import java.util.ArrayList;

public class Bibliotheque {
	
	protected ArrayList<Livre> listLivres;
	protected ArrayList<Utilisateur> listUsers;
	protected ArrayList<Occupation> listOccupations;
	
	public Bibliotheque(ArrayList<Livre> listLivres, ArrayList<Utilisateur> listUsers, ArrayList<Occupation> listOccupations) {
		super();
		this.listLivres = listLivres;
		this.listUsers = listUsers;
		this.listOccupations = listOccupations;
	}
	
	public ArrayList<Livre> getListLivres() {
		return listLivres;
	}
	public void setListLivres(ArrayList<Livre> listLivres) {
		this.listLivres = listLivres;
	}
	public ArrayList<Utilisateur> getListUsers() {
		return listUsers;
	}
	public void setListUsers(ArrayList<Utilisateur> listUsers) {
		this.listUsers = listUsers;
	}

	public ArrayList<Occupation> getListOccupations() {
		return listOccupations;
	}

	public void setListOccupations(ArrayList<Occupation> listOccupations) {
		this.listOccupations = listOccupations;
	}
	
	
	
	
	
	
	
}
