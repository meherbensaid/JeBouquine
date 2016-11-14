package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.IRepositoryAuteur;
import com.websystique.springmvc.model.Auteur;
import com.websystique.springmvc.model.Categorie;

@Service("AuteurService")
public class AuteurService implements IAuteurService {

	@Autowired
	private IRepositoryAuteur dao;
      
	
	public void create(Auteur object_in) {
		dao.create(object_in);
	}

	public Auteur findByID(int id) {
		return dao.findByID(id);

	}

	public List<Auteur> findAll() {
		return dao.findAll();
	}

	public void update(Auteur object_in) {
		dao.update(object_in);

	}

	public void delete(int id) {
		dao.delete(id);

	}
	
	


	
}
