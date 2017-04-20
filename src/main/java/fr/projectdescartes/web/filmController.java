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

import fr.projectdescartes.domain.Acteur;
import fr.projectdescartes.domain.Film;


@Controller
public class filmController {

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
		
		Acteur acteur1 = new Acteur("Watson","Emma","https://image.tmdb.org/t/p/w640/eIVJZrG7zDOmSsmrR1Z3IkBkLbK.jpg",null);
		Acteur acteur2 = new Acteur("Stevens","Dan","https://image.tmdb.org/t/p/w640/jNiY649MK85UFMosJIDxJ9HgIsC.jpg",null);
		List<Acteur> acteurs = new ArrayList<Acteur>();
		acteurs.add(acteur1);
		acteurs.add(acteur2);
		
		String titreFilm = "La belle et la bete";
		String resume = "Une nouvelle adaptation live du conte \\\"La Belle et la Bête\\\". Belle, jeune fille rêveuse et passionnée de littérature, vit avec son père, un vieil inventeur farfelu. S'étant perdu une nuit dans la fôret, ce dernier se réfugie au château de la Bête, qui la jette au cachot. Ne pouvant supporter de voir son père emprisonné, Belle accepte alors de prendre sa place, ignorant que sous le masque du monstre se cache un Prince Charmant tremblant d'amour pour elle, mais victime d'une terrible malédiction.\\n";
		String image = "https://image.tmdb.org/t/p/w640/4RJaj2C4EZn1rCCTMwWGgv9ARUC.jpg";
		String duree = "2h 9m";
		return new Film(dateParution,titreFilm,resume,image,null, acteurs, null, duree, null);
	}
	
	@RequestMapping(value = "/film", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Film> obtenirUneListeDeFilms() throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Acteur acteur1 = new Acteur("Watson","Emma","https://image.tmdb.org/t/p/w640/eIVJZrG7zDOmSsmrR1Z3IkBkLbK.jpg", null);
		Acteur acteur2 = new Acteur("Stevens","Dan","https://image.tmdb.org/t/p/w640/jNiY649MK85UFMosJIDxJ9HgIsC.jpg", null);
		List<Acteur> acteursFilm1 = new ArrayList<Acteur>();
		acteursFilm1.add(acteur1);
		acteursFilm1.add(acteur2);
		String titreFilm1 = "La belle et la bete";
		String resume1 = "Une nouvelle adaptation live du conte \\\"La Belle et la Bête\\\". Belle, jeune fille rêveuse et passionnée de littérature, vit avec son père, un vieil inventeur farfelu. S'étant perdu une nuit dans la fôret, ce dernier se réfugie au château de la Bête, qui la jette au cachot. Ne pouvant supporter de voir son père emprisonné, Belle accepte alors de prendre sa place, ignorant que sous le masque du monstre se cache un Prince Charmant tremblant d'amour pour elle, mais victime d'une terrible malédiction.\\n";
		String image1 = "https://image.tmdb.org/t/p/w640/4RJaj2C4EZn1rCCTMwWGgv9ARUC.jpg";
		String duree1 = "2h 9m";
		Film film1 = new Film(dateFormat.parse("17/03/2017"),titreFilm1, resume1, image1, null, acteursFilm1,null,duree1, null);
		
		String titreFilm2 = "Rogue One - A Star Wars Story";
		String image2 = "https://image.tmdb.org/t/p/w640/mcwCNjqKUkebvknFkpj0UPdpSj.jpg";
		Acteur acteur3 = new Acteur("Jones","Felicity","https://image.tmdb.org/t/p/w640/9YekpRl6ndS7zpY0wwZAWcAXkl8.jpg", null);
		Acteur acteur4 = new Acteur("Luna","Diego","https://image.tmdb.org/t/p/w640/9f1y0pLqohP8U3eEVCa4di1tESb.jpg", null);
		List<Acteur> acteursFilm2 = new ArrayList<Acteur>();
		acteursFilm2.add(acteur3);
		acteursFilm2.add(acteur4);
		String resume2 = "Situé entre les épisodes III et IV de la saga Star Wars, le film nous entraîne aux côtés d’individus ordinaires qui, pour rester fidèles à leurs valeurs, vont tenter l’impossible au péril de leur vie. Ils n’avaient pas prévu de devenir des héros, mais dans une époque de plus en plus sombre, ils vont devoir dérober les plans de l’Étoile de la Mort, l’arme de destruction ultime de l’Empire.";
		String duree2 = "2h 13m";
		Film film2 = new Film(dateFormat.parse("14/12/2016"),titreFilm2, resume2, image2, null,acteursFilm2,null, duree2, null);
		
		List<Film> listes  = new  ArrayList<Film>();
		listes.add(film1);
		listes.add(film2);
		return listes;
	}
}
