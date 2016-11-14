package com.websystique.springmvc.service;
import java.util.List;

import com.websystique.springmvc.model.Auteur;

public interface IAuteurService {

	public  void create(Auteur object_in);
	public  Auteur findByID(int id);
	public List<Auteur> findAll();
	public  void update(Auteur object_in);
	public  void delete(int id);
	
	
}
