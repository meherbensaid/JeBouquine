package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.IRepositoryLivre;
import com.websystique.springmvc.model.Livre;

@Service("livreService")
public class LivreService implements ILivreService {

	@Autowired
	private IRepositoryLivre dao;
      
	
	public void create(Livre object_in) {
		dao.create(object_in);
	}

	public Livre findByID(int id) {
		return dao.findByID(id);

	}

	public List<Livre> findAll() {
		return dao.findAll();
	}

	public void update(Livre object_in) {
		dao.update(object_in);

	}

	public void delete(int id) {
		dao.delete(id);

	}
	@Override
	public List<Livre> findLivreByCat(String NomCategorie) {
		// TODO Auto-generated method stub
		return dao.findLivreByCat(NomCategorie);
	}


	@Override
	public List<Livre> findLivreByAuthor(String NameAuthor) {
		// TODO Auto-generated method stub
		return dao.findLivreByAuthor(NameAuthor);
	}


	@Override
	public List<Livre> findLivreByISBN(String ISBNS) {
		// TODO Auto-generated method stub
		return dao.findLivreByISBN(ISBNS);
	}


	@Override
	public List<Livre> FindCriteria(String titre,String auteurs,String ISBN,String cat) {
		// TODO Auto-generated method stub
		return dao.FindCriteria(titre, auteurs, ISBN, cat);
	}


	
}
