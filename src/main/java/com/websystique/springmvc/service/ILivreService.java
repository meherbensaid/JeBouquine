package com.websystique.springmvc.service;
import java.util.List;
import java.util.Set;

import com.websystique.springmvc.model.Auteur;
import com.websystique.springmvc.model.Livre;

public interface ILivreService {

	public  void create(Livre object_in);
	public  Livre findByID(int id);
	public List<Livre> findAll();
	public  void update(Livre object_in);
	public  void delete(int id);
	public List<Livre> findLivreByCat(String NomCategorie) ;
	public List<Livre> findLivreByAuthor(String NameAuthor);
	public List<Livre> findLivreByISBN(String ISBNS);
	public List<Livre> FindCriteria(String titre,String auteurs,String ISBN,String cat);
	
}
