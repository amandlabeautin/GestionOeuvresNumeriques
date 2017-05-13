package fr.projectdescartes.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;
/**
 * 
 */
@Entity
public class Auteur {
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(name="auteur_nom")
	private String name;
	
	@ManyToMany(mappedBy = "auteurs")
	@JsonBackReference
    private Collection<Livre> oeuvres;
	
	
	public Auteur() {
		super();
	}
    
    public Auteur(String name,  Collection<Livre> livres) {
    	super();
		this.name = name;
		this.oeuvres = livres;
	}

	/**
	 * @return the idAuteur
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param idAuteur the idAuteur to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the oeuvres
	 */
	public Collection<Livre> getOeuvres() {
		return oeuvres;
	}

	/**
	 * @param oeuvres the oeuvres to set
	 */
	public void setOeuvres(Collection<Livre> oeuvres) {
		this.oeuvres = oeuvres;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Auteur [idAuteur=" + id + ", name=" + name + ", oeuvres=" + oeuvres + "]";
	}
}