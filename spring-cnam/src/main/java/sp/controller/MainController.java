package sp.controller;

import org.springframework.web.bind.annotation.RequestParam;

import sp.model.Utilisateur;
import sp.repository.UtilisateurRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;

    @GetMapping("/")
    public String home(@RequestParam(value="name", defaultValue="Inconnu") String name, @ModelAttribute Utilisateur utilisateur, Model model) {
    	
    	model.addAttribute("msg_accueil", String.format("Bienvenue, %s !", name));
    	
        return "index";
    }
    @GetMapping("/rechercher")
    public String rechercher(@RequestParam(value="name", defaultValue="Inconnu") String name, @ModelAttribute Utilisateur utilisateur, Model model) {
    	
    	model.addAttribute("msg_accueil", String.format("Bienvenue, %s !", name));
    	
        return "recherche";
    }
    
    @PostMapping("/rechercherUser")
    public String rechercherUser(@Valid @ModelAttribute Utilisateur utilisateur, BindingResult bindingResult, Model model) {
    	
//    	if (bindingResult.hasErrors()) {
//    		return "index";
//    	}
    	
    	 List<Utilisateur> itr = (List<Utilisateur>) utilisateurRepository.findByNom(utilisateur.getNom());
    	 Utilisateur unUtilisateurTrouve = itr.get(0);
    	
    	System.out.print(itr.get(0));
    	model.addAttribute("user", unUtilisateurTrouve);
    	
    	return "resultat";
    }
    
    @PostMapping("/adduser")
    public String postUser(@Valid @ModelAttribute Utilisateur utilisateur, BindingResult bindingResult, Model model) {
    	
    	if (bindingResult.hasErrors()) {
    		return "index";
    	}
    	
    	utilisateurRepository.save(utilisateur);
    	
    	model.addAttribute("user", utilisateur);
    	
    	return "confirmation";
    }
}
