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
	private Long id;
	
	@NotNull
	@Column(name="acteur_nom")
	private String name;

	@Column(name="acteur_photo")
	private String photo;
	
	@ManyToMany(mappedBy = "acteurs")
	private Collection<Film> films;
	
	public Acteur() {
	}
	
	public Acteur(String name, String photo, Collection<Film> films) {
		super();
		this.name = name;
		this.photo = photo;
		this.films = films;
	}
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nomComplet
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param nomComplet the nomComplet to set
	 */
	public void setName(String name) {
		this.name = name;
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
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photoActeur the photoActeur to set
	 */
	public void setPhotoActeur(String photo) {
		this.photo = photo;
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