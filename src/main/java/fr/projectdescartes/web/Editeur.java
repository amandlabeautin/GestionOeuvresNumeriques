package fr.projectdescartes.web;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;
/**
 * 
 */
@Entity
public class Editeur {

	private long id;
	
	@Column(name="NOM_EDITEUR")
	private String nomEditeur;
	
	@OneToMany
    private Collection<Livre> livres;
	
	public Editeur() {	
	}
	
	public Editeur(String nomEditeur,Collection<Livre> livres) {
		this.nomEditeur = nomEditeur;
		this.livres = livres;
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

	/**
	 * @return the livres
	 */
	public Collection<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Collection<Livre> livres) {
		this.livres = livres;
	}
	
}