package com.websystique.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.GenericRepository.GenericRepositoryImp;
import com.websystique.springmvc.model.Categorie;
import com.websystique.springmvc.model.Livre;

@Repository
public class RepositoryCategorieImpl  extends  GenericRepositoryImp<Categorie, Integer> implements IRepositoryCategorie{
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public RepositoryCategorieImpl() {
		super(Categorie.class);
	}
	

	public RepositoryCategorieImpl(Class<Categorie> type) {
		super(type);
		}
}
