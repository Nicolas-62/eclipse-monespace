/**
 * 
 */
package com.cnam.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cnam.demo.model.Produit;
import com.cnam.demo.model.Utilisateur;
import com.cnam.demo.repository.ProduitRepository;
import com.cnam.demo.repository.UtilisateurRepository;





/**
 * Class qui permet de g�rer la page index et /
 * 
 * @author dell
 *
 */
@Controller
public class IndexController {
	
	@Autowired // sert à creer une instance voir pattern singleton
	UtilisateurRepository utilisateurRepository;
	@Autowired
	ProduitRepository produitRepository;
	
	/**
	 * Cette m�thode permet de capter un GEt de le page 
	 * http://loacalhost:8080/ ou http://loacalhost:8080/index
	 * 
	 * @param name
	 * @param utilisateur
	 * @param model
	 * @return le nom de page html index
	 */
	@GetMapping("/")
	public String home(Model model) {

		model.addAttribute("msg_accueil", String.format("Bienvenue sur notre site" ));

		return "index";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		Utilisateur unUtilisateur = new Utilisateur();


		unUtilisateur.setCgu(true);
		unUtilisateur.setDateNaissance(new Date());
		unUtilisateur.setNom("bouhadoun");
		unUtilisateur.setPrenom("kamel");
		unUtilisateur.setEmail("kamel.bouhadoun+2@gmail.com");
		utilisateurRepository.save(unUtilisateur);
		
		Produit unProduit = new Produit();
		unProduit.setNom("couches_culotte");
		unProduit.setQtite(12);
		unProduit.setPrix(20d);
		produitRepository.save(unProduit);
		
		model.addAttribute("msg_accueil", String.format("Nom client : "+unUtilisateur.getNom()+
					" Nom produit : "+ unProduit.getNom()));

		return "index";
	}

}
