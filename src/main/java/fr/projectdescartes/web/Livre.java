package fr.projectdescartes.web;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Livre extends Oeuvre {

	@Column(name="NBRE_DE_PAGES")
    Integer nbreDePages;
	
	Editeur editeur;
	
	Auteur auteur;

	public Livre() {
		
	}
	
    public Livre(String titre, Date dateDeParution, String resume, Integer nbreDePages, String image, Editeur editeur, Auteur auteur) {
    	super(dateDeParution, titre, resume, image);
		this.nbreDePages = nbreDePages;
		this.editeur = editeur;
		this.auteur = auteur;
	}

	public Integer getNbreDePages() {
		return nbreDePages;
	}
	public void setNbreDePages(Integer nbreDePages) {
		this.nbreDePages = nbreDePages;
	}
	
	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", résumé ="
				+ resume + ", nombre de pages =" + nbreDePages + "]";
	}

}