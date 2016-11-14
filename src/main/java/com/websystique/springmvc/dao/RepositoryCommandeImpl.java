package com.websystique.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.GenericRepository.GenericRepositoryImp;
import com.websystique.springmvc.model.Commande;
@Repository
public class RepositoryCommandeImpl extends GenericRepositoryImp<Commande, Integer> implements IRepositoryCommande{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public RepositoryCommandeImpl() {
		super(Commande.class);
	}
	

	public RepositoryCommandeImpl(Class<Commande> type) {
		super(type);
		}
		
	
	

	

}
