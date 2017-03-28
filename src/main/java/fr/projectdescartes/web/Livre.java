package fr.projectdescartes.web;


import java.util.Date;

import javax.persistence.Entity ;
/**
 * 
 */
@Entity
public class Livre extends Oeuvre {

    private Integer nbreDePages;

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

}