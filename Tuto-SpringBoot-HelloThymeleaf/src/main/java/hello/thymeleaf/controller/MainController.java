package hello.thymeleaf.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hello.thymeleaf.model.Form19;
import hello.thymeleaf.model.Personne;
import hello.thymeleaf.model.SecuredPerson;
import hello.thymeleaf.model.StringSecuredPerson;

@Controller
@SessionAttributes({ "jean", "paul" })
public class MainController {

	@RequestMapping(value = "/v01", method = RequestMethod.GET)
	public String v01() {
		return "v01";
	}

	@RequestMapping(value = "/v03", method = RequestMethod.GET)
	public String v03() {
		return "vue-v03";
	}

	@RequestMapping(value = "/v04", method = RequestMethod.GET)
	public String v04(Model model) {
		model.addAttribute("personne", new Personne(7, "martin", 17));
		System.out.println(String.format("modele=%s", model));
		return "vue-v04";

	}

	@RequestMapping(value = "/v05", method = RequestMethod.GET)
	public String v05(Model model) {
		model.addAttribute("personne", new Personne(7, "martin", 17));
		System.out.println(String.format("modele=%s", model));
		return "vue-v05";

	}

	@RequestMapping(value = "/v06", method = RequestMethod.GET)
	public String v06(Model model) {
		model.addAttribute("personne", new Personne(7, "martin", 17));
		System.out.println(String.format("modele=%s", model));
		return "vue-v06";

	}

	// création du modèle M d'une vue V - 4
	@RequestMapping(value = "/v07", method = RequestMethod.GET)
	public String v07(Model model) {
		model.addAttribute("liste", new Personne[] { new Personne(7, "martin", 17), new Personne(8, "lucie", 32),
				new Personne(9, "paul", 7) });
		return "vue-v07";
	}

	// --------------- Binding et ModelAttribute ----------------------------------
	// si le paramètre est un objet, il est instancié et éventuellement modifié par
	// les paramètres de la requête
	// il fera automatiquement partie du modèle de la vue avec la clé [key]
	// pour @ModelAttribute("xx") paramètre, key sera égal à xx
	// pour @ModelAttribute paramètre, key sera égal au nom de la classe du
	// paramètre commençant avec une minuscule
	// si @ModelAttribute est absent, alors tout se passe comme s'il était présent
	// sans clé
	// on notera que cette présence automatique dans le modèle n'est pas effectuée
	// si le paramètre n'est pas un objet
	@RequestMapping(value = "/v08", method = RequestMethod.GET)
	public String v08(@ModelAttribute("someone") Personne p, Model model) {
		System.out.println(String.format("Modèle=%s", model));
		return "vue-v08";
		// voir : http://localhost:8080/v08?id=4&nom=nico&age=17
	}

	@RequestMapping(value = "/v09", method = RequestMethod.GET)
	public String v09(Personne p, Model model) {
		System.out.println(String.format("Modèle=%s", model));
		return "vue-v09";
		// voir : http://localhost:8080/v08?id=4&nom=nico&age=17
	}

	// une méthode créant dans le modèle de chaque requête un élément de clé
	// [uneAutrePersonne]
	// associé à l'objet [new Personne(24,"pauline",55)] ;
	@ModelAttribute("uneAutrePersonne")
	private Personne getPersonne() {
		return new Personne(24, "pauline", 55);
	}

	// cette requete va recevoir dans son modele uneAutrePersonne
	@RequestMapping(value = "/v10", method = RequestMethod.GET)
	public String v10(Model model) {
		System.out.println(String.format("Modèle=%s", model));
		return "vue-v10";
	}

	@ModelAttribute("jean")
	private Personne getJean() {
		return new Personne(33, "jean", 10);
	}

	@RequestMapping(value = "/v11", method = RequestMethod.GET)
	public String v11(Model model, HttpSession session) {
		System.out.println(String.format("Modèle=%s, Session[jean]=%s", model, session.getAttribute("jean")));
		return "vue-v11";
		// la clé [jean] a été mise dans la session après l'exécution de l'action et
		// avant l'affichage de la vue.
	}

	@RequestMapping(value = "/v12a", method = RequestMethod.GET)
	@ResponseBody
	// requete qui se contente de mettre dans la session "paul"
	public void v12a(HttpSession session) {
		session.setAttribute("paul", new Personne(51, "paul", 33));
	}

	// cas où la clé de [@ModelAttribute] est également une clé de
	// [@SessionAttributes]
	// dans ce cas, le paramètre correspondant est initialisé avec la valeur de la
	// session
	@RequestMapping(value = "/v12b", method = RequestMethod.GET)
	public String v12b(Model model, @ModelAttribute("paul") Personne p) {
		System.out.println(String.format("Modèle=%s", model));
		return "vue-v12";
		/*
		 * Si on ne fait rien d'autre, un objet [Personne] est instancié puis initialisé
		 * avec les paramètres de la requête et cet objet n'a rien à voir avec l'objet
		 * de clé [paul] on ajoute donc paul en tête du controleur dans
		 * l'annotation @SessionAttributes
		 */
	}

	// génère un formulaire pour saisir une personne
	@RequestMapping(value = "/v13", method = RequestMethod.GET)
	public String v13() {
		return "vue-v13";
	}

	// traite les valeurs du formulaire
	@RequestMapping(value = "/v14", method = RequestMethod.POST)
	public String v14(Personne p) {
		return "vue-v14";
	}

	// ---------------------- affichage d'un formulaire
	@RequestMapping(value = "/v15", method = RequestMethod.GET)
	public String v15(@ModelAttribute("securedPerson") SecuredPerson p, Model model) {
		System.out.println(String.format("Modèle=%s", model));
		return "vue-v15";
	}

	// -------------------- validation d'un modèle------------------
	@RequestMapping(value = "/v16", method = RequestMethod.POST)
	public String v16(@Valid SecuredPerson p, BindingResult result) {
		// erreurs ?
		if (result.hasErrors()) {
			return "vue-v15";
		} else {
			return "vue-v16";
		}
	}

	// ---------------------- affichage d'un formulaire
	@RequestMapping(value = "/v17", method = RequestMethod.GET)
	public String v17(StringSecuredPerson p) {
		return "vue-v17";
	}

	// -------------------- validation d'un modèle------------------
	@RequestMapping(value = "/v18", method = RequestMethod.POST)
	public String v18(@Valid StringSecuredPerson p, BindingResult result) {
		// erreurs ?
		if (result.hasErrors()) {
			return "vue-v17";
		} else {
			return "vue-v18";
		}
	}

	// ------------------ affichage d'un formulaire
	@RequestMapping(value = "/v19", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String v19(Form19 formulaire) {
		return "vue-v19";
	}

	// ----------------- validation du modèle du formulaire
	@RequestMapping(value = "/v20", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String v20(@Valid Form19 formulaire, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "vue-v19";
		} else {
			// redirection vers [vue-19]
			redirectAttributes.addFlashAttribute("form19", formulaire);
			return "redirect:/vue-v19";
		}
	}
}