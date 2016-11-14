package com.websystique.springmvc.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Panier")
public class Panier {

	
	@Override
	public String toString() {
		return "Panier [Id=" + Id + ", prix_total=" + prix_total + ", date_sauvegarde=" + date_sauvegarde + ", livres="
				+ livres + ", utilisateur=" + utilisateur + "]";
	}

	private int Id;
	
	private int prix_total;
	
	private Date date_sauvegarde;

	private List <Livre> livres;
	
	private Utilisateur utilisateur;
	
	
	
	

	@ManyToOne(cascade=CascadeType.REFRESH)
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@ManyToMany(cascade=CascadeType.ALL,mappedBy="paniers")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	

	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Panier(int prix_total, Date date_sauvegarde, List<Livre> livres,
			Utilisateur utilisateur) {
		super();
		this.prix_total = prix_total;
		this.date_sauvegarde = date_sauvegarde;
		this.livres = livres;
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