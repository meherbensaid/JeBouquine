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
@Table(name = "AUTEUR")

public class Auteur  implements java.io.Serializable{


		
		@Override
	public String toString() {
		return "Auteur [AuteurID=" + AuteurID + ", Nom=" + Nom + ", Prenom=" + Prenom + "]";
	}

		private int AuteurID;

		private String Nom;
		
		private String Prenom;

		private List <Livre> livres;

		
		

		public Auteur() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Auteur(String nom, String prenom) {
			super();
			Nom = nom;
			Prenom = prenom;
			
		}
		public Auteur(String nom) {
			super();
			Nom = nom;
			
			
		}


		@ManyToMany(cascade=CascadeType.ALL, mappedBy = "auteurs")
		public List<Livre> getLivres() {
			return livres;
		}


		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)

		public int getAuteurID() {
			return AuteurID;
		}

		public void setAuteurID(int auteurID) {
			AuteurID = auteurID;
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

		public void setLivres(List<Livre> livres2) {
			this.livres = livres2;
		}

		

}
