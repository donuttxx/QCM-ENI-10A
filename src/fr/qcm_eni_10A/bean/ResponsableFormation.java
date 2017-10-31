package fr.qcm_eni_10A.bean;

public class ResponsableFormation extends Utilisateur{

	public ResponsableFormation(){
		super();
	}
	
	public ResponsableFormation(int id, String nom, String prenom, String motDePasse, String email) {
		super(id, nom, prenom, motDePasse, email);
	}
	
	public ResponsableFormation(int id) {
		super(id);
	}
}
