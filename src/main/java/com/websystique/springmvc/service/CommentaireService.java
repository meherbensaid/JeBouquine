package com.websystique.springmvc.service;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.IRepositoryCommentaire;
import com.websystique.springmvc.dao.IRepositoryUtilisateur;
import com.websystique.springmvc.model.Commentaire;

@Service("CommentaireService")
public class CommentaireService implements ICommentaireService {

	@Autowired
	private IRepositoryCommentaire dao;
      
	
	public void create(Commentaire object_in) {
		dao.create(object_in);
	}

	public Commentaire findByID(int id) {
		return dao.findByID(id);

	}

	public List<Commentaire> findAll() {
		return dao.findAll();
	}

	public void update(Commentaire object_in) {
		dao.update(object_in);

	}

	public void delete(int id) {
		dao.delete(id);

	}

}
