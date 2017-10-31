package fr.qcm_eni_10A.bean;

public class Stagiaire extends Utilisateur{
	
	public Stagiaire(){
		super();
	}

	public Stagiaire(int id, String nom, String prenom, String motDePasse, String email) {
		super(id, nom, prenom, motDePasse, email);
	}	

	public Stagiaire(int id) {
		super(id);
	}
	
}
