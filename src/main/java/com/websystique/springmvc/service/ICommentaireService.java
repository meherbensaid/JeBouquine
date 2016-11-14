package com.websystique.springmvc.service;
import java.util.List;

import com.websystique.springmvc.model.Commentaire;
import com.websystique.springmvc.model.Utilisateur;

public interface ICommentaireService {

	public  void create(Commentaire object_in);
	public  Commentaire findByID(int id);
	public List<Commentaire> findAll();
	public  void update(Commentaire object_in);
	public  void delete(int id);
	
}
