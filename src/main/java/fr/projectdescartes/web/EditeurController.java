package fr.projectdescartes.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.projectdescartes.domain.Editeur;
import fr.projectdescartes.domain.EditeurRepository;
import fr.projectdescartes.domain.Livre;

@Component
@Controller
@RequestMapping(path="/editeur")
public class EditeurController {
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private EditeurRepository editeurRepository;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam Collection<Livre> livres) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Editeur e = new Editeur();
		
		e.setNomEditeur(name);
		e.setLivres(livres);
		
		editeurRepository.save(e);
		
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Editeur> getAllUsers() {
		// This returns a JSON or XML with the users
		return editeurRepository.findAll();
	}
	
}
