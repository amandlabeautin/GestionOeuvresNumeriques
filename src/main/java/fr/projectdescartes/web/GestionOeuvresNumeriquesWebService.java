package fr.projectdescartes.web;

import java.text.DateFormat;
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
		System.out.println("modifier Livre: " + livre);
	}
	
	@RequestMapping(value = "/livre/{titre}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void supprimerLivre(@PathVariable(value="titre") String titre){
		System.out.println("supprimerLivre: " + titre);
	}
	
	@RequestMapping(value = "/livre/{titre}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Livre obtenirUnLivre(@PathVariable(value="titre") String titre) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateParution = dateFormat.parse("01/02/2014");
		return new Livre("50nuancesdeGrey", dateParution, "Anastasia Steele, étudiante en littérature, a accepté la proposition de son amie journaliste de prendre sa place pour interviewer Christian Grey", 560); 
	}
	
	@RequestMapping(value = "/livre", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Livre> obtenirUneListeDeLivres() throws ParseException{
		List<Livre> listes  = new  ArrayList<Livre>();
		listes.add(new Livre("50 nuances de sombres", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"), "Anastasia Steele, étudiante en littérature, a accepté la proposition de son amie journaliste de prendre sa place pour interviewer Christian Grey", 500));
		listes.add(new Livre("50 nuances de claires", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2016"), "Anastasia Steele, étudiante en littérature, a accepté la proposition de son amie journaliste de prendre sa place pour interviewer Christian Grey", 460));
		return listes;
	}
	@RequestMapping(value = "/film", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void creerFilm(@RequestBody Film film) {
		System.out.println("creerLivre: " + film);
	}
	
	@RequestMapping(value = "/film", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void modifierFilm(@RequestBody Film film){
		System.out.println("modifier Film: " + film);
	}
	
	@RequestMapping(value = "/film/{titre}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void supprimerFilm(@PathVariable(value="titre") String titre){
		System.out.println("supprimerFilm: " + titre);
	}
	
	@RequestMapping(value = "/film/{titre}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Film obtenirUnFilm(@PathVariable(value="titre") String titre) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateParution = dateFormat.parse("17/03/2017");
		return new Film("La belle et la bete", dateParution, "Une nouvelle adaptation live du conte \"La Belle et la Bête\". Belle, jeune fille rêveuse et passionnée de littérature, vit avec son père, un vieil inventeur farfelu. S'étant perdu une nuit dans la fôret, ce dernier se réfugie au château de la Bête, qui la jette au cachot. Ne pouvant supporter de voir son père emprisonné, Belle accepte alors de prendre sa place, ignorant que sous le masque du monstre se cache un Prince Charmant tremblant d'amour pour elle, mais victime d'une terrible malédiction.\n", "2h 9m", null);
	}
	
	@RequestMapping(value = "/film", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Film> obtenirUneListeDeFilms() throws ParseException{
		List<Film> listes  = new  ArrayList<Film>();
		listes.add(new Film("La belle et la bete", new SimpleDateFormat("dd/MM/yyyy").parse("17/03/2017"), "Une nouvelle adaptation live du conte \"La Belle et la Bête\". Belle, jeune fille rêveuse et passionnée de littérature, vit avec son père, un vieil inventeur farfelu. S'étant perdu une nuit dans la fôret, ce dernier se réfugie au château de la Bête, qui la jette au cachot. Ne pouvant supporter de voir son père emprisonné, Belle accepte alors de prendre sa place, ignorant que sous le masque du monstre se cache un Prince Charmant tremblant d'amour pour elle, mais victime d'une terrible malédiction.\n", "2h 9m", null));
		listes.add(new Film("Rogue One - A Star Wars Story", new SimpleDateFormat("dd/MM/yyyy").parse("14/12/2016"), "Situé entre les épisodes III et IV de la saga Star Wars, le film nous entraîne aux côtés d’individus ordinaires qui, pour rester fidèles à leurs valeurs, vont tenter l’impossible au péril de leur vie. Ils n’avaient pas prévu de devenir des héros, mais dans une époque de plus en plus sombre, ils vont devoir dérober les plans de l’Étoile de la Mort, l’arme de destruction ultime de l’Empire.", "2h 13m", null));
		return listes;
	}
}
