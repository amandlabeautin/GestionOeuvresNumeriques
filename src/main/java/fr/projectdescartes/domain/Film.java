package fr.projectdescartes.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity ;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * 
 */
@Entity
@Table(name="film")
public class Film extends Oeuvre {


	@Column(name="film_duree")
	private String duree;
	
	@Column(name="film_annonce")
	private String bandeAnnonce;
	
	@ManyToMany(mappedBy="films")
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
	public Film(Date dateDeParution, String titre, String resume, String image, Collection<Genre> genre,
			Collection<Acteur> acteurs, Collection<Telechargement> downloads, String duree, String bandeAnnonce) {
		super(dateDeParution, titre, resume, image, genre, downloads);
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