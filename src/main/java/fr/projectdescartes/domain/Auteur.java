package fr.projectdescartes.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
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
	private String nom;
	
	@NotNull
	@Column(name="auteur_prenom")
	private String prenom;
	
	@OneToMany
    private Collection<Livre> livres;
	
	
	public Auteur() {}
    
    public Auteur(String nom, String prenom, Collection<Livre> livres) {
		this.nom = nom;
		this.prenom = prenom;
		this.livres = livres;
	}

	
	public Long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Long idAuteur) {
		this.idAuteur = idAuteur;
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.Collection#add(java.lang.Object)
	 */

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	
	public boolean add(Livre e) {
		return livres.add(e);
	}
}