package fr.projectdescartes.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.projectdescartes.domain.Genre;
import fr.projectdescartes.domain.GenreRepository;

@Component
@Controller
@RequestMapping(path="/genre")
public class genreController {
	
	@Autowired 
	private GenreRepository genreRepository;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewGenre (@RequestParam String name) {

		Genre g = new Genre();
		
		g.setNomGenre(name);
		
		genreRepository.save(g);
		
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Genre> getAllGenre() {
		// This returns a JSON or XML with the books
		return genreRepository.findAll();
	}
	
}
