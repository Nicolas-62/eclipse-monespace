package hello.controllers;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hello.models.ActionModel01;
import hello.models.ActionModel02;
import hello.models.ActionModel03;
import hello.models.ApplicationModel;
import hello.models.Container;
import hello.models.Personne;
import hello.models.SessionModel;

@RestController
@SessionAttributes({ "container" }) // voir action "/m18"
public class ActionModelController {

	// ----------------------- récupérer des paramètre avec
	// GET------------------------
	@RequestMapping(value = "/m01", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String m01(String nom, String age) {
		return String.format("Hello [%s-%s]!, Greetings from Spring Boot!", nom, age);
	}

	// ----------------------- récupérer des paramètre avec
	// POST------------------------
	@RequestMapping(value = "/m02", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String m02(String nom, String age) {
		return String.format("Hello [%s-%s]!, Greetings from Spring Boot!", nom, age);
	}

	// ----------------------- récupérer des paramètres de mêmes
	// noms-----------------
	@RequestMapping(value = "/m03", produces = "text/plain;charset=UTF-8")
	public String m03(String nom[]) {
		return String.format("Hello [%s]!, Greetings from Spring Boot!", String.join("-", nom));
	}

	// ------ mapper les paramètres dans un objet (Command Object) ---------------
	@RequestMapping(value = "/m04", method = RequestMethod.POST)
	public Personne m04(Personne personne) {
		return personne;
	}

	// ----------------------- récupérer les éléments de l'URL
	// ------------------------
	@RequestMapping(value = "/m05/{a}/x/{b}", method = RequestMethod.GET)
	public Map<String, String> m05(@PathVariable("a") String a, @PathVariable("b") String b) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", a);
		map.put("b", b);
		return map;
	}

	// -------- récupérer des éléments de l'URL et des paramètres---------------
	// http://localhost:8080/m06/100/x/200.43/?c=300.1
	@RequestMapping(value = "/m06/{a}/x/{b}", method = RequestMethod.GET)
	public Map<String, Object> m06(@PathVariable("a") Integer a, @PathVariable("b") Double b, Double c) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", a);
		map.put("b", b);
		map.put("c", c);
		return map;
	}

	// ------ accéder à la requête HttpServletRequest ------------------------
	@RequestMapping(value = "/m07", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String m07(HttpServletRequest request) {
		// les entêtes HTTP
		Enumeration<String> headerNames = request.getHeaderNames();
		StringBuffer buffer = new StringBuffer();
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			buffer.append(String.format("%s : %s\n", name, request.getHeader(name)));
		}
		return buffer.toString();
	}

	// ----------------------- injection de writer ------------------------
	@RequestMapping(value = "/m08", method = RequestMethod.GET)
	public void m08(Writer writer) throws IOException {
		writer.write("Bonjour le monde !");
	}

	// ----------------------- injection de RequestHeader ------------------------
	@RequestMapping(value = "/m09", method = RequestMethod.GET)
	public String m09(@RequestHeader("User-Agent") String userAgent) {
		return userAgent;
	}

	// ----------------------- création de Cookie ------------------------
	@RequestMapping(value = "/m10", method = RequestMethod.GET)
	public void m10(HttpServletResponse response) {
		response.addCookie(new Cookie("cookie1", "remember me"));
	}

	// ----------------------- injection de Cookie ------------------------
	@RequestMapping(value = "/m11", method = RequestMethod.GET)
	public String m10(@CookieValue("cookie1") String cookie1) {
		return cookie1;
	}

	// ----------- récupérer le corps d'un POST de type
	// String------------------------
	@RequestMapping(value = "/m12", method = RequestMethod.POST)
	public String m12(@RequestBody String requestBody) {
		return requestBody;
	}

	// ----------------------- récupérer le corps jSON d'un POST (post de forme json
	// : {id:"1", nom:"nico", age:"24"}
	@RequestMapping(value = "/m13", method = RequestMethod.POST, consumes = "application/json")
	public String m13(@RequestBody Personne personne) {
		return personne.toString();
	}

	// ----------------------- récupérer le corps jSON d'un POST 2
	// -------------------
	@RequestMapping(value = "/m14", method = RequestMethod.POST, consumes = "text/plain")
	public String m14(@RequestBody String requestBody) throws JsonParseException, JsonMappingException, IOException {
		Personne personne = new ObjectMapper().readValue(requestBody, Personne.class);
		return personne.toString();
	}

	// ----------------------- récupérer la session ------------------------
	@RequestMapping(value = "/m15", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String m15(HttpSession session) {
		// on récupère l'objet de clé [compteur] dans la session
		Object objCompteur = session.getAttribute("compteur");
		// on le convertit en entier pour l'incrémenter
		int iCompteur = objCompteur == null ? 0 : (Integer) objCompteur;
		iCompteur++;
		// on le remet dans la session
		session.setAttribute("compteur", iCompteur);
		// on le rend comme résultat de l'action
		return String.valueOf(iCompteur);
	}

	@Autowired
	private SessionModel session;

	// ------ gérer un objet de portée (scope) session [Autowired] -----------
	@RequestMapping(value = "/m16", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String m16() {
		session.setCompteur(session.getCompteur() + 1);
		return String.valueOf(session.getCompteur());
	}

	/*
	 * on injecte le composant [ApplicationModel] dans le contrôleur. C'est un
	 * singleton. Donc chaque utilisateur aura une référence sur le même objet
	 */
	@Autowired
	private ApplicationModel application;

	// ----- gérer un objet de portée application [Autowired]
	// ------------------------
	@RequestMapping(value = "/m17", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String m17() {
		return String.valueOf(application.getCompteur().incrementAndGet());
	}

	// utilisation de [@SessionAttribute] ----------------------
	@RequestMapping(value = "/m18", method = RequestMethod.GET)
	public void m18(HttpSession session) {
		// ici on met la clé [container] dans la session
		session.setAttribute("container", new Container());
	}

	// utilisation de [@ModelAttribute] ----------------------
	/*
	 * Le paramètre [container] de cette annotation peut désigner diverses choses et
	 * en particulier un objet de la session. Il faut pour cela que celui-ci ait été
	 * déclaré avec une annotation [@SessionAttributes] sur la classe elle-même
	 */
	// la clé [container] de la session (créée avec l'action "/m18") sera ici
	// injectée
	@RequestMapping(value = "/m19", method = RequestMethod.GET)
	public String m19(@ModelAttribute("container") Container container) {
		container.setCompteur(1 + container.getCompteur());
		return String.valueOf(container.getCompteur());
	}

	// l'attribut p fera partie de tous les modèles [Model] de vue ----------------
	// Un modèle se comporte comme un dictionnaire de couples [clé, valeur]. Ici, la
	// clé [p] est
	// associée à l'objet [Personne]
	@ModelAttribute("p")
	public Personne getPersonne() {
		return new Personne(7, "abcd", 14);
	}

	// ---------------instanciation de @ModelAttribute --------------------------
	// sera injecté s'il est dans la session
	// sera injecté si le contrôleur a défini une méthode pour cet attribut (comme
	// ici)
	// peut provenir des champs de l'URL s'il existe un convertisseur String -->
	// type de l'attribut
	// sinon est construit avec le constructeur par défaut
	// ensuite les attributs du modèle sont initialisés avec les paramètres du GET
	// ou du POST
	// le résultat final fera partie du modèle produit par l'action

	// l'attribut p est injecté dans les arguments------------------------
	@RequestMapping(value = "/m20", method = RequestMethod.GET)
	public Personne m20(@ModelAttribute("p") Personne personne) {
		return personne;
	}

	// --------- l'attribut p fait automatiquement partie du modèle M de la vue V
	@RequestMapping(value = "/m21", method = RequestMethod.GET)
	public String m21(Model model) {
		return model.toString(); // retourne une entrée p(clé) ayant pour valeur :
		// {p=[id=7, nom=abcd, age=14]}
	}

	// --------- l'attribut de modèle [param1] fait partie du modèle mais est non
	// initialisé
	@RequestMapping(value = "/m22", method = RequestMethod.GET)
	public String m22(@ModelAttribute("param1") String p1, Model model) {
		return model.toString();
		// localhost:8080/m22?p1=x ->
		// {p=[id=7, nom=abcd, age=14], param1=, retour de toString()}
	}

	// --------- l'attribut de modèle [param2] est mis explicitement dans le modèle
	@RequestMapping(value = "/m23", method = RequestMethod.GET)
	public String m23(String p2, Model model) {
		model.addAttribute("param2", p2);
		return model.toString();
		// localhost:8080/m22?p2=x ->
		// {p=[id=7, nom=abcd, age=14], param2=y}
	}

	// ------ l'attribut de modèle [ unePersonne ] est automatiquement mis dans le
	// modèle
	@RequestMapping(value = "/m23b", method = RequestMethod.GET)
	public String m23b(@ModelAttribute("unePersonne") Personne p1, Model model) {
		return model.toString();
		// l'annotation [@ModelAttribute("unePersonne") Personne p1] a mis la personne
		// [p1]
		// dans le modèle, associée à la clé [unePersonne].

	}

	// ----------------------- validation d'un modèle ------------------------
	@RequestMapping(value = "/m24", method = RequestMethod.GET)
	public Map<String, Object> m24(@Valid ActionModel01 data, BindingResult result) {
		/*
		 * L'annotation [@Valid] indique que les contraintes de validité doivent être
		 * vérifiées. Les résultats de cette vérification seront placés dans le
		 * paramètre de type [BindingResult] (second paramètre). Sans l'annotation
		 * [@Valid], les erreurs de validation provoquent un plantage de l'action et le
		 * serveur envoie au client une réponse HTTP avec un statut 500 (Internal server
		 * error).
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		// des erreurs ?
		if (result.hasErrors()) {
			StringBuffer buffer = new StringBuffer();
			// parcours de la liste des erreurs
			for (FieldError error : result.getFieldErrors()) {
				buffer.append(String.format("[%s:%s:%s:%s:%s]", error.getField(), error.getRejectedValue(),
						String.join(" - ", error.getCodes()), error.getCode(), error.getDefaultMessage()));
			}
			map.put("errors", buffer.toString());
		} else {
			// pas d'erreurs
			Map<String, Object> mapData = new HashMap<String, Object>();
			mapData.put("a", data.getA());

			mapData.put("b", data.getB());
			map.put("data", mapData);
		}
		return map;
	}

	// validation d'un modèle, gestion des messages d'erreur
	// ------------------------
	@RequestMapping(value = "/m25", method = RequestMethod.GET)
	public Map<String, Object> m25(@Valid ActionModel01 data, BindingResult result, HttpServletRequest request)
			throws Exception {
		// le dictionnaire des résultats
		Map<String, Object> map = new HashMap<String, Object>();
		// le contexte de l'application Spring
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		// locale
		Locale locale = RequestContextUtils.getLocale(request);
		// des erreurs ?
		if (result.hasErrors()) {
			StringBuffer buffer = new StringBuffer();
			for (FieldError error : result.getFieldErrors()) {
				// recherche du msg d'erreur à parir des codes d'erreur
				// le msg est cherché dans les fichiers de messages
				// les codes d'erreur sous forme de tableau
				String[] codes = error.getCodes();
				// sous forme de chaîne
				String listCodes = String.join(" - ", codes);
				// recherche
				String msg = null;
				int i = 0;
				while (msg == null && i < codes.length) {
					try {
						msg = ctx.getMessage(codes[i], null, locale);
					} catch (Exception e) {

					}
					i++;
				}
				// a-t-on trouvé ?
				if (msg == null) {
					throw new Exception(String.format("Indiquez un message pour l'un des codes [%s]", listCodes));
				}
				// on a trouvé - on ajoute le msg d'erreur à la chaîne des msg d'erreur
				buffer.append(String.format("[%s:%s:%s:%s]", locale.toString(), error.getField(),
						error.getRejectedValue(), String.join(" - ", msg)));
			}
			map.put("errors", buffer.toString());
		} else {
			// ok
			Map<String, Object> mapData = new HashMap<String, Object>();
			mapData.put("a", data.getA());
			mapData.put("b", data.getB());
			map.put("data", mapData);
		}
		return map;
	}

	// La locale peut être directement injectée dans les paramètres de l'action.
	// Voici un exemple :
	@RequestMapping(value = "/m26", method = RequestMethod.GET)
	public String m26(Locale locale) {
		return String.format("locale=%s", locale.toString());
	}

	// validation d'un modèle avec Hibernate Validator ------------------------
	@RequestMapping(value = "/m27", method = RequestMethod.POST)
	public Map<String, Object> m27(@Valid ActionModel02 data, BindingResult result) {
		Map<String, Object> map = new HashMap<String, Object>();
		// des erreurs ?
		if (result.hasErrors()) {
			// parcours de la liste des erreurs
			for (FieldError error : result.getFieldErrors()) {
				map.put(error.getField(), String.format("[message=%s, codes=%s]", error.getDefaultMessage(),
						String.join("|", error.getCodes())));
			}
		} else {
			// pas d'erreurs
			map.put("data", data);
		}
		return map;
	}

	// ----------------------- externalisation des messages d'erreur
	// ------------------------
	@RequestMapping(value = "/m28", method = RequestMethod.POST)
	public Map<String, Object> m28(@Valid ActionModel03 data, BindingResult result, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		// le contexte de l'application Spring
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		// locale
		Locale locale = RequestContextUtils.getLocale(request);
		// des erreurs ?

		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				// recherche du msg d'erreur à parir des codes d'erreur
				// le msg est cherché dans les fichiers de messages
				// les codes d'erreur sous forme de tableau
				String[] codes = error.getCodes();
				// sous forme de chaîne
				String listCodes = String.join(" - ", codes);
				// recherche
				String msg = null;
				int i = 0;
				while (msg == null && i < codes.length) {
					try {
						msg = ctx.getMessage(codes[i], null, locale);
					} catch (Exception e) {

					}
					i++;
				}
				// a-t-on trouvé ?
				if (msg == null) {
					msg = String.format("Indiquez un message pour l'un des codes [%s]", listCodes);
				}
				// on a trouvé - on ajoute l'erreur au dictionnaire
				map.put(error.getField(), msg);
			}
		} else {
			// pas d'erreurs
			map.put("data", data);
		}
		return map;
	}
}