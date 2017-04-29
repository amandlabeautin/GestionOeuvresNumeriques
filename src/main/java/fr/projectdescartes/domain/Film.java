package fr.projectdescartes.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity ;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 */
@Entity
@DiscriminatorValue(value="F")
public class Film extends Oeuvre {


	@Column(name="film_duree")
	private String duree;
	
	@Column(name="film_annonce")
	private String bandeAnnonce;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
    @JoinTable(name = "acteur_oeuvre", joinColumns = @JoinColumn(name = "oeuvre_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "acteur_id", referencedColumnName = "id"))
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