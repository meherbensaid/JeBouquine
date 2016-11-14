package com.websystique.springmvc.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="COMMANDE")
public class Commande {

	
	private int Id;
	
	private int prix_total;
	
	private Date date_sauvegarde;

//	private List <Livre> livres;
	
	private Utilisateur utilisateur;



	@OneToOne(cascade=CascadeType.ALL)
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


//	@ManyToMany(cascade=CascadeType.ALL,mappedBy="commandes")
//	public List<Livre> getLivres() {
//		return livres;
//	}
//
//	public void setLivres(List<Livre> list) {
//		this.livres = list;
//	}

	

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(int prix_total, Date date_sauvegarde, List<Livre> livres,
			Utilisateur utilisateur) {
		super();
		this.prix_total = prix_total;
		this.date_sauvegarde = date_sauvegarde;
//		this.livres = livres;
		this.utilisateur = utilisateur;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getPrix_total() {
		return prix_total;
	}

	public void setPrix_total(int prix_total) {
		this.prix_total = prix_total;
	}

	public Date getDate_sauvegarde() {
		return date_sauvegarde;
	}

	public void setDate_sauvegarde(Date date_sauvegarde) {
		this.date_sauvegarde = date_sauvegarde;
	}
	
	
	
}