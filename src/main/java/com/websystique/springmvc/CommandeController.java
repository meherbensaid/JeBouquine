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

import com.websystique.springmvc.model.Livre;
import com.websystique.springmvc.model.Panier;
import com.websystique.springmvc.model.Utilisateur;
import com.websystique.springmvc.service.IAuteurService;
import com.websystique.springmvc.service.ICommandeService;
import com.websystique.springmvc.service.ICommentaireService;
import com.websystique.springmvc.service.ILivreService;
import com.websystique.springmvc.service.IPanierService;

@Controller
@RequestMapping("/Commande")
@Scope("session")
public class CommandeController {

	@Autowired
	ILivreService serviceLivre;

	// @Autowired
	// IClientService serviceClient;
	//
	@Autowired
	IAuteurService serviceAuteur;

	@Autowired
	ICommandeService serviceCommande;

	@Autowired
	IPanierService servicePanier;

	@Autowired
	ICommentaireService serviceCommentaire;

	//
	// @Autowired
	// MessageSource messageSource;

	/*
	 * This method will list all existing employees.
	 */

	@RequestMapping(value = { "/PasserCommande" }, method = RequestMethod.GET)
	public String PasserCommande(ModelMap model, HttpSession session) {

		Utilisateur U = (Utilisateur) session.getAttribute("utilisateur");
		//
		model.put("panier", U.getPanier());
		return "Affichage_Commande";
	}

	@RequestMapping(value = { "/EffectuerCommande" }, method = RequestMethod.GET)
	public String EffectuerCommande(ModelMap model, HttpSession session) {
		boolean tmp = true;
		Utilisateur U = (Utilisateur) session.getAttribute("utilisateur");
		Panier P = new Panier();
		List<Livre> Livres_panie = U.getPanier().getLivres();
		List<Livre> Livres = serviceLivre.findAll();
		for (int i = 0; i < Livres.size(); i++) {
			for (int j = 0; j < Livres_panie.size(); j++) {
				if (Livres_panie.get(j).getId() == Livres.get(i).getId()) {
					if (Livres_panie.get(j).getQuantite_panie() > Livres.get(i).getStock_Quantite()) {
						tmp = false;
					}
				}
			}
		}
		if (tmp) {
			P.setLivres(Livres_panie);
			P.setPrix_total(U.getPanier().getPrix_total());
			P.setUtilisateur(U);
			List<Panier> Paniers = new Vector<Panier>();
			Paniers.add(P);

			for (Livre livre : Livres_panie) {

				livre.getPaniers().add(P);
			}
			// System.out.println(U);
			servicePanier.create(P);
			System.out.println("commande ajouter");
		} else {
			////// erreur//////
			return "redirect:/";
		}
		return "redirect:/Commande/ListerCommande";
	}

	@RequestMapping(value = { "/supprimer/{livre.id}" }, method = RequestMethod.GET)
	public String Supprimer(ModelMap model, @PathVariable(value = "livre.id") int id, HttpSession session) {
		List<Livre> livres = new Vector<Livre>();
		livres = serviceLivre.findAll();
		Livre L = new Livre();

		for (Livre livre2 : livres) {
			if (livre2.getId() == id) {
				L = livre2;
			}
		}
		L.setQuantite_panie(1);

		Utilisateur U = (Utilisateur) session.getAttribute("utilisateur");
		// System.out.println(U);
		// System.out.println(L);
		Panier p = U.getPanier();
		boolean test = false;
		// System.out.println(L);

		List<Livre> Livres = p.getLivres();
		int i = 0;
		int position = 0;
		;
		for (Livre livre : Livres) {

			if (livre.getId() == L.getId()) {

				position = i;
			}
			i++;

		}

		Livre L2 = Livres.get(position);
		if (L2.getQuantite_panie() == 1) {
			Livres.remove(L2);
		} else {

			L2.setQuantite_panie(L2.getQuantite_panie() - 1);

		}
		p.setPrix_total(p.getPrix_total() - L2.getPrix());
		p.setLivres(Livres);
		U.setPanier(p);

		model.put("livres", U.getPanier().getLivres());
		model.put("prix", U.getPanier().getPrix_total());
		return "LivresPanier";
	}

	@RequestMapping(value = { "/ListerCommande" }, method = RequestMethod.GET)
	public String ListerCommande(ModelMap model, HttpSession session) {

		Utilisateur U = (Utilisateur) session.getAttribute("utilisateur");

		if (U == null || U.getID() == -1) {
			return "redirect:/Utilisateur/Authentification";
		} else {

			List<Panier> Commandes = servicePanier.findAll();
			List<Panier> CommandesUtilisateur = new Vector<Panier>();
			for (Panier commande : Commandes) {
				if (commande.getUtilisateur().getID() == U.getID()) {
					CommandesUtilisateur.add(commande);
				}
			}

			for (Panier panier : CommandesUtilisateur) {
				System.out.println(panier);
			}
			model.put("Commandes", CommandesUtilisateur);
			return "ListesCommandes";
		}
	}

	//
	//
	// @RequestMapping(value={"/Supprimer/{livre.id}"}, method =
	// RequestMethod.GET)
	// public String Supprimer(ModelMap model,@PathVariable(value="livre.id")
	// int id){
	// List<Livre> livres=new Vector<Livre>();
	//
	//
	//
	// serviceLivre.delete(id);
	// return "redirect:/list";
	// }
	//
	//
	// @RequestMapping(value = { "/RechercheAvancee" }, method =
	// RequestMethod.GET)
	// public String FormulaireRechercheAvancee(ModelMap model) {
	// Livre livre = new Livre();
	// model.addAttribute("livre", livre);
	// List<Auteur> Auteurs=serviceAuteur.findAll();
	// List<Categorie> Categories=serviceCategorie.findAll();
	// model.addAttribute("Categories",Categories);
	// model.addAttribute("Auteurs", Auteurs);
	//
	// // model.addAttribute("edit", false);
	// return "formulaireRechercheAvancee";
	// }
	// @RequestMapping(value = { "/RechercheAvancee" }, method =
	// RequestMethod.POST)
	// public String RechercherAvancee(@Valid Livre livre, BindingResult result,
	// ModelMap model) {
	//
	//// if (result.hasErrors()) {
	//// return "formulaireRechercheAvancee";
	//// }
	////
	//////
	//// ////////SET ////////////
	//
	//
	// System.out.println(livre.getAuteurs());
	// List<Livre> liste =serviceLivre.FindCriteria(livre.getTitre(),"",
	// livre.getISBN(),"");
	//
	//
	// model.addAttribute("liste", liste);
	// return "success";
	// }
	//
	//
	//
	//
	// @RequestMapping(value = { "/AjoutLivre" }, method = RequestMethod.GET)
	// public String FormulaireAjoutLivre(ModelMap model) {
	// Livre livre = new Livre();
	// model.addAttribute("livre", livre);
	//
	// // model.addAttribute("edit", false);
	// return "AjoutLivre";
	// }
	// @RequestMapping(value = { "/AjoutLivre" }, method = RequestMethod.POST)
	// public String AjoutLivre(@Valid Livre livre, BindingResult
	// result,HttpServletRequest Request,
	// ModelMap model) {
	// System.out.println(livre);
	// if (result.hasErrors()) {
	// return "AjoutLivre";
	// }
	//
	//
	//
	//
	// String nom_Auteur=(String) Request.getParameter("Auteur");
	// String nom_Categorie=(String) Request.getParameter("Categorie");
	// List<Auteur> Auteurs=new Vector<Auteur>();
	// Auteurs.add(new Auteur(nom_Auteur));
	// List<Categorie> Categories=new Vector<Categorie>();
	// Categories.add(new Categorie(nom_Categorie));
	// livre.setAuteurs(Auteurs);
	// livre.setCategories(Categories);
	// serviceLivre.create(livre);
	//////
	//// ////////SET ////////////
	//
	//
	// System.out.println(livre);
	//
	// return "redirect:/list";
	// }

	//
	// @RequestMapping(value = {"/Authentification" }, method =
	// RequestMethod.GET)
	// public String FormulaireAuthentification(ModelMap model) {
	// Client client = new Client();
	// model.addAttribute("client", client);
	// //model.addAttribute("edit", false);
	// return "authentification";
	// }
	// @RequestMapping(value = { "/Authentification" }, method =
	// RequestMethod.POST)
	// public String Authentification(@Valid Client client, BindingResult
	// result,
	//
	// ModelMap model,HttpServletRequest request) {
	//
	// if (result.hasErrors()) {
	// return "authentification";
	// }
	//
	// Client clientAuthentifié = serviceClient.authentifier(client.getEmail(),
	// client.getMotDePasse()) ;
	//
	// if (clientAuthentifié != null)
	//
	// {
	// // model.addAttribute("client", client);
	// HttpSession session =request.getSession();
	// request.setAttribute("client", clientAuthentifié);
	// model.addAttribute("client", clientAuthentifié);
	// return "allLivres";
	// }
	//
	// return "showMessage";
	// }
	//
	// /*
	// * This method will be called on form submission, handling POST request
	// for
	// * saving employee in database. It also validates the user input
	// */
	// @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	// public String saveEmployee(@Valid Employee employee, BindingResult
	// result,
	// ModelMap model) {
	//
	// if (result.hasErrors()) {
	// return "registration";
	// }
	//
	// /*
	// * Preferred way to achieve uniqueness of field [ssn] should be
	// implementing custom @Unique annotation
	// * and applying it on field [ssn] of Model class [Employee].
	// *
	// * Below mentioned peace of code [if block] is to demonstrate that you can
	// fill custom errors outside the validation
	// * framework as well while still using internationalized messages.
	// *
	// */
	// if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
	// FieldError ssnError =new
	// FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn",
	// new String[]{employee.getSsn()}, Locale.getDefault()));
	// result.addError(ssnError);
	// return "registration";
	// }
	//
	// service.saveEmployee(employee);
	//
	// model.addAttribute("success", "Employee " + employee.getName() + "
	// registered successfully");
	// return "success";
	// }
	//
	//
	// /*
	// * This method will provide the medium to update an existing employee.
	// */
	// @RequestMapping(value = { "/edit-{ssn}-employee" }, method =
	// RequestMethod.GET)
	// public String editEmployee(@PathVariable String ssn, ModelMap model) {
	// Employee employee = service.findEmployeeBySsn(ssn);
	// model.addAttribute("employee", employee);
	// model.addAttribute("edit", true);
	// return "registration";
	// }
	//
	// /*
	// * This method will be called on form submission, handling POST request
	// for
	// * updating employee in database. It also validates the user input
	// */
	// @RequestMapping(value = { "/edit-{ssn}-employee" }, method =
	// RequestMethod.POST)
	// public String updateEmployee(@Valid Employee employee, BindingResult
	// result,
	// ModelMap model, @PathVariable String ssn) {
	//
	// if (result.hasErrors()) {
	// return "registration";
	// }
	//
	// if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
	// FieldError ssnError =new
	// FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn",
	// new String[]{employee.getSsn()}, Locale.getDefault()));
	// result.addError(ssnError);
	// return "registration";
	// }
	//
	// service.updateEmployee(employee);
	//
	// model.addAttribute("success", "Employee " + employee.getName() + "
	// updated successfully");
	// return "success";
	// }
	//
	//
	// /*
	// * This method will delete an employee by it's SSN value.
	// */
	// @RequestMapping(value = { "/delete-{ssn}-employee" }, method =
	// RequestMethod.GET)
	// public String deleteEmployee(@PathVariable String ssn) {
	// service.deleteEmployeeBySsn(ssn);
	// return "redirect:/list";
	// }

}