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
		Auteur auteur = new Auteur("E.L. James", null);
		Editeur editeur = new Editeur("Lgf", null);
		
		return new Livre("Cinquantes nuances de Grey", dateParution, "Anastasia Steele, étudiante en littérature, a accepté la proposition de son amie journaliste de prendre sa place pour interviewer Christian Grey", 560, "http://static.fnac-static.com/multimedia/Images/FR/NR/e0/28/54/5515488/1507-1/tsp20140108103057/Cinquante-nuances-de-Grey.jpg", editeur, auteur); 
	}
	
	@RequestMapping(value = "/livre", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Livre> obtenirUneListeDeLivres() throws ParseException{
		Auteur auteur = new Auteur("E.L. James", null);
		Editeur editeur = new Editeur("Lgf", null);
		
		List<Livre> listes  = new  ArrayList<Livre>();
		listes.add(new Livre("50 nuances de sombres", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"), "Anastasia Steele, étudiante en littérature, a accepté la proposition de son amie journaliste de prendre sa place pour interviewer Christian Grey", 500, "http://static.fnac-static.com/multimedia/Images/FR/NR/b4/49/56/5654964/1507-1/tsp20140108103057/Cinquante-nuances-plus-sombres.jpg", editeur, auteur));
		listes.add(new Livre("50 nuances de claires", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2016"), "Anastasia Steele, étudiante en littérature, a accepté la proposition de son amie journaliste de prendre sa place pour interviewer Christian Grey", 460, "http://static.fnac-static.com/multimedia/Images/FR/NR/9d/8f/56/5672861/1507-1/tsp20140305100037/Cinquante-nuances-plus-claires.jpg", editeur, auteur));
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
		
		Acteur acteur1 = new Acteur("Emma Watson","https://image.tmdb.org/t/p/w640/eIVJZrG7zDOmSsmrR1Z3IkBkLbK.jpg");
		Acteur acteur2 = new Acteur("Dan Stevens","https://image.tmdb.org/t/p/w640/jNiY649MK85UFMosJIDxJ9HgIsC.jpg");
		List<Acteur> acteurs = new ArrayList<Acteur>();
		acteurs.add(acteur1);
		acteurs.add(acteur2);
		
		String titreFilm = "La belle et la bete";
		String resume = "Une nouvelle adaptation live du conte \\\"La Belle et la Bête\\\". Belle, jeune fille rêveuse et passionnée de littérature, vit avec son père, un vieil inventeur farfelu. S'étant perdu une nuit dans la fôret, ce dernier se réfugie au château de la Bête, qui la jette au cachot. Ne pouvant supporter de voir son père emprisonné, Belle accepte alors de prendre sa place, ignorant que sous le masque du monstre se cache un Prince Charmant tremblant d'amour pour elle, mais victime d'une terrible malédiction.\\n";
		String image = "https://image.tmdb.org/t/p/w640/4RJaj2C4EZn1rCCTMwWGgv9ARUC.jpg";
		String duree = "2h 9m";
		return new Film(dateParution,titreFilm,resume,image,acteurs, duree, null);
	}
	
	@RequestMapping(value = "/film", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Film> obtenirUneListeDeFilms() throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Acteur acteur1 = new Acteur("Emma Watson","https://image.tmdb.org/t/p/w640/eIVJZrG7zDOmSsmrR1Z3IkBkLbK.jpg");
		Acteur acteur2 = new Acteur("Dan Stevens","https://image.tmdb.org/t/p/w640/jNiY649MK85UFMosJIDxJ9HgIsC.jpg");
		List<Acteur> acteursFilm1 = new ArrayList<Acteur>();
		acteursFilm1.add(acteur1);
		acteursFilm1.add(acteur2);
		String titreFilm1 = "La belle et la bete";
		String resume1 = "Une nouvelle adaptation live du conte \\\"La Belle et la Bête\\\". Belle, jeune fille rêveuse et passionnée de littérature, vit avec son père, un vieil inventeur farfelu. S'étant perdu une nuit dans la fôret, ce dernier se réfugie au château de la Bête, qui la jette au cachot. Ne pouvant supporter de voir son père emprisonné, Belle accepte alors de prendre sa place, ignorant que sous le masque du monstre se cache un Prince Charmant tremblant d'amour pour elle, mais victime d'une terrible malédiction.\\n";
		String image1 = "https://image.tmdb.org/t/p/w640/4RJaj2C4EZn1rCCTMwWGgv9ARUC.jpg";
		String duree1 = "2h 9m";
		Film film1 = new Film(dateFormat.parse("17/03/2017"),titreFilm1, resume1, image1, acteursFilm1,duree1, null);
		
		String titreFilm2 = "Rogue One - A Star Wars Story";
		String image2 = "https://image.tmdb.org/t/p/w640/mcwCNjqKUkebvknFkpj0UPdpSj.jpg";
		Acteur acteur3 = new Acteur("Felicity Jones","https://image.tmdb.org/t/p/w640/9YekpRl6ndS7zpY0wwZAWcAXkl8.jpg");
		Acteur acteur4 = new Acteur("Diego Luna","https://image.tmdb.org/t/p/w640/9f1y0pLqohP8U3eEVCa4di1tESb.jpg");
		List<Acteur> acteursFilm2 = new ArrayList<Acteur>();
		acteursFilm2.add(acteur3);
		acteursFilm2.add(acteur4);
		String resume2 = "Situé entre les épisodes III et IV de la saga Star Wars, le film nous entraîne aux côtés d’individus ordinaires qui, pour rester fidèles à leurs valeurs, vont tenter l’impossible au péril de leur vie. Ils n’avaient pas prévu de devenir des héros, mais dans une époque de plus en plus sombre, ils vont devoir dérober les plans de l’Étoile de la Mort, l’arme de destruction ultime de l’Empire.";
		String duree2 = "2h 13m";
		Film film2 = new Film(dateFormat.parse("14/12/2016"),titreFilm2, resume2, image2, acteursFilm2,duree2, null);
		
		List<Film> listes  = new  ArrayList<Film>();
		listes.add(film1);
		listes.add(film2);
		return listes;
	}
}
