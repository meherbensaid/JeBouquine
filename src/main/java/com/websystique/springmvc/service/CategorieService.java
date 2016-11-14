package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.IRepositoryCategorie;
import com.websystique.springmvc.model.Categorie;
import com.websystique.springmvc.model.Livre;

@Service("CategorieService")
public class CategorieService implements ICategorieService {

	@Autowired
	private IRepositoryCategorie dao;
      
	
	public void create(Categorie object_in) {
		dao.create(object_in);
	}

	public Categorie findByID(int id) {
		return dao.findByID(id);

	}

	public List<Categorie> findAll() {
		return dao.findAll();
	}

	public void update(Categorie object_in) {
		dao.update(object_in);

	}

	public void delete(int id) {
		dao.delete(id);

	}
	
	


	
}
