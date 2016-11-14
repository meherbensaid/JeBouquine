package com.websystique.springmvc;
 
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.websystique.springmvc.model.Categorie;
import com.websystique.springmvc.model.Commentaire;
import com.websystique.springmvc.model.Livre;
import com.websystique.springmvc.model.Utilisateur;
import com.websystique.springmvc.service.ICommentaireService;
import com.websystique.springmvc.service.ILivreService;
 
@Controller
@RequestMapping("/Commentaire")
@Scope("session")
public class CommentaireController {
 
	
    @Autowired
    ICommentaireService serviceCommentaire;
     
    
    @Autowired
    ILivreService serviceLivre;
    
//    @Autowired
//    IClientService serviceClient;
//    
   
//    
//    @Autowired
//    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = { "/ListeCommentaire/{livre.id}" }, method = RequestMethod.GET)
    public String FormulaireAjoutCategorie(ModelMap model,@PathVariable(value="livre.id") int id) {
    	
    	List<Livre> livres=new Vector<Livre>();
    	livres=serviceLivre.findAll();
    	Livre L=new Livre();
    	
    	for (Livre livre2 : livres) {
			if(livre2.getId()==id){
				L=livre2;
			}
		}
    	
    	List<Commentaire> Commentaires= L.getCommentaires();
       for (Commentaire commentaire : Commentaires) {
		System.out.println(commentaire);
       									
       }
        model.put("livre", L);
        
        //  model.addAttribute("edit", false);
        return "Afficher_Commentaire";
    }
    
    @RequestMapping(value = { "/AjoutCommentaire/{livre.id}" }, method = RequestMethod.GET)
    public String AjoutCategorie(HttpSession session,@PathVariable(value="livre.id") int id,@Valid Categorie categorie,@RequestParam(value="text") String text, BindingResult result,
            ModelMap model) {
 
    	
    	Utilisateur U=(Utilisateur)session.getAttribute("utilisateur");
    	List<Livre> livres=serviceLivre.findAll();
    	Livre L=new Livre();
    	
    	for (Livre livre2 : livres) {
			if(livre2.getId()==id){
				L=livre2;
			}
		}
    	
       Commentaire C=new Commentaire();
       C.setText(text);
       C.setUtilisateur(U);
       C.setLivre(L);
       List<Commentaire> Commentaires =L.getCommentaires();
       Commentaires.add(C);
       L.setCommentaires(Commentaires);
       serviceCommentaire.create(C);
       ////      
//    ////////SET ////////////
       session.setAttribute("Commentaire", Commentaires);
       
        model.put("livre", L);
        
        return "redirect:/Details/"+L.getId()+"#horizontalTab";
    	
    }
    @RequestMapping(value = { "/Supprimer/{c.id}" }, method = RequestMethod.GET)
    public String EffacerComentaire(HttpSession session,@PathVariable(value="c.id") int id,@Valid Categorie categorie, BindingResult result,
            ModelMap model) {
 
    	
    	System.out.println("aaaa");
//    	
    	Utilisateur U=(Utilisateur)session.getAttribute("utilisateur");
    	Commentaire C=new Commentaire();
    	List<Commentaire> Commentaires=serviceCommentaire.findAll();
    	for (Commentaire commentaire : Commentaires) {
			if(commentaire.getId()==id){
			C=commentaire;	
			}
			
		}
    	serviceCommentaire.delete(C.getId());;
    	
    	int ids=C.getLivre().getId();
//    	       ////      
////    ////////SET ////////////
//       
        
//        model.addAttribute("livre.id",ids);
//        return "SuccesInscription";
//        return "redirect:/";
//

        return "redirect:/Details/"+ids+"#horizontalTab";
//    	
    }
    
// 
    
 
}