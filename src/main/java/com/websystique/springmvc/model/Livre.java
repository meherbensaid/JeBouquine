package com.websystique.springmvc.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "LIVRE")
public class Livre {
	
	



	@Override
	public String toString() {
		return "Livre [id=" + id + ", ISBN=" + ISBN + ", Titre=" + Titre + ", Prix=" + Prix + ", Stock_Quantite="
				+ Stock_Quantite + ", Quantité_panié=" + quantite_panie + ", Photo_Couverture=" + Photo_Couverture + ", Langue=" + Langue + ", Langue_Origine="
				+ Langue_Origine + ", Edition_maison=" + Edition_maison + ", Disponibilite=" + Disponibilite
				+ ", Date_Publication=" + Date_Publication + "Auteurs:"+this.getAuteurs()+ "Categries:+"+this.getCategories()+"]";
	}

	private int id;
	
	
	private String ISBN;
	
	
	public String getISBN() {
		return ISBN;
	}

	private String Titre;

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	
	private int Prix;
	
	
	private int Stock_Quantite;

	private String Photo_Couverture;
	
	
	private String Langue;
	

	
	private String Langue_Origine;
	
	

	private String Description;
	
	
	private String Edition_maison;
	

	
	private boolean Disponibilite;
	
	
	private int quantite_panie;

	@Transient
	public String getAuteurs_bloc(){
		String result = "";
		if(auteurs!=null)
			for (Auteur auteur : auteurs) {
				result += auteur.getNom() + " ";
			}
		return result;
	}
	@Transient
	public String getCategories_bloc(){
		String result = "";
		if(auteurs!=null)
			for (Categorie cat : categories) {
				result += cat.getNom() + " ";
			}
		return result;
	}
	
	public int getQuantite_panie() {
		return quantite_panie;
	}

	public void setQuantite_panie(int quantite_panie) {
		this.quantite_panie = quantite_panie;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	private Date Date_Publication;

	
	private List <Categorie> categories;
	
	private List<Auteur> auteurs;
	
	private Set <Utilisateur> utilisateurs;
	
	private List <Commentaire> commentaires;

//	private List <Commande> commandes;
	
	private List <Panier> paniers;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Livre_Panier", joinColumns =@JoinColumn(name = "Livre_ID") , 
			inverseJoinColumns = @JoinColumn(name = "Panier_ID" ) )
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Panier> getPaniers() {
		return paniers;
	}

	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}
public Livre(int qte_p) {
		this.quantite_panie=qte_p;
		
	}
	public Livre() {
		
		
	}

	
//	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinTable(name = "Livre_Commande", joinColumns =@JoinColumn(name = "Livre_ID") , 
//			inverseJoinColumns = @JoinColumn(name = "Commande_ID" ) )
//	public List<Commande> getCommandes() {
//		return commandes;
//	}
//
	
	

//
//	public void setCommandes(List<Commande> commandes) {
//		commandes = commandes;
//	}


	public Livre(String iSBN, String titre, int prix, int stock_Quantite,
			String photo_Couverture, String langue, String langue_Origine,
			String edition_maison, boolean disponibilite,
			Date date_Publication) {
		super();
		ISBN = iSBN;
		Titre = titre;
		Prix = prix;
		Stock_Quantite = stock_Quantite;
		Photo_Couverture = photo_Couverture;
		Langue = langue;
		Langue_Origine = langue_Origine;
		Edition_maison = edition_maison;
		Disponibilite = disponibilite;
		
		Date_Publication = date_Publication;
	}
	
	
	@OneToMany(mappedBy="livre",fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}


	@ManyToMany(cascade=CascadeType.ALL,mappedBy="livres_favoris")
	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}


	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}


	public Livre( String titre, int prix, int stock_Quantite,
			String photo_Couverture, String langue, String langue_Origine,
			String edition_maison, boolean disponibilite, 
			Date date_Publication,Set <Categorie> categories,Set <Auteur> auteurs) {
		super();

		Titre = titre;
		Prix = prix;
		Stock_Quantite = stock_Quantite;
		Photo_Couverture = photo_Couverture;
		Langue = langue;
		Langue_Origine = langue_Origine;
		Edition_maison = edition_maison;
		Disponibilite = disponibilite;
		
		Date_Publication = date_Publication;
		categories=categories;
		auteurs=auteurs;
	}



	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "Livre_Auteur", joinColumns =@JoinColumn(name = "Livre_ID") , 
			inverseJoinColumns = @JoinColumn(name = "Auteur_ID" ) )
	public List<Auteur> getAuteurs() {
		return auteurs;
	}


	public void setAuteurs(List<Auteur> auteur) {
		this.auteurs = auteur;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "Livre_Categorie", joinColumns =@JoinColumn(name = "Livre_ID") , 
			inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID" ) )
	
	public List<Categorie> getCategories() {
		return categories;
	}


	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}


	


	public String getTitre() {
		return Titre;
	}


	public void setTitre(String titre) {
		Titre = titre;
	}


	public int getPrix() {
		return Prix;
	}


	public void setPrix(int prix) {
		Prix = prix;
	}


	public int getStock_Quantite() {
		return Stock_Quantite;
	}


	public void setStock_Quantite(int stock_Quantite) {
		Stock_Quantite = stock_Quantite;
	}


	public String getPhoto_Couverture() {
		return Photo_Couverture;
	}


	public void setPhoto_Couverture(String photo_Couverture) {
		Photo_Couverture = photo_Couverture;
	}


	public String getLangue() {
		return Langue;
	}


	public void setLangue(String langue) {
		Langue = langue;
	}


	public String getLangue_Origine() {
		return Langue_Origine;
	}


	public void setLangue_Origine(String langue_Origine) {
		Langue_Origine = langue_Origine;
	}


	public String getEdition_maison() {
		return Edition_maison;
	}


	public void setEdition_maison(String edition_maison) {
		Edition_maison = edition_maison;
	}


	public boolean isDisponibilite() {
		return Disponibilite;
	}


	public void setDisponibilite(boolean disponibilite) {
		Disponibilite = disponibilite;
	}


	



	public Date getDate_Publication() {
		return Date_Publication;
	}


	public void setDate_Publication(Date date_Publication) {
		Date_Publication = date_Publication;
	}
	
	
	
}