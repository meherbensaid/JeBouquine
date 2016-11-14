package com.websystique.springmvc.dao;

import java.util.List;
import java.util.Set;

import com.websystique.springmvc.GenericRepository.GenericRepository;
import com.websystique.springmvc.model.Auteur;
import com.websystique.springmvc.model.Livre;


public interface IRepositoryLivre extends GenericRepository<Livre, Integer>{
	
	public List<Livre> findLivreByCat(String NomCategorie) ;
	public List<Livre> findLivreByAuthor(String NameAuthor);
	public List<Livre> findLivreByISBN(String ISBNS);
	public List<Livre> FindCriteria(String titre,String auteurs,String ISBN,String cat);
	
}
