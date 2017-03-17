package fr.projectdescartes;

import java.util.*;
import javax.persistence.Entity ; 
import javax.persistence.Id ; 
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;


@Entity
public class Telechargement {

	private long id;
	private Date dateDeTelechargement;

	public Telechargement() {
		super();
	}
	
	public Telechargement(long id, Date dateDeTelechargement) {
		super();
		this.id = id;
		this.dateDeTelechargement = dateDeTelechargement;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateDeTelechargement() {
		return dateDeTelechargement;
	}

	public void setDateDeTelechargement(Date dateDeTelechargement) {
		this.dateDeTelechargement = dateDeTelechargement;
	}

}