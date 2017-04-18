package fr.projectdescartes.web;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public abstract class Oeuvre {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	Long idOeuvre;
	
	@Column(name = "DATE_DE_PARUTION")
	@Temporal(TemporalType.DATE)
    Date dateDeParution;
	
	@Column(name="TITRE_OEUVRE")
    String titre;
	
	@Column(name="RESUME_OEUVRE")
    String resume;
	
	@Column(name="IMAGE_OEUVRE")
	String image;
	
    public Oeuvre() {
	}
    
	public Oeuvre(Date dateDeParution, String titre, String resume, String image) {
		this.dateDeParution = dateDeParution;
		this.titre = titre;
		this.resume = resume;
		this.image = image;
	}

	public Long getIdOeuvre() {
		return idOeuvre;
	}

	public void setIdOeuvre(long id) {
		this.idOeuvre = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateDeParution() {
		return dateDeParution;
	}

	public void setDateDeParution(Date dateDeParution) {
		this.dateDeParution = dateDeParution;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
    
}