package fr.projectdescartes.domain;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 */
@Entity
@Table(name="editeur")
public class Editeur {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long idEditeur;
	
	@NotNull
	@Column(name="editeur_nom")
	private String name;
	
	@OneToMany(mappedBy = "editeur", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonManagedReference("oeuvre_editeur")
    private Collection<Livre> oeuvres;
	
	public Editeur() {	
	}
	
	public Editeur(String name,Collection<Livre> livres) {
		this.name = name;
		this.oeuvres = livres;
	}
	
	public long getId() {
		return idEditeur;
	}
	public void setId(long id) {
		this.idEditeur = id;
	}
	public String getNomEditeur() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the livres
	 */
	public Collection<Livre> getLivres() {
		return oeuvres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Collection<Livre> livres) {
		this.oeuvres = livres;
	}
	
}