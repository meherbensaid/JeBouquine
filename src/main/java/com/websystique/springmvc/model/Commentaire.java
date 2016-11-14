package com.websystique.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "COMMENTAIRE")
public class Commentaire  {

	private int Id;
	
	private String Text;
	
	private Date Date_Post;
	
	private Utilisateur utilisateur;
	
	private Livre livre;
	
//	private Set <Commentaire> Commentaires;
//	
//	private Commentaire Commentaire_pere;
//	
//	
//	@ManyToOne(cascade={CascadeType.ALL})
//    @JoinColumn(name="Comentaire_pere_ID")
//	public Commentaire getCommentaire_pere() {
//		return Commentaire_pere;
//	}
// 
//    @OneToMany(mappedBy="Commentaire_pere")
//    public Set<Commentaire> getCommentaires() {
//		return Commentaires;
//	}
//
//	public void setCommentaire_pere(Commentaire commentaire_pere) {
//		Commentaire_pere = commentaire_pere;
//	}
//
//
//	public void setCommentaires(Set<Commentaire> commentaires) {
//		Commentaires = commentaires;
//	}

	@ManyToOne
	public Livre getLivre() {
		return livre;
	}

	@Override
	public String toString() {
		return "Commentaire [Id=" + Id + ", Text=" + Text + ", Date_Post=" + Date_Post + ", utilisateur=" + utilisateur
				+ ", livre=" + livre + "]";
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Commentaire(String text, Date date_Post, Utilisateur utilisateur) {
		super();
		Text = text;
		Date_Post = date_Post;
		this.utilisateur = utilisateur;
	}

	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "Utilisateur_ID") 
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
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

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public Date getDate_Post() {
		return Date_Post;
	}

	public void setDate_Post(Date date_Post) {
		Date_Post = date_Post;
	}
	
	
}
