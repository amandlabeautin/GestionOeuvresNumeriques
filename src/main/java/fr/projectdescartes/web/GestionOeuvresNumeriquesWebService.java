package fr.projectdescartes.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class GestionOeuvresNumeriquesWebService {

	@RequestMapping(value = "/livre", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void creerLivre(@RequestBody Livre livre) {
		System.out.println("creerLivre: " + livre);
	}
	
	@RequestMapping(value = "/livre", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void modifierLivre(@RequestBody Livre livre){
		System.out.println("modifierLivre: " + livre);
	}
	
	@RequestMapping(value = "/livre/{numLivre}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void supprimerLivre(@PathVariable(value="numLivre") String numLivre){
		System.out.println("supprimerLivre: " + numLivre);
	}
	
	@RequestMapping(value = "/livre/{titre}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Livre obtenirUnLivre(@PathVariable(value="titre") String titre) throws ParseException{
		Date dateParution = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2014");
		return new Livre("50 nuances de Grey", dateParution, "Anastasia Steele, étudiante en littérature, a accepté la proposition de son amie journaliste de prendre sa place pour interviewer Christian Grey", 560); 
	}
	
	@RequestMapping(value = "/livre", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Livre> obtenirUneListeDeVoitures() throws ParseException{
		List<Livre> listes  = new  ArrayList<Livre>();
		listes.add(new Livre("50 nuances de sombres", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"), "Anastasia Steele, étudiante en littérature, a accepté la proposition de son amie journaliste de prendre sa place pour interviewer Christian Grey", 560));
		listes.add(new Livre("50 nuances de claires", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2016"), "Anastasia Steele, étudiante en littérature, a accepté la proposition de son amie journaliste de prendre sa place pour interviewer Christian Grey", 560));
		return listes;
	}
}
