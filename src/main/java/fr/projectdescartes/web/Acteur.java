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
	Long idActeur;
	
	@Column(name="NOM_ACTEUR")
	private String nomActeur;

	@Column(name="PHOTO_ACTEUR")
	private String photoActeur;
	
	@ManyToMany(mappedBy="acteurs")
	private Collection<Oeuvre> oeuvres;
	
	public Acteur() {
	}
	
	public Acteur(String nomActeur, String photoActeur) {
		super();
		this.nomActeur = nomActeur;
		this.photoActeur = photoActeur;
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
	 * @return the photoActeur
	 */
	public String getPhotoActeur() {
		return photoActeur;
	}

	/**
	 * @param photoActeur the photoActeur to set
	 */
	public void setPhotoActeur(String photoActeur) {
		this.photoActeur = photoActeur;
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