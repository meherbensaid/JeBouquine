package com.websystique.springmvc;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Categorie;
import com.websystique.springmvc.service.ICategorieService;

import java.util.List;
 
@Controller
@RequestMapping("/Categorie")
@Scope("session")
public class CategorieController {
 
	
    @Autowired
    ICategorieService serviceCategorie;
     
//    @Autowired
//    IClientService serviceClient;
//    
   
//    
//    @Autowired
//    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = { "/AjoutCategorie" }, method = RequestMethod.GET)
    public String FormulaireAjoutCategorie(ModelMap model) {
    	Categorie categorie = new Categorie();
        model.addAttribute("categorie", categorie);
        
        
      //  model.addAttribute("edit", false);
        return "formulaireAjoutCategorie";
    }

    @RequestMapping(value = { "/AjoutCategorie" }, method = RequestMethod.POST)
    public String AjoutCategorie(@Valid Categorie categorie, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "formulaireAjoutCategorie";
        }

    
////      
//    ////////SET ////////////
        
        serviceCategorie.create(categorie);
        System.out.println(categorie);
        model.addAttribute("categorie", categorie);
        return "SuccesAjoutCategorie";
    	
    }
 
    
 
}