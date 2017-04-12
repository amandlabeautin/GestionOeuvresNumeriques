package fr.projectdescartes.web;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Oeuvre {

    Date dateDeParution;
    
    long idOeuvre;
    String titre;
    String resume;
	

    
    public Oeuvre() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    public Oeuvre(String titre, Date dateDeParution, String resume) {
		super();
		this.titre = titre;
		this.dateDeParution = dateDeParution;
		this.resume = resume;
	}

    public Oeuvre(long id, String titre, Date dateDeParution) {
		super();
		this.idOeuvre = id;
		this.titre = titre;
		this.dateDeParution = dateDeParution;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdOeuvre() {
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
    
}