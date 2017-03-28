package fr.projectdescartes.web;


import java.util.Date;

import javax.persistence.Entity ;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 */
@Entity
public class Livre extends Oeuvre {

	private Long idLivre;
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

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Long idLivre) {
		this.idLivre = idLivre;
	} 

}