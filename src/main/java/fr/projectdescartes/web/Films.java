package fr.projectdescartes.web;

import java.util.Date;

import javax.persistence.Entity ;
/**
 * 
 */
@Entity
public class Films extends Oeuvre {

	private Long duree;
	private String bandeAnnonce;
	
	public Films(String titre, Date dateDeParution, String resume, Long duree, String bandeAnnonce) {
		super(titre, dateDeParution, resume);
		this.duree = duree;
		this.bandeAnnonce = bandeAnnonce;
	}

	public long getDuree() {
		return duree;
	}
	public void setDuree(Long duree) {
		this.duree = duree;
	}
	public String getBandeAnnonce() {
		return bandeAnnonce;
	}
	public void setBandeAnnonce(String bandeAnnonce) {
		this.bandeAnnonce = bandeAnnonce;
	}

}