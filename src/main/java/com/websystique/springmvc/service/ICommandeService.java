package com.websystique.springmvc.service;
import java.util.List;

import com.websystique.springmvc.model.Commande;

public interface ICommandeService {

	public  void create(Commande object_in);
	public  Commande findByID(int id);
	public List<Commande> findAll();
	public  void update(Commande object_in);
	public  void delete(int id);
	
	
}
