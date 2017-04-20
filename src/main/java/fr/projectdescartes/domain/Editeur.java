package fr.projectdescartes.domain;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
/**
 * 
 */
@Entity
@Table(name="editeur")
public class Editeur {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column(name="editeur_nom")
	private String nomEditeur;
	
	@OneToMany(mappedBy = "editeur", cascade = CascadeType.ALL)
    private Collection<Livre> livres;
	
	public Editeur() {	
	}
	
	public Editeur(String nomEditeur,Collection<Livre> livres) {
		this.nomEditeur = nomEditeur;
		this.livres = livres;
	}
	
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