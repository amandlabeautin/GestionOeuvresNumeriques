package fr.projectdescartes.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.projectdescartes.domain.Genre;
import fr.projectdescartes.domain.GenreRepository;
import fr.projectdescartes.domain.Oeuvre;

@Component
@Controller
@RequestMapping(path="/genre")
public class genreController {
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private GenreRepository genreRepository;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewGenre (@RequestParam String name, @RequestParam Collection<Oeuvre> oeuvres) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Genre g = new Genre();
		
		g.setNomGenre(name);
		g.setOeuvres(oeuvres);
		
		genreRepository.save(g);
		
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Genre> getAllGenre() {
		// This returns a JSON or XML with the books
		return genreRepository.findAll();
	}
	
}
