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

import fr.projectdescartes.domain.Auteur;
import fr.projectdescartes.domain.Editeur;
import fr.projectdescartes.domain.Genre;
import fr.projectdescartes.domain.Livre;
import fr.projectdescartes.repository.LivreRepository;


@Component
@Controller
@RequestMapping(path="/book")
public class livreController {
	
	@Autowired 
	private LivreRepository livreRepository;
	
	@GetMapping(path= "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewBook (@RequestParam String titre, @RequestParam Date dateDeParution, @RequestParam String resume, @RequestParam String image
		,@RequestParam Collection<Genre> genres, @RequestParam Collection<Auteur> auteurs, @RequestParam Editeur editeur, @RequestParam Integer nbreDePages) {

	Livre l = new Livre();
	
	l.setAuteurs(auteurs);
	l.setDateDeParution(dateDeParution);
	l.setEditeur(editeur);
	l.setGenres(genres);
	l.setImage(image);
	l.setNbreDePages(nbreDePages);
	l.setResume(resume);
	l.setTitre(titre);

	livreRepository.save(l);
	
	return "SAVED" ;
	}
	
	@GetMapping(path="/search")
	public @ResponseBody Livre findOneFilm(@RequestParam Long id) {
	// This returns a JSON or XML with the users
	return livreRepository.findOne(id);
	}
	

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Livre> getAllLivre() {
	// This returns a JSON or XML with the users
		return livreRepository.findAll();
	}
	
	
}
