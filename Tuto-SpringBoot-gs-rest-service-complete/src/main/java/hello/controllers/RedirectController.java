package hello.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {

	@RequestMapping("/a10")
	public String a10() {
		return "a01";
	}

	// ------------ redirection temporaire 302 vers une action
	// tierce----------------
	@RequestMapping("/a11")
	public String a11() {
		return "redirect:/a01";
	}

	// ------------ redirection permanente 301 vers une action
	// tierce----------------

	@RequestMapping(value = "/a12", method = RequestMethod.GET)
	public void a12(HttpServletResponse response) {
		response.setStatus(301);
		response.addHeader("Location", "/a01");
	}

	// ----------------------- génération complète de la réponse
	// ------------------------
	@RequestMapping(value = "/a13")
	public void a13(HttpServletResponse response) throws IOException {
		response.setStatus(666);
		response.addHeader("header1", "qq chose");
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		String greeting = "<h1>Greetings from Spring Boot!</h1>";
		response.getWriter().write(greeting);
	}
}
