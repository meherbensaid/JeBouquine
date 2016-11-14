package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.IRepositoryCommande;
import com.websystique.springmvc.model.Commande;

@Service("CommandeService")
public class CommandeService implements ICommandeService {

	@Autowired
	private IRepositoryCommande dao;
      
	
	public void create(Commande object_in) {
		dao.create(object_in);
	}

	public Commande findByID(int id) {
		return dao.findByID(id);

	}

	public List<Commande> findAll() {
		return dao.findAll();
	}

	public void update(Commande object_in) {
		dao.update(object_in);

	}

	public void delete(int id) {
		dao.delete(id);

	}
	
	


	
}
