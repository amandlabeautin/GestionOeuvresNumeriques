package fr.projectdescartes.web;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity ;
import javax.persistence.ManyToMany;
/**
 * 
 */
@Entity
public class Film extends Oeuvre {


	@Column(name="DUREE_OEUVRE")
	private String duree;
	
	@Column(name="BANDE_ANNONCE")
	private String bandeAnnonce;
	
	@ManyToMany
    private Collection<Acteur> acteurs;
	
	public Film() {
		
	}
	
	/**
	 * @param idOeuvre
	 * @param dateDeParution
	 * @param titre
	 * @param resume
	 * @param image
	 * @param acteurs
	 * @param duree
	 * @param bandeAnnonce
	 * @param acteurs2
	 */
	public Film(Date dateDeParution, String titre, String resume, String image,
			Collection<Acteur> acteurs, String duree, String bandeAnnonce) {
		super(dateDeParution, titre, resume, image);
		this.duree = duree;
		this.bandeAnnonce = bandeAnnonce;
		this.acteurs = acteurs;
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