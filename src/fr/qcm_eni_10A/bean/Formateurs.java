package fr.qcm_eni_10A.bean;

public class Formateurs extends Utilisateur{
	
	public Formateurs(){
		super();
	}
	
	public Formateurs(int id, String nom, String prenom, String motDePasse, String email) {
		super(id, nom, prenom, motDePasse, email);
	}
	
	public Formateurs(int id) {
		super(id);
	}

}
