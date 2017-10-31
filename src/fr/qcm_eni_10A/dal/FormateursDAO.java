package fr.qcm_eni_10A.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.qcm_eni_10A.bean.Formateurs;
import fr.qcm_eni_10A.bean.Stagiaire;
import fr.qcm_eni_10A.util.AccesBase;

public class FormateursDAO {

	public static Formateurs rechercher(int id) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Formateurs formateur=null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement("select id, nom, prenom, email, motdepasse from formateur where id=?");
			rqt.setInt(1, id);
			rs=rqt.executeQuery();
			// SI on trouve au moins 1 résultat, on prend le 1er pour mettre à jour les informations du candidat utilisé pour la recherche.
			if (rs.next()){
				formateur = new Formateurs();
				formateur.setId(rs.getInt("id"));
				formateur.setNom(rs.getString("nom"));
				formateur.setPrenom(rs.getString("prenom"));
				formateur.setEmail(rs.getString("email"));
				formateur.setMotDePasse(rs.getString("motdepasse"));
			}
			// ...sinon on renvoie null
			else {
				formateur = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return formateur;
	}
	
	/*
	 * Recherche par login et mot de passe
	 */
	public static Formateurs rechercher(String mail, String password) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Formateurs formateur=null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement("select id, nom, prenom, email, motdepasse from formateur where email=? and motdepasse=?");
			rqt.setString(1, mail);
			rqt.setString(2, password);
			rs=rqt.executeQuery();
			// SI on trouve au moins 1 résultat, on prend le 1er pour mettre à jour les informations du candidat utilisé pour la recherche.
			if (rs.next()){
				formateur = new Formateurs();
				formateur.setId(rs.getInt("id"));
				formateur.setNom(rs.getString("nom"));
				formateur.setPrenom(rs.getString("prenom"));
				formateur.setEmail(rs.getString("email"));
				formateur.setMotDePasse(rs.getString("motdepasse"));
			}
			// ...sinon on renvoie null
			else {
				formateur = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return formateur;
	}

	/*
	 * Ajoute un candidat en base puis retourne le candidat (valorisé avec son Id généré par la base de données)
	 */
	public static Formateurs ajouter(Formateurs formateur) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			
			// Pour s'assurer de bien récupérer l'identifiant du nouveau candidat que nous ajoutons, 
			// l'ajout et la récupération de l'identifiant se font dans une même transaction.
			cnx.setAutoCommit(false);
			
			// Insertion du nouveau candidat
			String insert = "insert into formateur (nom, prenom, email, motdepasse) values (?,?,?,?)";
			rqt = cnx.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, formateur.getNom());
			rqt.setString(2, formateur.getPrenom());
			rqt.setString(3, formateur.getEmail());
			rqt.setString(4, formateur.getMotDePasse());
			rqt.executeUpdate();
			ResultSet key = rqt.getGeneratedKeys();
			key.next();
			formateur.setId(key.getInt(1));
			
			// Nous avons récupéré le nouvel identifiant : la transaction est validée.
			cnx.commit();
			
			key.close();
			
		} catch (SQLException sqle){
			
			// Quelque chose s'est mal passé (après l'obtention de la connexion), 
			// la transaction est annulée.			
			if (cnx != null) {
				cnx.rollback();
			}
			
			// Faire remonter l'exception
			throw sqle;
		} finally {
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return formateur;

	}

	public static void modifier(Formateurs formateur) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("update formateur set nom = ?, prenom = ?, email = ?, motdepasse=? where id = ?");
			rqt.setString(1, formateur.getNom());
			rqt.setString(2, formateur.getPrenom());
			rqt.setString(3, formateur.getEmail());
			rqt.setString(4, formateur.getMotDePasse());
			rqt.setInt(5, formateur.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void supprimer(Formateurs formateur) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("delete from formateur where id = ?");
			rqt.setInt(1, formateur.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * 
	 * @return La liste peut être vide mais jamais <code>null</code>
	 * @throws SQLException
	 */
	public static List<Formateurs> rechercher() throws SQLException {
		
		List<Formateurs> listeformateur = new ArrayList<Formateurs>();
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement("select id, nom, prenom, email, motdepasse from formateur");
			rs=rqt.executeQuery();
			
			while (rs.next()){
				Formateurs formateur = new Formateurs();
				formateur.setId(rs.getInt("id"));
				formateur.setNom(rs.getString("nom"));
				formateur.setPrenom(rs.getString("prenom"));
				formateur.setEmail(rs.getString("email"));
				formateur.setMotDePasse(rs.getString("motdepasse"));
				
				listeformateur.add(formateur);
			}

			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return listeformateur;
		
	}
}
