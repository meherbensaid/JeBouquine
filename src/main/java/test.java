//import java.util.List;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.SystemPropertyUtils;
//
//import com.websystique.springmvc.configuration.AppConfig;
//import com.websystique.springmvc.model.Livre;
//import com.websystique.springmvc.service.ILivreService;
//
//
//
//public class test {
//
//	
//	@Transactional
//	public static void main(String [] args){
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//////	
//		ILivreService service = (ILivreService) context.getBean("livreService");
//		
//	List<Livre> L=service.FindCriteria("c", "", "hh", "cat");
//		
//	for (Livre livre : L) {
//		System.out.println(livre);
//	}
////		
////		
////		List<Livre> livres=new Vector<Livre>();
////    	livres=servicel.findAll();
////    	Livre L=new Livre();
////    	
////    	for (Livre livre2 : livres) {
////			if(livre2.getId()==4){
////				L=livre2;
////			}
////		}
////    	List<Commentaire> Liste=L.getCommentaires();
////		for (Commentaire commentaire : Liste) {
////			System.out.println(commentaire);
////		}
////		
////		
////		List<Commentaire> C2=new Vector<Commentaire>();
////		C2=service.findAll(); 
////		for (Commentaire commentaire : C2) {
////			System.out.println(commentaire);
////		}
////		List<Livre> livres=service.findAll();
////		for (Livre livre : livres) {
////			System.out.println(livre);
//////		}
////		Panier C=new Panier();
////		C.setPrix_total(888888);
////		List<Panier> Commandes=new Vector<Panier>();
////		Commandes.add(C);
////		
////		
//////		
//////		Auteur A=new Auteur();
//////		A.setNom("auteurrrr");
//////		List<Auteur> Auteurs=new Vector<Auteur>();
//////		Auteurs.add(A);
////		
//////		
////		List<Livre> livres=new Vector<Livre>();
////		Livre L=new Livre();
////		Livre L3=new Livre();
////		L3.setTitre("titre33333");
////		L.setTitre("titre22222");
////		livres.add(L);
////		livres.add(L3);
////		
////		for (Livre livre : livres) {
////			livre.setPaniers(Commandes);
////		}
////		
//////		C.setLivres(livres);
////////		L.setAuteurs(Auteurs);
//////		L.setPaniers(Commandes);
////		C.setLivres(livres);
////		service.create(C);
////	}
//
//	}}
