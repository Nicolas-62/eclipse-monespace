package org.o7planning.hellospringboot.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.o7planning.hellospringboot.form.PersonForm;
import org.o7planning.hellospringboot.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
 
    private static List<Person> persons = new ArrayList<Person>();
 
    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }
 
    // Inject via application.properties
    @Value("${welcome.message}")
    private String welcomeMessage;
 
    @Value("${error.message}")
    private String errorMessage;
    
    // essais thymeLeaf tuto developper.com springmvc-thymeleaf.pdf page 137
//    Lorsqu'une vue est le résultat d'une action, Thymeleaf entre en oeuvre et interprète 
//    les attributs [th] avant l'envoi de la réponse au client.
    @RequestMapping(value="/v01", method = RequestMethod.GET)
    public String v01() {
    	return "v01";
    }
    
    @RequestMapping(value="/langues", method = RequestMethod.GET)
    public String langues() {
    	return "langues";
    }
 
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, 
    		Model model) {
    	
        model.addAttribute("welcomeMessage", welcomeMessage);
        model.addAttribute("name", name);
        
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
        String heure = formater.format(new Date());
        model.addAttribute("heure", heure);
 
        return "index";
    }
    
//    il est préférable d'utiliser des annotations spécialisées @GetMapping, @PostMapping..
//    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    @GetMapping("/personList")
    public String personList(Model model) {
 
        model.addAttribute("persons", persons);
 
        return "personList";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
 
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
 
        return "addPerson";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
//    @ModelAttribute Supported for controller classes with @RequestMapping methods.
    public String savePerson(@ModelAttribute("personForm") PersonForm personForm,
    		Model model) {
 
        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();
 
        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0) {
            Person newPerson = new Person(firstName, lastName);
            persons.add(newPerson);
 
            return "redirect:/personList";
        }
 
        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }
 
}