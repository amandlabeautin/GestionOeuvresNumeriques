package fr.projectdescartes.domain;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="download")
public class Telechargement {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column(name="date")
	private Date dateDeTelechargement;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@ManyToMany(mappedBy = "downloads")
	private Collection<Oeuvre> oeuvres;
	
	
	public Telechargement() {
	}
	
	/**
	 * @param id
	 * @param dateDeTelechargement
	 * @param client
	 * @param oeuvre
	 */
	public Telechargement(Date dateDeTelechargement, User client, Collection<Oeuvre> oeuvres) {
		this.dateDeTelechargement = dateDeTelechargement;
		this.user = client;
		this.oeuvres = oeuvres;
	}

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
	public User getClient() {
		return user;
	}

	public void setClient(User client) {
		this.user = client;
	}

	/**
	 * @return the oeuvres
	 */
	public Collection<Oeuvre> getOeuvres() {
		return oeuvres;
	}

	/**
	 * @param oeuvres the oeuvres to set
	 */
	public void setOeuvres(Collection<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}

}