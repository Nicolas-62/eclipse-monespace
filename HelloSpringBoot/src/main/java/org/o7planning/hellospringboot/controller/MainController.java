package org.o7planning.hellospringboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.hellospringboot.form.PersonForm;
import org.o7planning.hellospringboot.model.JavaSendMail;
import org.o7planning.hellospringboot.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value="/inscription", method = RequestMethod.GET)
    public String inscription() {
    	return "inscription";
    }
    @RequestMapping(value="/mail", method = RequestMethod.GET)
    public String mail(@RequestParam(value="send", required=false) String send, Model model) {
    	System.out.println("send : "+send);
    	if("mail".equals(send)) {
    		JavaSendMail.sendMail();
    	}
    	return "mail";
    }
    @RequestMapping(value="/fichier", method = RequestMethod.GET)
    public String fichier() {
    	return "/fichier";
    }
    @RequestMapping(value="vue/{typeFile}/{fileName:.+}", method = RequestMethod.GET)
    public String vuePDFRessource( HttpServletRequest request,
    		@PathVariable("fileName") String fileName, Model model)
    {
        String dataDirectory = request.getServletContext().getRealPath("/download/pdf/");
        System.out.println("directory : "+dataDirectory);
        Path file = Paths.get("/files/{typeFile}", fileName); 
        if(Files.exists(file)) {
        	System.out.println("visionné");
        	return "redirect:/files/{typeFile}/{fileName}";
        }
        else {
        	model.addAttribute("message", "fichier non trouvé");
        	return"/404";
        }

    }
    @RequestMapping(value="download/{fileName:.+}", method = RequestMethod.GET)
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response,
                                     @PathVariable("fileName") String fileName)
    {
        //If user is not authorized - he should be thrown out from here itself
         
        //Authorized user will download the file
        String dataDirectory = request.getServletContext().getRealPath("/download/pdf/");
        System.out.println("directory : "+dataDirectory);
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file))
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
        	System.out.println("le fichier n'existe pas");
        }
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