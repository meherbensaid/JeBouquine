package com.websystique.springmvc.model;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CATEGORIE")
public class Categorie implements java.io.Serializable {

	
	private int CategorieID;
	
	
	private String Nom;
	
	
	
	
	@Override
	public String toString() {
		return "Categorie [CategorieID=" + CategorieID + ", Nom=" + Nom +  "]";
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(int categorieID, String nom, List<Livre> livres) {
		super();
		CategorieID = categorieID;
		Nom = nom;
		this.livres = livres;
	}

	private List <Livre> livres;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public int getCategorieID() {
		return CategorieID;
	}

	public void setCategorieID(int categorieID) {
		CategorieID = categorieID;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	@ManyToMany(cascade=CascadeType.ALL, mappedBy = "categories")
	public List<Livre> getLivres() {
		return livres;
	}

	public Categorie( String nom) {
		super();
		
		Nom = nom;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
}
