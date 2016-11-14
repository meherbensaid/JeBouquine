package com.websystique.springmvc.service;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.IRepositoryUtilisateur;
import com.websystique.springmvc.model.Utilisateur;

@Service("UtilisateurService")
public class UtilisateurService implements IUtilisateurService {

	@Autowired
	private IRepositoryUtilisateur dao;
      
	
	public void create(Utilisateur object_in) {
		dao.create(object_in);
	}

	public Utilisateur findByID(int id) {
		return dao.findByID(id);

	}

	public List<Utilisateur> findAll() {
		return dao.findAll();
	}

	public void update(Utilisateur object_in) {
		dao.update(object_in);

	}

	public void delete(int id) {
		dao.delete(id);

	}

	@Override
	public Utilisateur existe(Utilisateur U) {
		List <Utilisateur> ListeU=new Vector<Utilisateur>();
		Utilisateur U1=null;
		ListeU=findAll();
		
		for (Utilisateur utilisateur : ListeU) {
			if((utilisateur.getLogin().equals(U.getLogin()))&&(utilisateur.getMot_De_Passe().equals(U.getMot_De_Passe()))){
				U1=utilisateur;
			}
		}
		return U1;
	}
	
	
	


	
}
