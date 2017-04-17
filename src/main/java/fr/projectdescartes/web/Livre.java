package fr.projectdescartes.web;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Livre extends Oeuvre {

	@Column(name="NBRE_DE_PAGES")
    Integer nbreDePages;

	public Livre() {
		
	}
	
    public Livre(String titre, Date dateDeParution, String resume, Integer nbreDePages) {
		super(titre, dateDeParution, resume);
		this.nbreDePages = nbreDePages;
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