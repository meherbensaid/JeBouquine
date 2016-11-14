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
public class RepositoryLivreImpl extends GenericRepositoryImp<Livre, Integer> implements IRepositoryLivre {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public RepositoryLivreImpl() {
		super(Livre.class);
	}
	

	public RepositoryLivreImpl(Class<Livre> type) {
		super(type);
		}
		
	
	public List<Livre> findLivreByCat(String nom_cat) {
		List<Livre> toExport = null;
		
	
		try {
			
			Query q = getSession().createQuery(
					" select l FROM Livre l  join l.categories as Lc where Lc.nom in ('"+nom_cat+"')"
					);
			toExport =  q.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return toExport;
	}
	
	@Override
	public List<Livre> findLivreByAuthor(String NameAuthor) {
			List<Livre> toExport = null;
		
		
		try {
			
			Query q = getSession().createQuery(
					" select l FROM Livre l  join l.auteurs as La where La.nom in ('"+NameAuthor+"')"
					);
			toExport =  q.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return toExport;
	}
	@Override
	public List<Livre> findLivreByISBN(String ISBN) {
			List<Livre> toExport = null;
		
		
		try {
			
			Query q = getSession().createQuery(
					" select l FROM Livre l   where l.ISBN='"+ISBN+"'");
			toExport =  q.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return toExport;
	}

	@Override
	public List<Livre> FindCriteria(String titre, String auteur, String ISBN, String cat) {
		// TODO Auto-generated method stub
		
		
		
		ArrayList<Livre> res = new ArrayList<Livre>();
		Session s=getSession();
		
		Disjunction dis = Restrictions.disjunction();
		
		
		Criteria cr = s.createCriteria(Livre.class);
		
		
		
		
		if(!titre.isEmpty())
			cr.add(Restrictions.like("titre", "%"+titre+"%"));
		
		if(!ISBN.isEmpty())
		cr.add(Restrictions.eq("ISBN", ISBN));
		
//    cr.createAlias("auteurs", "aut");
//	   
		if(!auteur.isEmpty())
		{
				cr.createAlias("auteurs", "aut");
//				ArrayList<String> noms = new ArrayList<String>();
//			for(Auteur a : auteurs) noms.add(a.getNom());
				 dis.add(Restrictions.eq("aut.nom",auteur));
			
			}
			
	
		if(!cat.isEmpty()){ 
			cr.createAlias("categories", "cat");
			dis.add(Restrictions.eq("cat.nom",cat));}
		
		cr.add(dis);
		return cr.list();
		
//		Criteria cr = s.createCriteria(Livre.class);
//	    cr.createAlias("auteurs", "aut");
//		cr.createAlias("categories", "cat");
//		Disjunction dis = Restrictions.disjunction();
//		if(!titre.isEmpty())
//		cr.add(Restrictions.like("titre", "%"+titre+"%"));
//		if(!ISBN.isEmpty())
//		cr.add(Restrictions.eq("ISBN", ISBN));
//		if(auteurs!= null)
//		if(!auteurs.isEmpty())
//		{
//			ArrayList<String> noms = new ArrayList<String>();
//			for(String a : auteurs) noms.add(a);
//			 dis.add(Restrictions.in("aut.Nom", noms));
//		}
//		if(!cat.isEmpty()) dis.add(Restrictions.eq("cat.libellé",cat));
//		
//		return cr.list();

	}

	

}
