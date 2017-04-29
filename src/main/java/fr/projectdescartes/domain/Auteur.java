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
	private Long idAuteur;
	
	@NotNull
	@Column(name="auteur_nom")
	private String nomComplet;
	
	@ManyToMany(mappedBy = "auteurs")
	@JsonBackReference
    private Collection<Livre> oeuvres;
	
	
	public Auteur() {}
    
    public Auteur(String nom,  Collection<Livre> livres) {
		this.nomComplet = nom;
		this.oeuvres = livres;
	}

	
	public Long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Long idAuteur) {
		this.idAuteur = idAuteur;
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

	/**
	 * @param e
	 * @return
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean add(Livre e) {
		return oeuvres.add(e);
	}
}