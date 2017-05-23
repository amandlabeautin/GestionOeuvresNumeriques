package fr.projectdescartes.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.projectdescartes.domain.Download;
import fr.projectdescartes.domain.Oeuvre;
import fr.projectdescartes.domain.User;
import fr.projectdescartes.repository.DownloadRepository;

@Component
@Controller
@RequestMapping(path="/commandes")
public class DownloadController {
	
	@Autowired 
	private DownloadRepository repo;

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Download> getAll() {
	// This returns a JSON or XML with the users
		return repo.findAll();
	}
	
	@GetMapping(path= "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewCommande (@RequestParam User user, @RequestParam Oeuvre oeuvre) {
		
		Download c = new Download();
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
	public @ResponseBody List<Download> login(@RequestParam User user) {
 		return repo.findByUserAndNotValidate(user);	
	}
	
	@GetMapping(path="/update")
	public @ResponseBody Download update(@RequestParam Long idCommande, @RequestParam Long idOeuvre) {
		Download c = repo.findById(idCommande, idOeuvre);	
 		c.setIsdownload(true);
 		c.setIsvalidate(true);
 		c.setDateDeTelechargement(new Date());
 		
 		return c;
	}
}
