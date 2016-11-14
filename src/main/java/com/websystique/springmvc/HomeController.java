package com.websystique.springmvc;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.websystique.springmvc.model.Auteur;
import com.websystique.springmvc.model.Categorie;
import com.websystique.springmvc.model.Commentaire;
import com.websystique.springmvc.model.Livre;
import com.websystique.springmvc.model.Utilisateur;
import com.websystique.springmvc.service.IAuteurService;
import com.websystique.springmvc.service.ICategorieService;
import com.websystique.springmvc.service.ILivreService;

@Controller
@RequestMapping("/")
@Scope("session")
public class HomeController {

	@Autowired
	ILivreService serviceLivre;

	// @Autowired
	// IClientService serviceClient;
	//
	@Autowired
	IAuteurService serviceAuteur;

	@Autowired
	ICategorieService serviceCategorie;
	//
	// @Autowired
	// MessageSource messageSource;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listLivre(ModelMap model, HttpSession session) {

		List<Livre> livres = serviceLivre.findAll();
		// for (int i = 0; i < livres.size(); i++) {
		// byte[] fileBytes = livres.get(i).getImage();
		// byte[] encoded = Base64.encode(fileBytes);
		// String encodedString = new String(encoded);
		// livres.get(i).setImageCree(encodedString);
		// }

		Utilisateur U = (Utilisateur) session.getAttribute("utilisateur");
		if(U ==null) session.setAttribute("uexiste", 0);
		else session.setAttribute("uexiste", 1);
//		if (U == null) {
//			if (U.getNom().isEmpty()) {
//				model.put("uexiste", 0);
//			}
//		} else if (!U.getNom().isEmpty()) {
//			model.put("uexiste", 1);
//		}

		List<Categorie> vects = serviceCategorie.findAll();
		List<Auteur> auths = serviceAuteur.findAll();

		// model.put("cats", vects);
		model.addAttribute("cats", vects);
		model.addAttribute("auths", auths);

		model.addAttribute("livres", livres);
		return "allLivres";
	}

	@RequestMapping(value = { "/Details/{livre.id}" }, method = RequestMethod.GET)
	public String Details(ModelMap model, @PathVariable(value = "livre.id") int id) {
		List<Livre> livres = new Vector<Livre>();
		livres = serviceLivre.findAll();

		Livre L = new Livre();

		for (Livre livre2 : livres) {
			if (livre2.getId() == id) {
				L = livre2;
			}
		}

		List<Commentaire> Commentaires = L.getCommentaires();

		System.out.println(L);
		model.put("livre", L);
		System.out.println("i'm here" + id);
		return "DetailsLivre";
	}

	@RequestMapping(value = { "/RLPC/{cat_nom}" }, method = RequestMethod.GET)
	public String RechLivreParCat(ModelMap model, @PathVariable(value = "cat_nom") String catNom) {
		List<Livre> livres = new Vector<Livre>();
		livres = serviceLivre.findLivreByCat(catNom);
		Livre L = new Livre();

		model.addAttribute("livres", livres);

		return "allLivres";
	}

	@RequestMapping(value = { "/RLPA/{authNom}" }, method = RequestMethod.GET)
	public String RechLivreParAuth(ModelMap model, @PathVariable(value = "authNom") String authNom) {
		List<Livre> livres = new Vector<Livre>();
		livres = serviceLivre.findLivreByAuthor(authNom);
		Livre L = new Livre();

		model.addAttribute("livres", livres);

		return "allLivres";
	}

	////
	////
	//// @RequestMapping(value={"/Supprimer/{livre.id}"}, method =
	//// RequestMethod.GET)
	//// public String Supprimer(ModelMap model,@PathVariable(value="livre.id")
	//// int id){
	//// List<Livre> livres=new Vector<Livre>();
	////
	////
	////
	//// serviceLivre.delete(id);
	//// return "redirect:/list";
	//// }
	////
	//
	@RequestMapping(value = { "/RechercheAvancee" }, method = RequestMethod.GET)
	public String FormulaireRechercheAvancee(ModelMap model) {
		Livre livre = new Livre();
		model.addAttribute("livre", livre);
		List<Auteur> Auteurs = serviceAuteur.findAll();
		List<Categorie> Categories = serviceCategorie.findAll();
		model.addAttribute("Categories", Categories);
		model.addAttribute("Auteurs", Auteurs);

		model.addAttribute("edit", false);
		return "formulaireRechercheAvancee";
	}

	@RequestMapping(value = { "/RechercheAvancee" }, method = RequestMethod.POST)
	public String RechercherAvancee(@Valid Livre livre, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "formulaireRechercheAvancee";
		}
		//
		//
		//////// SET ////////////

		System.out.println(livre.getAuteurs());
		List<Livre> liste = serviceLivre.FindCriteria(livre.getTitre(), "a", livre.getISBN(), "a");

		// model.addAttribute("livres", liste);
		model.put("livres", liste);
		// return "success";
		return "allLivres";
	}

	@RequestMapping(value = { "/AjoutLivre" }, method = RequestMethod.GET)
	public String FormulaireAjoutLivre(ModelMap model) {
		Livre livre = new Livre();
		model.addAttribute("livre", livre);

		// model.addAttribute("edit", false);
		return "AjoutLivre";
	}

	@RequestMapping(value = { "/AjoutLivre" }, method = RequestMethod.POST)
	public String AjoutLivre(@Valid Livre livre, BindingResult result,
			@RequestParam(value = "image", required = false) MultipartFile image, HttpServletRequest Request,
			ModelMap model) {
		if (result.hasErrors()) {
			return "AjoutLivre";
		}
		String nom_Auteur = (String) Request.getParameter("Auteur");
		String nom_Categorie = (String) Request.getParameter("Categorie");
		List<Auteur> Auteurs = new Vector<Auteur>();
		Auteurs.add(new Auteur(nom_Auteur));
		List<Categorie> Categories = new Vector<Categorie>();
		Categories.add(new Categorie(nom_Categorie));
		livre.setAuteurs(Auteurs);

		livre.setCategories(Categories);

		serviceLivre.create(livre);

		/* ---- image bla bla ----- */

		// Image upload handling
		if (!image.isEmpty()) {
			// try {
			// validateImage(image);
			// } catch (RuntimeException re) {
			// System.out.println("=>erreur validateImage");
			// return "redirect:/list";
			// }

			try {
				// String filename = livre.getId() + "-" + livre.getTitre() +
				// "_"+image.getOriginalFilename();//".png";
				String filename = image.getOriginalFilename();
				String filepath = saveImage(filename, image, Request);
				livre.setPhoto_Couverture(filename);
			} catch (IOException e) {
				System.out.println("=>erreur file IO exception");
				return "redirect:/list";
			}
		}
		/* ----image things ---- */
		serviceLivre.update(livre);

		return "redirect:/list";
	}

	// // Image Uploading Test
	// @RequestMapping(value = { "/AjoutImage_testt" }, method =
	// RequestMethod.GET)
	// public String FormulaireAjoutImage_testt(ModelMap model) {
	// Livre livre = new Livre();
	// model.addAttribute("livre", livre);
	//
	// // model.addAttribute("edit", false);
	// return "AjoutImage_testt";
	// }
	//
	// @RequestMapping(value = { "/AjoutImage_testt" }, method =
	// RequestMethod.POST)
	// public String AjoutImage_testt(@Valid Livre livre, BindingResult result,
	// @RequestParam(value = "image", required = false) MultipartFile image,
	// HttpServletRequest Request,
	// ModelMap model) {
	//
	// // Image upload handling
	// if (!image.isEmpty()) {
	//// try {
	//// validateImage(image);
	//// } catch (RuntimeException re) {
	//// System.out.println("=>erreur validateImage");
	//// return "redirect:/list";
	//// }
	//
	// try {
	// String filename = livre.getId() + "-" + livre.getTitre() + ".jpg";
	// String filepath = saveImage(filename, image, Request);
	// livre.setPhoto_Couverture(filename);
	// } catch (IOException e) {
	// System.out.println("=>erreur file IO exception");
	// return "redirect:/list";
	// }
	// }
	//
	// serviceLivre.create(livre);
	//
	// System.out.println(livre);
	// System.out.println("=>succes");
	//
	// return "redirect:/";
	// }

	// // Validates 'jpeg|jpg' image types only ... needs correction/testing
	// private void validateImage(MultipartFile image) {
	// if (!(image.getContentType().equals("image/jpeg") ||
	// image.getContentType().equals("image/jpg"))) {
	// throw new RuntimeException("Only JPG images are accepted");
	// }
	// }

	// Stores image in 'C:\JeBOUQUINE_imgs' path
	private String saveImage(String filename, MultipartFile image, HttpServletRequest req)
			throws RuntimeException, IOException {
		try {
			// ! Here add Code to check for '..|\|/' and special chars for
			// security !

			// ServletConfig config = getServletConfig();
			// String contextName = config.getInitParameter("ApplicationName");
			// System.out.println("context name"+ contextName);
			// String contextPath =
			// config.getServletContext().getRealPath(contextName);
			String folder = "D:\\Libraries\\Documents\\GL\\GL4\\Frmwrks\\TPs\\SpringMVC_lest\\SpringMVC2\\src\\main\\webapp\\resources\\web\\images";
			String filepath = folder + "\\" + filename;
			// String filepath = "C:\\JeBOUQUINE_imgs\\" + filename;
			File file = new File(filepath);

			FileUtils.writeByteArrayToFile(file, image.getBytes());
			System.out.println("Go to :  " + file.toString() + " and verify that the image has been uploaded.");
			return filepath;
		} catch (IOException e) {
			throw e;
		}
	}

	//
	// @RequestMapping(value = {"/Authentification" }, method =
	// RequestMethod.GET)
	// public String FormulaireAuthentification(ModelMap model) {
	//// Client client = new Client();
	//// model.addAttribute("client", client);
	//// //model.addAttribute("edit", false);
	//// return "authentification";
	//// }
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