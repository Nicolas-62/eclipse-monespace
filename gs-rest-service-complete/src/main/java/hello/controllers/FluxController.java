package hello.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.models.Personne;

@RestController
public class FluxController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/a01")
	public String a01() {
		return "Salut les nouilles";
	}

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new String(String.format(template, name));
	}

	@RequestMapping(value = "/helloXml", method = RequestMethod.GET, produces = "text/xml;charset=UTF-8")
	public String helloXml(@RequestParam(value = "name", defaultValue = "XML") String name) {
		return new String(String.format(template, name));
	}

	@RequestMapping(value = "/personne")
	public Personne peronne() {
		return new Personne(1, "Carole", 45);
	}

	@RequestMapping(value = "/envoieHtml", produces = "text/html;charset=UTF-8")
	public String helloHtml(@RequestParam(value = "name", defaultValue = "Fabrice") String name) {
		return new String("<h1> Hello HTML "+name+"</h1>");
	}
}
