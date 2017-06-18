package fr.projectdescartes.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.projectdescartes.domain.Auteur;
import fr.projectdescartes.repository.AuteurRepository;
import fr.projectdescartes.domain.Livre;

@Component
@Controller
@RequestMapping(path="/auteurs")
public class auteurController {
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private AuteurRepository auteurRepository;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewAuteur (@RequestParam String name,@RequestParam(value="livres",required=false) Collection<Livre> livres) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Auteur a = new Auteur();
		
		a.setName(name);
		a.setOeuvres(livres);

		auteurRepository.save(a);
		
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Auteur> getAllAuteur() {
		// This returns a JSON or XML with the users
		return auteurRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
	}
	
	@RequestMapping(value = "/edit",method = {RequestMethod.PUT}) 
	public void editGenre(@RequestParam Auteur auteur) {
		auteurRepository.save(auteur);
		System.out.println("modifier : " + auteur);
	}
	
}
