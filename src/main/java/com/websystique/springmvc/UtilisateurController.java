package com.websystique.springmvc;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springmvc.model.Auteur;
import com.websystique.springmvc.model.Categorie;
import com.websystique.springmvc.model.Livre;
import com.websystique.springmvc.model.Utilisateur;
import com.websystique.springmvc.service.IUtilisateurService;

@Controller
@RequestMapping("/Utilisateur")
@Scope("session")
@SessionAttributes("thought")
public class UtilisateurController {

	@Autowired
	IUtilisateurService serviceUtilisateur;

	// @Autowired
	// IClientService serviceClient;
	//

	//
	// @Autowired
	// MessageSource messageSource;

	@RequestMapping(value = { "/Deconnexion" }, method = RequestMethod.GET)
	public String FormulaireDeconnexion(ModelMap model, HttpSession session) {

    	Utilisateur utilisateur = new Utilisateur();    	
    	utilisateur.setID(-1);
		model.addAttribute("utilisateur", utilisateur);
		session.setAttribute("uexiste", 0);
//		 session.invalidate();

		return "/Authentification";
	}

	
	@RequestMapping(value = { "/Authentification" }, method = RequestMethod.GET)
    public String FormulaireAuthentification(ModelMap model, HttpSession session) {
    	
    	
    	Utilisateur utilisateur = new Utilisateur();    	
    	utilisateur.setID(-1);
    	
    	if(session.getAttribute("utilisateur")==null){
    		model.addAttribute("utilisateur", utilisateur);
    		session.setAttribute("uexiste", 0);
    	}
        
        
      //  model.addAttribute("edit", false);
        return "formulaireAuthentification";
    }

	@RequestMapping(value = { "/Authentification" }, method = RequestMethod.POST)
	public ModelAndView Authentification(@Valid Utilisateur utilisateur, BindingResult result, ModelMap model,
			HttpSession session) {

		Utilisateur U = new Utilisateur();

		// if (result.hasErrors()) {
		// return modelAndView;
		// }
		ModelAndView modelAndView = new ModelAndView();
		////
		// ////////SET ////////////
		boolean existe = false;
		U = serviceUtilisateur.existe(utilisateur);

		if (U != null) {

			System.out.println(U);

			modelAndView.setViewName("redirect:/list");
			session.setAttribute("utilisateur", U);
			session.setAttribute("uexiste", 1);
			model.addAttribute("utilisateur", U);
			modelAndView.addObject("utilisateur", U);
			return modelAndView;
		}
		// else {
		// return modelAndView;
		// }
		else {
			modelAndView.setViewName("formulaireAuthentification");

			return modelAndView;

		}
	}

	@RequestMapping(value = { "/AjouterUtilisateur" }, method = RequestMethod.GET)
	public String FormulaireAjouterUtilisateur(ModelMap model, HttpSession session) {
		Utilisateur utilisateur = new Utilisateur();
		model.addAttribute("utilisateur", utilisateur);
		Utilisateur U = (Utilisateur) session.getAttribute("thought");
		System.out.println(U);
		// model.addAttribute("edit", false);
		return "formulaireAjoutUtilisateur";
	}

	@RequestMapping(value = { "/AjouterUtilisateur" }, method = RequestMethod.POST)
	public String RechercherAvancee(@Valid Utilisateur utilisateur, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "formulaireAjoutUtilisateur";
		}

		////
		// ////////SET ////////////

		serviceUtilisateur.create(utilisateur);

		model.addAttribute("utilisateur", utilisateur);
		return "SuccesInscription";
	}

	@RequestMapping(value = { "/AjoutLivre" }, method = RequestMethod.GET)
	public String FormulaireAjoutLivre(ModelMap model) {
		Livre livre = new Livre();
		model.addAttribute("livre", livre);

		// model.addAttribute("edit", false);
		return "AjoutLivre";
	}

	@RequestMapping(value = { "/AjoutLivre" }, method = RequestMethod.POST)
	public String AjoutLivre(@Valid Livre livre, BindingResult result, ModelMap model) {
		System.out.println(livre);
		// if (result.hasErrors()) {
		// return "formulaireRechercheAvancee";
		// }
		//
		////
		// ////////SET ////////////

		return "success";
	}

}