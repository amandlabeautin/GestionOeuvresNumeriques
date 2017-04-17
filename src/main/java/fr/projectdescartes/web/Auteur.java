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
public class Auteur {

	private Long idAuteur;
	
	@Column(name="NOM_AUTEUR")
	private String nomAuteur;
	
	@OneToMany
    private Collection<Livre> livres;
    
    public Auteur(String nomAuteur, Collection<Livre> livres) {
		this.nomAuteur = nomAuteur;
		this.livres = livres;
	}

	public Auteur() {
	}
    
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Long idAuteur) {
		this.idAuteur = idAuteur;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
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