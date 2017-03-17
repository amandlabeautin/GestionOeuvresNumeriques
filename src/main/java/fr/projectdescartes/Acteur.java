package fr.projectdescartes;

import java.util.*;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;
/**
/**
 * 
 */
@Entity
public class Acteur {

	private Long idActeur;
	private String nomAuteur;
	
	@ManyToMany(mappedBy="acteurs")
	private Collection<Oeuvre> oeuvres;
	
	public Acteur(Long idActeur, String nomAuteur) {
		super();
		this.idActeur = idActeur;
		this.nomAuteur = nomAuteur;
	}
    
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return idActeur;
	}
	public void setId(Long id) {
		this.idActeur = id;
	}
	public String getNomAuteur() {
		return nomAuteur;
	}
	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}
}