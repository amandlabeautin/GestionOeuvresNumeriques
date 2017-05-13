package fr.projectdescartes.domain;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="download")
public class Commande {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column(name="dateDeCommande")
	private Date dateDeCommande;
	
	@Column(name="isvalidate")
	private boolean isvalidate;
	
	@Column(name="isdownload")
	private boolean isdownload;
	
	@Column(name="dateDeTelechargement")
	private Date dateDeTelechargement;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@NotNull
	@ManyToMany(mappedBy = "downloads")
	@JsonManagedReference("oeuvre_download")
	private Collection<Oeuvre> oeuvres;
	
	
	public Commande() {
	}

	/**
	 * @param id
	 * @param dateDeCommande
	 * @param isvalidate
	 * @param isdownload
	 * @param dateDeTelechargement
	 * @param user
	 * @param oeuvres
	 */
	public Commande(long id, Date dateDeCommande, boolean isvalidate, boolean isdownload, Date dateDeTelechargement,
			User user, Collection<Oeuvre> oeuvres) {
		this.id = id;
		this.dateDeCommande = dateDeCommande;
		this.isvalidate = isvalidate;
		this.isdownload = isdownload;
		this.dateDeTelechargement = dateDeTelechargement;
		this.user = user;
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

	/**
	 * @param e
	 * @return
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean add(Oeuvre e) {
		return oeuvres.add(e);
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

	/**
	 * @return the dateDeCommande
	 */
	@Temporal(TemporalType.DATE)
	public Date getDateDeCommande() {
		return dateDeCommande;
	}

	/**
	 * @param dateDeCommande the dateDeCommande to set
	 */
	public void setDateDeCommande(Date dateDeCommande) {
		this.dateDeCommande = dateDeCommande;
	}

	/**
	 * @return the isvalidate
	 */
	public boolean isIsvalidate() {
		return isvalidate;
	}

	/**
	 * @param isvalidate the isvalidate to set
	 */
	public void setIsvalidate(boolean isvalidate) {
		this.isvalidate = isvalidate;
	}

	/**
	 * @return the isdownload
	 */
	public boolean isIsdownload() {
		return isdownload;
	}

	/**
	 * @param isdownload the isdownload to set
	 */
	public void setIsdownload(boolean isdownload) {
		this.isdownload = isdownload;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}