package com.websystique.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.GenericRepository.GenericRepositoryImp;
import com.websystique.springmvc.model.Commentaire;
import com.websystique.springmvc.model.Panier;
@Repository
public class RepositoryCommentaireImpl extends GenericRepositoryImp<Commentaire, Integer> implements IRepositoryCommentaire {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public RepositoryCommentaireImpl() {
		super(Commentaire.class);
	}
	

	public RepositoryCommentaireImpl(Class<Commentaire> type) {
		super(type);
		}
		
	

}
