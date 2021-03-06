package fr.qcm_eni_10A.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.qcm_eni_10A.bean.Stagiaire;
import fr.qcm_eni_10A.util.AccesBase;

public class ResponsableFormationDAO {

	//
	//TODO modifier stagiaire en Responsableformation
	//
	
	public static Stagiaire rechercher(int id) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Stagiaire stagiaire=null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement("select id, nom, prenom, email, motdepasse from stagiaire where id=?");
			rqt.setInt(1, id);
			rs=rqt.executeQuery();
			// SI on trouve au moins 1 r�sultat, on prend le 1er pour mettre � jour les informations du candidat utilis� pour la recherche.
			if (rs.next()){
				stagiaire = new Stagiaire();
				stagiaire.setId(rs.getInt("id"));
				stagiaire.setNom(rs.getString("nom"));
				stagiaire.setPrenom(rs.getString("prenom"));
				stagiaire.setEmail(rs.getString("email"));
				stagiaire.setMotDePasse(rs.getString("motdepasse"));
			}
			// ...sinon on renvoie null
			else {
				stagiaire = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return stagiaire;
	}
	
	/*
	 * Recherche par login et mot de passe
	 */
	public static Stagiaire rechercher(String mail, String password) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Stagiaire stagiaire=null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement("select id, nom, prenom, email, motdepasse from stagiaire where email=? and motdepasse=?");
			rqt.setString(1, mail);
			rqt.setString(2, password);
			rs=rqt.executeQuery();
			// SI on trouve au moins 1 r�sultat, on prend le 1er pour mettre � jour les informations du candidat utilis� pour la recherche.
			if (rs.next()){
				stagiaire = new Stagiaire();
				stagiaire.setId(rs.getInt("id"));
				stagiaire.setNom(rs.getString("nom"));
				stagiaire.setPrenom(rs.getString("prenom"));
				stagiaire.setEmail(rs.getString("email"));
				stagiaire.setMotDePasse(rs.getString("motdepasse"));
			}
			// ...sinon on renvoie null
			else {
				stagiaire = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return stagiaire;
	}

	/*
	 * Ajoute un candidat en base puis retourne le candidat (valoris� avec son Id g�n�r� par la base de donn�es)
	 */
	public static Stagiaire ajouter(Stagiaire stagiaire) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			
			// Pour s'assurer de bien r�cup�rer l'identifiant du nouveau candidat que nous ajoutons, 
			// l'ajout et la r�cup�ration de l'identifiant se font dans une m�me transaction.
			cnx.setAutoCommit(false);
			
			// Insertion du nouveau candidat
			String insert = "insert into stagiaires (nom, prenom, email, motdepasse) values (?,?,?,?)";
			rqt = cnx.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, stagiaire.getNom());
			rqt.setString(2, stagiaire.getPrenom());
			rqt.setString(3, stagiaire.getEmail());
			rqt.setString(4, stagiaire.getMotDePasse());
			rqt.executeUpdate();
			ResultSet key = rqt.getGeneratedKeys();
			key.next();
			stagiaire.setId(key.getInt(1));
			
			// Nous avons r�cup�r� le nouvel identifiant : la transaction est valid�e.
			cnx.commit();
			
			key.close();
			
		} catch (SQLException sqle){
			
			// Quelque chose s'est mal pass� (apr�s l'obtention de la connexion), 
			// la transaction est annul�e.			
			if (cnx != null) {
				cnx.rollback();
			}
			
			// Faire remonter l'exception
			throw sqle;
		} finally {
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return stagiaire;

	}

	public static void modifier(Stagiaire stagiaire) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("update stagiaires set nom = ?, prenom = ?, email = ?, motdepasse=? where id = ?");
			rqt.setString(1, stagiaire.getNom());
			rqt.setString(2, stagiaire.getPrenom());
			rqt.setString(3, stagiaire.getEmail());
			rqt.setString(4, stagiaire.getMotDePasse());
			rqt.setInt(5, stagiaire.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void supprimer(Stagiaire stagiaire) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("delete from stagiaires where id = ?");
			rqt.setInt(1, stagiaire.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * 
	 * @return La liste peut �tre vide mais jamais <code>null</code>
	 * @throws SQLException
	 */
	public static List<Stagiaire> rechercher() throws SQLException {
		
		List<Stagiaire> listestagiaires = new ArrayList<Stagiaire>();
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement("select id, nom, prenom, email, motdepasse from stagiaires");
			rs=rqt.executeQuery();
			
			while (rs.next()){
				Stagiaire stagiaire = new Stagiaire();
				stagiaire.setId(rs.getInt("id"));
				stagiaire.setNom(rs.getString("nom"));
				stagiaire.setPrenom(rs.getString("prenom"));
				stagiaire.setEmail(rs.getString("email"));
				stagiaire.setMotDePasse(rs.getString("motdepasse"));
				
				listestagiaires.add(stagiaire);
			}

			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return listestagiaires;
		
	}
}
