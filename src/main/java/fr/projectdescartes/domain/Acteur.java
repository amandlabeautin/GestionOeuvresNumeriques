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
	private String nomActeur;
	
	@NotNull
	@Column(name="acteur_prenom")
	private String prenomActeur;

	@Column(name="acteur_photo")
	private String photoActeur;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "acteur_film", joinColumns = @JoinColumn(name = "acteur_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
	private Collection<Film> films;
	
	public Acteur() {
	}
	
	public Acteur(String nomActeur, String prenomActeur, String photoActeur, Collection<Film> films) {
		super();
		this.nomActeur = nomActeur;
		this.prenomActeur = prenomActeur;
		this.photoActeur = photoActeur;
		this.films = films;
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
	 * @return the prenomActeur
	 */
	public String getPrenomActeur() {
		return prenomActeur;
	}

	/**
	 * @param prenomActeur the prenomActeur to set
	 */
	public void setPrenomActeur(String prenomActeur) {
		this.prenomActeur = prenomActeur;
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