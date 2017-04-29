package fr.projectdescartes.web;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.projectdescartes.domain.Acteur;
import fr.projectdescartes.domain.Film;
import fr.projectdescartes.domain.FilmRepository;
import fr.projectdescartes.domain.Genre;


@Component
@Controller
@RequestMapping(path="/film")
public class filmController {
	
	@Autowired 
	private FilmRepository filmRepository;
	
	@GetMapping(path= "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewFilm (@RequestParam String titre, @RequestParam Date dateDeParution, @RequestParam String resume, @RequestParam String image
		, @RequestParam String filmDuree, @RequestParam String filmAnnonce, @RequestParam Collection<Acteur> acteurs, @RequestParam Collection<Genre> genres) {

	Film f = new Film();
	
	f.setDateDeParution(dateDeParution);
	f.setDuree(filmDuree);
	f.setTitre(titre);
	f.setActeurs(acteurs);
	f.setBandeAnnonce(filmAnnonce);
	f.setImage(image);
	f.setGenres(genres);
	f.setResume(resume);
	
	filmRepository.save(f);
	
	return "SAVED" ;
	}
	
	@GetMapping(path="/search")
	public @ResponseBody Film findOneFilm(@RequestParam Long id) {
	// This returns a JSON or XML with the users
	return filmRepository.findOne(id);
	}
	
	@GetMapping(path="/delete")
	public @ResponseBody void deleteFilm(@RequestParam Film film) {
	// This returns a JSON or XML with the users
		filmRepository.delete(film);
	}
	

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Film> getAllFilm() {
	// This returns a JSON or XML with the users
		return filmRepository.findAll();
	}
	
	
}
