package fr.projectdescartes;

import java.util.*;
import javax.persistence.Entity ; 
import javax.persistence.Id ; 
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;
/**
 * 
 */
@Entity
public class Editeur {

	long id;
	String nomEditeur;
	
	public Editeur(long id, String nomEditeur) {
		super();
		this.id = id;
		this.nomEditeur = nomEditeur;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomEditeur() {
		return nomEditeur;
	}
	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}
	

}