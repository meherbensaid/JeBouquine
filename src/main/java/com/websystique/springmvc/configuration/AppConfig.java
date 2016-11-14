package com.websystique.springmvc.configuration;
 
import org.springframework.context.MessageSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.websystique.springmvc.dao.IRepositoryLivre;
import com.websystique.springmvc.service.ILivreService;
import com.websystique.springmvc.service.LivreService;
 
@Configuration
@ComponentScan(basePackages = "com.websystique.springmvc.*")
public class AppConfig {
      
     

//	 @Bean	
//	 public ILivreService livreService()
//	 {
//		 return (new LivreService());
//	 }
//	 @Bean	
//	 public IRepositoryLivre RepositoryLivreImpl()
//	 {
//		 return (new com.websystique.springmvc.dao.RepositoryLivreImpl());
//	 }
}