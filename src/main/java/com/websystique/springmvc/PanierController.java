package com.websystique.springmvc;
 
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.websystique.springmvc.model.Livre;
import com.websystique.springmvc.model.Panier;
import com.websystique.springmvc.model.Utilisateur;
import com.websystique.springmvc.service.IAuteurService;
import com.websystique.springmvc.service.ICategorieService;
import com.websystique.springmvc.service.ILivreService;
 
@Controller
@RequestMapping("/Panier")
@Scope("session")
public class PanierController {
 
	
    @Autowired
    ILivreService serviceLivre;
     
//    @Autowired
//    IClientService serviceClient;
//    
    @Autowired
    IAuteurService serviceAuteur;
    
    @Autowired
    ICategorieService serviceCategorie;
//    
//    @Autowired
//    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
   
 
    
    @RequestMapping(value={"/AjouterPanier/{livre.id}"}, method = RequestMethod.GET)
    public String Details(ModelMap model,@RequestParam(value="qte") int qte,@PathVariable(value="livre.id") int id,HttpSession session){
    	int prix_total=0;
    	List<Livre> livres=new Vector<Livre>();
    	livres=serviceLivre.findAll();
    	Livre L=new Livre();
    	if(livres!=null){    		
    	for (Livre livre2 : livres) {
			if(livre2.getId()==id){
				L=livre2;
			}
		}
		}
    	L.setQuantite_panie(qte);
    	
    	Utilisateur U=(Utilisateur)session.getAttribute("utilisateur");
//    	System.out.println(U);
//    	System.out.println(L);
    	Panier p=U.getPanier();
    	boolean test=false;
//    	System.out.println(L);
    	if(p==null){
    		p=new Panier();
    		List<Livre> L1=new Vector<Livre>();
    		L1.add(L);
    		p.setLivres(L1);
    		p.setPrix_total(L.getPrix()*qte);
    		U.setPanier(p);
    		model.put("prix",U.getPanier().getPrix_total());
    		model.put("livres",U.getPanier().getLivres());
    		
//        	System.out.println("i'm here"+id);
        	return "LivresPanier";
    	}
    	else{
    	List<Livre> Livres=p.getLivres();
    	int i=0;
    	int position=0;;
    	if(Livres!=null){
    		
    	for (Livre livre : Livres) {
    		
        	if(livre.getId()==L.getId()){
        		test=true;
        		position=i;
        	}
        	i++;
        		
		}
    	
    	
    	if(test){
//    	
    	
    		
//    		System.out.println(index);
    		Livre L2=Livres.get(position);
//    		System.out.println(L2);
    		Livres.remove(L2);
    		L2.setQuantite_panie(L2.getQuantite_panie()+qte);
    		Livres.add(position,L2);
    	}
    	else{
    	Livres.add(L);
    	}
    	p.setLivres(Livres);
    	
    	
    	for (Livre livre : Livres) {
			prix_total+=livre.getPrix()*livre.getQuantite_panie();
		}
    	System.out.println("prix totale : "+prix_total);
    	p.setPrix_total(prix_total);
    	
    	U.setPanier(p);
    	
    	model.put("livres",U.getPanier().getLivres());
    	model.put("prix",U.getPanier().getPrix_total());
//    	return "LivresPanier";
    	}
    	return "redirect:/Details/"+id;
    }}
    
    
    
    
    
    
    @RequestMapping(value={"/supprimer/{livre.id}"}, method = RequestMethod.GET)
    public String Supprimer(ModelMap model,@PathVariable(value="livre.id") int id,@RequestParam(value="qte") int qte,HttpSession session){
    	List<Livre> livres=new Vector<Livre>();
    	livres=serviceLivre.findAll();
    	Livre L=new Livre();
    	
    	for (Livre livre2 : livres) {
			if(livre2.getId()==id){
				L=livre2;
			}
		}
    	L.setQuantite_panie(1);
   
    	Utilisateur U=(Utilisateur)session.getAttribute("utilisateur");
//    	System.out.println(U);
//    	System.out.println(L);
    	Panier p=U.getPanier();
    	boolean test=false;
//    	System.out.println(L);
    	
    	List<Livre> Livres=p.getLivres();
    	int i=0;
    	int position=0;;
    	for (Livre livre : Livres) {
    		
        	if(livre.getId()==L.getId()){
        		
        		position=i;
        	}
        	i++;
        		
		}

    		Livre L2=Livres.get(position);
    		if(qte-L2.getQuantite_panie()>=0){
    			Livres.remove(L2);
    			p.setPrix_total(0);
    		}
    		else{

    		L2.setQuantite_panie(L2.getQuantite_panie()-qte);
    		p.setPrix_total(p.getPrix_total()-L2.getPrix());
    		}
    		
    		
    	p.setLivres(Livres);
    	U.setPanier(p);
    	
    	model.put("livres",U.getPanier().getLivres());
    	model.put("prix",U.getPanier().getPrix_total());
    	return "LivresPanier";
    }
    
    

    @RequestMapping(value={"/AfficherPanier"}, method = RequestMethod.GET)
    public String Afficher(ModelMap model,HttpSession session){
    	
    	Utilisateur U=(Utilisateur)session.getAttribute("utilisateur");
    	if(U==null || U.getID()==-1){
    		return "redirect:/Utilisateur/Authentification";
    	}
    	else{

    	Panier p=U.getPanier();
		if(p==null) {p = new Panier();U.setPanier(p);};
		
    	model.put("livres",U.getPanier().getLivres());
    	model.put("prix",U.getPanier().getPrix_total());
    	return "LivresPanier";
    	}
    }
//    
   
    
    
}