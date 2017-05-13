package fr.projectdescartes.web;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.projectdescartes.domain.Commande;
import fr.projectdescartes.domain.Oeuvre;
import fr.projectdescartes.domain.User;
import fr.projectdescartes.repository.CommandeRepository;

@Component
@Controller
@RequestMapping(path="/commandes")
public class CommandeController {
	
	@Autowired 
	private CommandeRepository repo;

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Commande> getAll() {
	// This returns a JSON or XML with the users
		return repo.findAll();
	}
	
	@GetMapping(path= "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewCommande (@RequestParam User user, @RequestParam Collection<Oeuvre> oeuvre) {
		
		Commande c = new Commande();
		c.setDateDeCommande(new Date());

		c.setOeuvres(oeuvre);
		c.setUser(user);
		
		try {
	        System.out.println(c.getOeuvres());
	        repo.save(c);
	        System.out.println("after save");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
		
		return "OK";
	}
	
	@GetMapping(path="/allCommandeForUser")
	public @ResponseBody List<Commande> login(@RequestParam User user) {
 		return repo.findByUserAndNotValidate(user);	
	}
}
