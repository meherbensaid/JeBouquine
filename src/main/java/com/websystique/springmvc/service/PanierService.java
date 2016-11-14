package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.IRepositoryPanier;
import com.websystique.springmvc.model.Panier;

@Service("PanierService")
public class PanierService implements IPanierService {

	@Autowired
	private IRepositoryPanier dao;
      
	
	public void create(Panier object_in) {
		dao.create(object_in);
	}

	public Panier findByID(int id) {
		return dao.findByID(id);

	}

	public List<Panier> findAll() {
		return dao.findAll();
	}

	public void update(Panier object_in) {
		dao.update(object_in);

	}

	public void delete(int id) {
		dao.delete(id);

	}
	
	


	
}
