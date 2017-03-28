package fr.projectdescartes.web;

import java.util.*;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;


@Entity
public abstract class Oeuvre {

    private long id;
    private String titre;
    private Date dateDeParution;
    private String resume;
	
    @ManyToMany
    private Collection<Acteur> acteurs;
    
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
		this.id = id;
		this.titre = titre;
		this.dateDeParution = dateDeParution;
	}
    
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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