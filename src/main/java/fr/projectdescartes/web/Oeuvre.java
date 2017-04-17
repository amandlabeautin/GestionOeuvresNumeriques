package fr.projectdescartes.web;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public abstract class Oeuvre {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	Long idOeuvre;
	
	@Column(name = "DATE_DE_PARUTION")
	@Temporal(TemporalType.TIMESTAMP)
    Date dateDeParution;
	
	@Column(name="TITRE_OEUVRE")
    String titre;
	
	@Column(name="RESUME_OEUVRE")
    String resume;
    
    @ManyToMany
    private Collection<Acteur> acteurs ;
	
    public Oeuvre() {
	}
    
    public Oeuvre(String titre, Date dateDeParution, String resume) {
		super();
		this.titre = titre;
		this.dateDeParution = dateDeParution;
		this.resume = resume;
	}

    public Oeuvre(Long id, String titre, Date dateDeParution) {
		super();
		this.idOeuvre = id;
		this.titre = titre;
		this.dateDeParution = dateDeParution;
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
	 * @return the acteurs
	 */
	public Collection<Acteur> getActeurs() {
		return acteurs;
	}

	/**
	 * @param acteurs the acteurs to set
	 */
	public void setActeurs(Collection<Acteur> acteurs) {
		this.acteurs = acteurs;
	}
    
}