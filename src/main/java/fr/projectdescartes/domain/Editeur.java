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
	private String nomEditeur;
	
	@OneToMany(mappedBy = "editeur", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonManagedReference("oeuvre_editeur")
    private Collection<Livre> oeuvres;
	
	public Editeur() {	
	}
	
	public Editeur(String nomEditeur,Collection<Livre> livres) {
		this.nomEditeur = nomEditeur;
		this.oeuvres = livres;
	}
	
	public long getId() {
		return idEditeur;
	}
	public void setId(long id) {
		this.idEditeur = id;
	}
	public String getNomEditeur() {
		return nomEditeur;
	}
	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
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