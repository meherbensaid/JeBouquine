package com.websystique.springmvc.service;
import java.util.List;

import com.websystique.springmvc.model.Panier;

public interface IPanierService {

	public  void create(Panier object_in);
	public  Panier findByID(int id);
	public List<Panier> findAll();
	public  void update(Panier object_in);
	public  void delete(int id);
	
	
}
