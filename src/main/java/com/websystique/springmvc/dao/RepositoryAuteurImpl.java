package com.websystique.springmvc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.GenericRepository.GenericRepositoryImp;
import com.websystique.springmvc.model.Auteur;
import com.websystique.springmvc.model.Livre;
@Repository
public class RepositoryAuteurImpl extends GenericRepositoryImp<Auteur, Integer> implements IRepositoryAuteur{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public RepositoryAuteurImpl() {
		super(Auteur.class);
	}
	

	public RepositoryAuteurImpl(Class<Auteur> type) {
		super(type);
		}
		
	
	

	

}
