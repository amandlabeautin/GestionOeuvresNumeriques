package fr.projectdescartes.web;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;


@Entity
public class Telechargement {

	
	private long id;
	
	@Column(name="DATE_DE_TELECHARGEMENT")
	private Date dateDeTelechargement;
	
	@Column(name="TELECHARGEMENT_CLIENT")
	private Client client;

	public Telechargement() {
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

	@Temporal(TemporalType.DATE)
	public Date getDateDeTelechargement() {
		return dateDeTelechargement;
	}

	public void setDateDeTelechargement(Date dateDeTelechargement) {
		this.dateDeTelechargement = dateDeTelechargement;
	}

	@OneToOne
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}