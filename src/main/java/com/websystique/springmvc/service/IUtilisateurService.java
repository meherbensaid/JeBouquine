package com.websystique.springmvc.service;
import java.util.List;

import com.websystique.springmvc.model.Utilisateur;

public interface IUtilisateurService {

	public  void create(Utilisateur object_in);
	public  Utilisateur findByID(int id);
	public List<Utilisateur> findAll();
	public  void update(Utilisateur object_in);
	public  void delete(int id);
	public  Utilisateur existe(Utilisateur U);
}
