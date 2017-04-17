package fr.projectdescartes.web;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;


@Entity
public class Acteur {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idActeur;
	
	@Column(name="NOM_ACTEUR")
	private String nomActeur;
	
	@ManyToMany(mappedBy="acteurs")
	private Collection<Oeuvre> oeuvres;
	
	public Acteur() {
	}
	
	public Acteur(Long idActeur, String nomAuteur) {
		super();
		this.idActeur = idActeur;
		this.nomActeur = nomAuteur;
	}
    
	public Long getIdActeur() {
		return idActeur;
	}
	public void setIdActeur(Long id) {
		this.idActeur = id;
	}
	public String getNomActeur() {
		return nomActeur;
	}
	public void setNomActeur(String nomActeur) {
		this.nomActeur = nomActeur;
	}

	/**
	 * @return the oeuvres
	 */
	public Collection<Oeuvre> getOeuvres() {
		return oeuvres;
	}

	/**
	 * @param oeuvres the oeuvres to set
	 */
	public void setOeuvres(Collection<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}
	
	
}