package fr.projectdescartes.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@DiscriminatorValue(value="L")
public class Livre extends Oeuvre {

	@Column(name="livre_nbreDePages")
    Integer nbreDePages;
	
	@ManyToOne
	@JoinColumn(name = "editeur_id")
	@JsonBackReference("oeuvre_editeur") 
	Editeur editeur;
	
	@NotNull
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auteur_oeuvre", joinColumns = @JoinColumn(name = "oeuvre_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "auteur_id", referencedColumnName = "id"))
	Collection<Auteur> auteurs;

	public Livre() {
		
	}
	
    public Livre(String titre, Date dateDeParution, String resume, Integer nbreDePages, String image, Collection<Genre> genre,
    		Editeur editeur,  Collection<Commande> downloads, Collection<Auteur> auteurs) {
    	super(dateDeParution, titre, resume, image, genre, downloads);
		this.nbreDePages = nbreDePages;
		this.editeur = editeur;
		this.auteurs = auteurs;
	}

	public Integer getNbreDePages() {
		return nbreDePages;
	}
	public void setNbreDePages(Integer nbreDePages) {
		this.nbreDePages = nbreDePages;
	}
	
	/**
	 * @return the editeur
	 */
	public Editeur getEditeur() {
		return editeur;
	}

	/**
	 * @param editeur the editeur to set
	 */
	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}


	/**
	 * @param e
	 * @return
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean add(Auteur e) {
		return auteurs.add(e);
	}

	/**
	 * @return the auteurs
	 */
	public Collection<Auteur> getAuteurs() {
		return auteurs;
	}

	/**
	 * @param auteurs the auteurs to set
	 */
	public void setAuteurs(Collection<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", résumé ="
				+ resume + ", nombre de pages =" + nbreDePages + "]";
	}

}