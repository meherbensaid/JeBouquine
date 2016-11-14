package com.websystique.springmvc.service;
import java.util.List;

import com.websystique.springmvc.model.Categorie;
import com.websystique.springmvc.model.Livre;

public interface ICategorieService {

	public  void create(Categorie object_in);
	public  Categorie findByID(int id);
	public List<Categorie> findAll();
	public  void update(Categorie object_in);
	public  void delete(int id);
	
	
}
