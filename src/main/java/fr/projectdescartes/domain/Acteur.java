package fr.projectdescartes.domain;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="acteur")
public class Acteur {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idActeur;
	
	@NotNull
	@Column(name="acteur_nom")
	private String nomComplet;

	@Column(name="acteur_photo")
	private String photoActeur;
	
	@ManyToMany(mappedBy = "acteurs")
	private Collection<Film> films;
	
	public Acteur() {
	}
	
	public Acteur(String nomActeur, String photoActeur, Collection<Film> films) {
		super();
		this.nomComplet = nomActeur;
		this.photoActeur = photoActeur;
		this.films = films;
	}
    
	public Long getIdActeur() {
		return idActeur;
	}
	public void setIdActeur(Long id) {
		this.idActeur = id;
	}

	/**
	 * @return the nomComplet
	 */
	public String getNomComplet() {
		return nomComplet;
	}

	/**
	 * @param nomComplet the nomComplet to set
	 */
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	/**
	 * @param films the films to set
	 */
	public void setFilms(Collection<Film> films) {
		this.films = films;
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
	public Collection<Film> getFilms() {
		return films;
	}

	/**
	 * @param oeuvres the oeuvres to set
	 */
	public void setOeuvres(Collection<Film> films) {
		this.films = films;
	}
}