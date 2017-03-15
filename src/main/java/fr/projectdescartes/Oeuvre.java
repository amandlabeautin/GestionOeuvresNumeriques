package fr.projectdescartes;

import java.util.*;
import javax.persistence.Entity ; 
import javax.persistence.Id ; 
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;


@Entity
public class Oeuvre {

    long id;
    String titre;
    Date dateDeParution;
    String resume;
	
    public Oeuvre(long id, String titre, Date dateDeParution, String resume) {
		super();
		this.id = id;
		this.titre = titre;
		this.dateDeParution = dateDeParution;
		this.resume = resume;
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