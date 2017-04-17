package fr.projectdescartes.web;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity ;
/**
 * 
 */
@Entity
public class Film extends Oeuvre {

	@Column(name="DUREE_OEUVRE")
	private String duree;
	
	@Column(name="BANDE_ANNONCE")
	private String bandeAnnonce;
	
    private Collection<Acteur> acteurs;
	
	public Film() {
		
	}
	
    public Film(String titre, Date dateDeParution, String resume, String duree, String bandeAnnonce) {
		super(titre, dateDeParution, resume);
		this.duree = duree;
		this.bandeAnnonce = bandeAnnonce;
	}

	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getBandeAnnonce() {
		return bandeAnnonce;
	}
	public void setBandeAnnonce(String bandeAnnonce) {
		this.bandeAnnonce = bandeAnnonce;
	}
	
	public Collection<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(Collection<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	@Override
	public String toString() {
		return "Film [titre=" + titre + ", résumé ="
				+ resume + ", durée =" + duree + "]";
	}

}