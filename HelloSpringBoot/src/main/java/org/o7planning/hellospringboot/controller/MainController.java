package org.o7planning.hellospringboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.o7planning.hellospringboot.form.PersonForm;
import org.o7planning.hellospringboot.model.AttachmentSendMail;
import org.o7planning.hellospringboot.model.Contact;
import org.o7planning.hellospringboot.model.ContactSendMail;
import org.o7planning.hellospringboot.model.Inscription;
import org.o7planning.hellospringboot.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	private static List<Person> persons = new ArrayList<Person>();
	private static String view = "attachment";
	private static int numDemande;

	static {
		persons.add(new Person("Bill", "Gates"));
		persons.add(new Person("Steve", "Jobs"));
	}

	private static List<String> formations = new ArrayList<String>();

	static {
		formations.add("DUT Genie Biologique");
		formations.add("Licence Analyste Programmeur");
		formations.add("Doctorat Physique Quantitque");
	}

	// Inject via application.properties
	@Value("${welcome.message}")
	private String welcomeMessage;

	@Value("${error.message}")
	private String errorMessage;

	// essais thymeLeaf tuto developper.com springmvc-thymeleaf.pdf page 137
//    Lorsqu'une vue est le résultat d'une action, Thymeleaf entre en oeuvre et interprète 
//    les attributs [th] avant l'envoi de la réponse au client.
	@RequestMapping(value = "/v01", method = RequestMethod.GET)
	public String v01() {
		return "v01";
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(@ModelAttribute("contact") Contact contact, Model model) {
		return "home";
	}

	@RequestMapping(value = "/formations", method = RequestMethod.GET)
	public String formations(@ModelAttribute("contact") Contact contact, Model model) {
		return "formations";
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String addInscription(@ModelAttribute("inscription") Inscription inscription,
			@ModelAttribute("contact") Contact contact, Model model) {
		model.addAttribute("formations", formations);
		return "formInscription";
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public String inscription(@Valid Inscription inscription, BindingResult results,
			@ModelAttribute("contact") Contact contact, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("messageError", String.format("Votre inscription ne nous est pas parvenu"));
			return "pageError";
		} else {
			numDemande++;
			// envoie du premier mail au demandeur de formation
			String from = "droffig@hotmail.com";
			String to = inscription.getEmailInscription();
			String sujet = "demande d'inscription";
			List<String> message = new ArrayList<String>();
			message.add(
					inscription.getCiviliteInscription() + " " + inscription.getNomInscription() + " " + inscription.getPrenomInscription());
			message.add("");
			message.add("Nous avons bien reçu votre demande d'inscription, <br>"
					+ "vous trouverez ci joint le formulaire à nous retourner <br>"
					+ "complété et signé à l'adresse suivante :");
			message.add("");
			message.add("CNAM HAUT DE FRANCE <br>"
					+ "8 rue de Luxembourg<br>"
					+ "62000 ARRAS< br>");
			message.add("");
			message.add("Cordialement,");
			message.add("");
			message.add("L'équipe du CNAM.");
			String filename="";
			AttachmentSendMail.sendMail(from, to, sujet, message, filename);
			// envoie du second mail au responsable de la formation
			List<String> content = new ArrayList<String>();
			content.add("Demande n°"+numDemande);
			content.add("");
			content.add(inscription.getCiviliteInscription() + " " + inscription.getNomInscription() + " " + inscription.getPrenomInscription());
			content.add("");
			content.add("Adresse : ");
			content.add(inscription.getAdresseInscription());
			content.add(inscription.getCpInscription()+" "+inscription.getVilleInscription());
			content.add("Mail : ");
			content.add(inscription.getEmailInscription());
			content.add("Tel : ");
			if(!"".equals(inscription.getTelInscription())) {
				content.add(inscription.getTelInscription());
			}else {
				content.add("aucun");
			}
			content.add("Diplome obtenu le plus élevé : "+inscription.getDiplomeObtenuInscription());
			content.add("Financement souhaité : "+inscription.getFinancemementFormation());
			content.add("formation demandée : "+inscription.getFormationSouhaiteInscription());
			ContactSendMail.envoyer(from, from, sujet, content);
			model.addAttribute("messageSuccess", String.format("Nous avon bien reçu votre message"));
			return "pageSuccess";
		}
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String contact(@Valid Contact contact, BindingResult results, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("messageError", String.format("Votre message ne nous est pas parvenu"));
			return "pageError";

		} else {
			String from = contact.getEmailContact();
			String to = "droffig@hotmail.com";
			String sujet = "demande de contact";
			List<String> message = new ArrayList<String>();
			message.add(
					contact.getCiviliteContact() + " " + contact.getNomContact() + " " + contact.getPrenomContact());
			message.add(contact.getMessageContact());
			ContactSendMail.envoyer(from, to, sujet, message);
			model.addAttribute("messageSuccess", String.format("Nous avon bien reçu votre message"));
			return "pageSuccess";
		}
	}

	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public String mail(HttpServletRequest request, @RequestParam(value = "send", required = false) String send,
			Model model) {

		String dataDirectory = request.getServletContext().getRealPath("/download/pdf/");

		Path file = Paths.get(dataDirectory, "git_memo_fr.pdf");
		if (Files.exists(file)) {
			if ("mail".equals(send)) {
				String[] data = new String[1];
				data[0] = dataDirectory + "git_memo_fr.pdf";
//				JavaSendMail.sendMail(data);
//				ContactSendMail.envoyer();
//				AttachmentSendMail.sendMail(data);
			}
		}
		return "mail";
	}

	@RequestMapping(value = "/fichier", method = RequestMethod.GET)
	public String fichier() {
		return "/fichier";
	}

	@RequestMapping(value = "vue/{typeFile}/{fileName:.+}", method = RequestMethod.GET)
	public String vuePDFRessource(HttpServletRequest request, @PathVariable("fileName") String fileName,
			@PathVariable("typeFile") String typeFile, Model model) {
		String dataDirectory = request.getServletContext().getRealPath("/download/" + typeFile + "/");

		Path file = Paths.get(dataDirectory, fileName);
		// changement de la variable view en vue de voir le pdf au lieu de le
		// telecharger
		view = "inline";

		if (Files.exists(file)) {
			return "redirect:/ressource/{typeFile}/{fileName}/";
		} else {
			model.addAttribute("message", "fichier non trouvé");
			return "/404";
		}
	}

	@RequestMapping(value = "telecharger/{typeFile}/{fileName:.+}", method = RequestMethod.GET)
	public String dowloadPDFRessource(HttpServletRequest request, @PathVariable("fileName") String fileName,
			@PathVariable("typeFile") String typeFile, Model model) {
		String dataDirectory = request.getServletContext().getRealPath("/download/" + typeFile + "/");

		Path file = Paths.get(dataDirectory, fileName);
		// changement de la variable view en vue de voir le pdf au lieu de le
		// telecharger
		view = "attachment";

		if (Files.exists(file)) {
			return "redirect:/ressource/{typeFile}/{fileName}/";
		} else {
			model.addAttribute("message", "fichier non trouvé");
			return "/404";
		}
	}

	@RequestMapping(value = "ressource/{typeFile}/{fileName:.+}/", method = RequestMethod.GET)
	public void Resource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName, @PathVariable("typeFile") String typeFile) {
		String dataDirectory = request.getServletContext().getRealPath("/download/" + typeFile + "/");

		Path file = Paths.get(dataDirectory, fileName);

		if (Files.exists(file)) {
			response.setContentType("application/pdf");
			System.out.println("view : " + view);
			response.addHeader("Content-Disposition", "" + view + "; filename=" + fileName);
			System.out.println("view 2 : " + view);
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("le fichier n'existe pas");
		}
	}

	@RequestMapping(value = "/langues", method = RequestMethod.GET)
	public String langues() {
		return "langues";
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
	public String savePerson(@ModelAttribute("personForm") PersonForm personForm, Model model) {

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
//	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
//	public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
//			Model model) {
//
//		model.addAttribute("welcomeMessage", welcomeMessage);
//		model.addAttribute("name", name);
//
//		SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
//		String heure = formater.format(new Date());
//		model.addAttribute("heure", heure);
//
//		return "index";
//	}	

}