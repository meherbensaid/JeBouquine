package com.websystique.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.GenericRepository.GenericRepositoryImp;
import com.websystique.springmvc.model.Livre;
import com.websystique.springmvc.model.Panier;
@Repository
public class RepositoryPanierImpl extends GenericRepositoryImp<Panier, Integer> implements IRepositoryPanier {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public RepositoryPanierImpl() {
		super(Panier.class);
	}
	

	public RepositoryPanierImpl(Class<Panier> type) {
		super(type);
		}
		
	

}
