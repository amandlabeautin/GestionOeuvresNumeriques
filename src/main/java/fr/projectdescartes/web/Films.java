package fr.projectdescartes.web;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity ;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 */
@Entity
public class Films extends Oeuvre {

	private Long idFilms;
	private Long duree;
	private String bandeAnnonce;
	
    Collection<Acteur> acteurs;
	
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

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdFilms() {
		return idFilms;
	}

	public void setIdFilms(Long idFilms) {
		this.idFilms = idFilms;
	}

}