package com.websystique.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.*;

import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur  {
	
	
	private int ID;
	
	
	private String Nom;

	private String Prenom;

	private String Login;

	private String Mot_De_Passe;

	private String Adresse;

	private Date Date_naissance;

	private String Email;
	
	private String Role;
	
	private String Sexe;

	private Set <Livre> livres_favoris;
	
	private Set <Commentaire> Commentaires;
	
	private Panier Panier;
	
	@Transient
	public Panier getPanier() {
		return Panier;
	}
	
	public void setPanier(Panier panier) {
		Panier = panier;
	}

	private List<Panier> Paniers;
	//,fetch = FetchType.LAZY, mappedBy = "utilisateur"
	
//	
	
//	@OneToOne(cascade=CascadeType.ALL,mappedBy = "utilisateur")
////	@OneTo(cascade=CascadeType.ALL,mappedBy = "utilisateur")
//
//	public Panier getPanier() {
//		return Panier;
//	}
//
//	public void setPanier(Panier panier) {
//		Panier = panier;
//	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "utilisateur")
	public List<Panier> getPaniers() {
		return Paniers;
	}

	public void setPaniers(List<Panier> paniers) {
		Paniers = paniers;
	}

	@Override
	public String toString() {
		return "Utilisateur [ID=" + ID + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Login=" + Login + ", Mot_De_Passe="
				+ Mot_De_Passe + ", Adresse=" + Adresse + ", Date_naissance=" + Date_naissance + ", Email=" + Email
				+ ", Role=" + Role + ", Sexe=" + Sexe + "]";
	}

	

	public Utilisateur(String nom, String prenom, String login,
			String mot_De_Passe, String adresse, Date date_naissance,
			String email, String role, String sexe, Set<Livre> livres_favoris, Set<Commentaire> commentaires ) {
		super();
		Nom = nom;
		Prenom = prenom;
		Login = login;
		Mot_De_Passe = mot_De_Passe;
		Adresse = adresse;
		Date_naissance = date_naissance;
		Email = email;
		Role = role;
		Sexe = sexe;
		this.livres_favoris = livres_favoris;
		this.Commentaires=commentaires;
	}

	
	
	public Utilisateur(String nom, String prenom, String login,
			String mot_De_Passe, String adresse, Date date_naissance,
			String email, String role, String sexe ) {
		super();
		Nom = nom;
		Prenom = prenom;
		Login = login;
		Mot_De_Passe = mot_De_Passe;
		Adresse = adresse;
		Date_naissance = date_naissance;
		Email = email;
		Role = role;
		Sexe = sexe;

	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy = "utilisateur") 
	public Set<Commentaire> getCommentaires() {
		return Commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		Commentaires = commentaires;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Utilisateur_LivresFavories", joinColumns =@JoinColumn(name = "Utilisateur_ID") , 
			inverseJoinColumns = @JoinColumn(name = "Livre_ID" ))
	public Set<Livre> getLivres_favoris() {
		return livres_favoris;
	}

	
	public void setLivres_favoris(Set<Livre> livres_favoris) {
		this.livres_favoris = livres_favoris;
	}


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getID() {
		return ID;
	}

	
	public void setID(int iD) {
		ID = iD;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getMot_De_Passe() {
		return Mot_De_Passe;
	}

	public void setMot_De_Passe(String mot_De_Passe) {
		Mot_De_Passe = mot_De_Passe;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public Date getDate_naissance() {
		return Date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		Date_naissance = date_naissance;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}
	
}