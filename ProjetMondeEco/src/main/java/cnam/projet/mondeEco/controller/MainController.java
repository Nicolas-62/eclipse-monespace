package cnam.projet.mondeEco.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cnam.projet.mondeEco.model.AttachmentSendMail;
import cnam.projet.mondeEco.model.Contact;
import cnam.projet.mondeEco.model.ContactSendMail;
import cnam.projet.mondeEco.model.CreateFormInscription;
import cnam.projet.mondeEco.model.Inscription;

@Controller
public class MainController {

	// variable pour l'envoie du pdf : attachment = télécharger, inline = visionner
	private static String view = "attachment";
	// variable pour compter le nombre de demande de formulaire d'inscription
	private static int numDemande;
	// variable contenant la liste des formations proposées à selectionner dans le
	// formulaire de demande d'inscription
	private static List<String> formations = new ArrayList<String>();
	static {
		formations.add("Master Finance");
		formations.add("DUT Analyste Programmeur");
	}

	/*
	 * Affiche la page d'accueil
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(@ModelAttribute("contact") Contact contact, Model model) {
		return "home";
	}

	/*
	 * Envoie la page contenant les formations et les liens vers les pdf des
	 * plaquettes de formation
	 */
	@RequestMapping(value = "/formations", method = RequestMethod.GET)
	public String formations(@ModelAttribute("contact") Contact contact, Model model) {
		return "formations";
	}

	/*
	 * Envoie la page contenant le formulaire d'inscription
	 */
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscription(@ModelAttribute("inscription") Inscription inscription,
			@ModelAttribute("contact") Contact contact, Model model) {
		model.addAttribute("formations", formations);
		return "formInscription";
	}

	/*
	 * Vérifie le formulaire d'inscription posté, si validé : Envoie un mail au
	 * demandeur avec en piece jointe le formulaire d'inscription Envoie un mail à
	 * l'administrateur avec les données du demandeur si non validé : renvoie la
	 * page contenant le formulaire d'inscription avec les erreurs
	 */
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public String addInscription(@Valid Inscription inscription, BindingResult results, HttpServletRequest request,
			@ModelAttribute("contact") Contact contact, Model model) {
		if (results.hasErrors()) {
//			model.addAttribute("messageError", String.format("Votre inscription ne nous est pas parvenu"));
			return "formInscription";
		} else {
			numDemande++;

			// création du formulaire d'inscription en pdf.
			String pdfName = "formulaire_" + numDemande + ".pdf";
			String imgName = "logo2.jpeg";
			String dataDirectory = request.getServletContext().getRealPath("/img/");
			String pathOfImg = dataDirectory + imgName;
			dataDirectory = request.getServletContext().getRealPath("/pdf_inscription/");
			String pathOfPdf = dataDirectory + pdfName;
			String[] args = { pathOfPdf, pathOfImg, inscription.getCiviliteInscription(),
					inscription.getNomInscription(), inscription.getPrenomInscription(),
					inscription.getAdresseInscription(), inscription.getVilleInscription(),
					inscription.getCpInscription(), inscription.getDiplomeObtenuInscription(),
					inscription.getFormationSouhaiteInscription() };
			CreateFormInscription.createPdf(args);

			// envoie du premier mail au demandeur de formation avec le pdf créé
			String from = "droffig@hotmail.com";
			String to = inscription.getEmailInscription();
			String sujet = "demande d'inscription";
			List<String> message = new ArrayList<String>();
			message.add(inscription.getCiviliteInscription() + " " + inscription.getNomInscription() + " "
					+ inscription.getPrenomInscription());
			message.add("");
			message.add("Nous avons bien reçu votre demande d'inscription, <br>"
					+ "vous trouverez ci joint le formulaire à nous retourner <br>"
					+ "complété et signé à l'adresse suivante :");
			message.add("");
			message.add("LKRT HAUT DE FRANCE <br>" + "8 rue des alouettes<br>" + "5900 LILLE<br>");
			message.add("");
			message.add("Cordialement,");
			message.add("");
			message.add("L'équipe de LKRT.");
			AttachmentSendMail.sendMail(from, to, sujet, message, pathOfPdf);

			// envoie du second mail au responsable de la formation
			List<String> content = new ArrayList<String>();
			content.add("Demande n°" + numDemande);
			content.add("");
			content.add(inscription.getCiviliteInscription() + " " + inscription.getNomInscription() + " "
					+ inscription.getPrenomInscription());
			content.add("");
			content.add("Adresse : ");
			content.add(inscription.getAdresseInscription());
			content.add(inscription.getCpInscription() + " " + inscription.getVilleInscription());
			content.add("Mail : ");
			content.add(inscription.getEmailInscription());
			content.add("Tel : ");
			if (inscription.getTelInscription().length() != 0) {
				content.add(inscription.getTelInscription());
			} else {
				content.add("aucun");
			}
			content.add("Diplome obtenu le plus élevé : " + inscription.getDiplomeObtenuInscription());
			content.add("Financement souhaité : " + inscription.getFinancemementFormation());
			content.add("formation demandée : " + inscription.getFormationSouhaiteInscription());
			ContactSendMail.envoyer(from, from, sujet, content);
			model.addAttribute("messageSuccess", String.format("Nous avon bien reçu votre message"));
			return "pageSuccess";
		}
	}

	/*
	 * Vérifie le formulaire de contact posté, envoie un mail à l'administrateur
	 * avec le contenu du formulaire si validé sinon affiche une page d'erreur
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String contact(@Valid Contact contact, BindingResult results, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("messageError", String.format("Votre message ne nous est pas parvenu"));
			return "pageError";

		} else {
			String from = "droffig@hotmail.com";
			String to = "droffig@hotmail.com";
			String sujet = "demande de contact";
			List<String> message = new ArrayList<String>();
			message.add(
					contact.getCiviliteContact() + " " + contact.getNomContact() + " " + contact.getPrenomContact());
			message.add("Adresse mail : " + contact.getEmailContact());
			message.add(contact.getMessageContact());
			ContactSendMail.envoyer(from, to, sujet, message);
			model.addAttribute("messageSuccess", String.format("Nous avon bien reçu votre message"));
			return "pageSuccess";
		}
	}

	/*
	 * Affiche le pdf demandé dans le navigateur, pour cela redirige ver le
	 * controleur : Ressource
	 */
	@RequestMapping(value = "vue/{typeFile}/{fileName:.+}", method = RequestMethod.GET)
	public String vuePDFRessource(HttpServletRequest request, @PathVariable("fileName") String fileName,
			@PathVariable("typeFile") String typeFile, Model model) {
		// verification de l'existance du fichier demandé
		// chemin des ressources : /src/main/webapp/download/...
		String dataDirectory = request.getServletContext().getRealPath("/download/" + typeFile + "/");
		Path file = Paths.get(dataDirectory, fileName);
		// changement de la variable view en vue de voir le pdf au lieu de le
		// telecharger
		view = "inline";
		if (Files.exists(file)) {
			return "redirect:/ressource/{typeFile}/{fileName}";
		} else {
			model.addAttribute("message", "fichier non trouvé");
			return "/404";
		}
	}

	/*
	 * Lance le téléchargement du pdf demandé , pour cela redirige ver le controleur
	 * : Ressource
	 */
	@RequestMapping(value = "telecharger/{typeFile}/{fileName:.+}", method = RequestMethod.GET)
	public String dowloadPDFRessource(HttpServletRequest request, @PathVariable("fileName") String fileName,
			@PathVariable("typeFile") String typeFile, Model model) {
		// verification de l'existance du fichier demandé
		// chemin des ressources : /src/main/webapp/download/...
		String dataDirectory = request.getServletContext().getRealPath("/download/" + typeFile + "/");

		Path file = Paths.get(dataDirectory, fileName);
		// changement de la variable view en vue de voir le pdf au lieu de le
		// telecharger
		view = "attachment";

		if (Files.exists(file)) {
			return "redirect:/ressource/{typeFile}/{fileName}";
		} else {
			model.addAttribute("message", "fichier non trouvé");
			return "/404";
		}
	}

	/*
	 * Renvoie le document demandé suivant sont type, et la demande (visionnage,
	 * téléchargement).
	 */
	@RequestMapping(value = "/ressource/{typeFile}/{fileName:.+}", method = RequestMethod.GET)
	public void Resource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName, @PathVariable("typeFile") String typeFile) {
		// chemin des ressources : /src/main/webapp/download/...
		String dataDirectory = request.getServletContext().getRealPath("/download/" + typeFile + "/");

		Path file = Paths.get(dataDirectory, fileName);

		if (Files.exists(file)) {
			response.setContentType("application/pdf");
			System.out.println("view : " + view);
			response.addHeader("Content-Disposition", "" + view + "; filename=" + fileName);
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

}