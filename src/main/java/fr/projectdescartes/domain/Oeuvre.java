package fr.projectdescartes.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="oeuvre")
public abstract class Oeuvre {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	Long idOeuvre;
	
	@Column(name = "dateDeParution")
	@Temporal(TemporalType.DATE)
    Date dateDeParution;
	
	@NotNull
	@Column(name="titre")
    String titre;
	
	@Column(name="resume")
    String resume;
	
	@Column(name="image")
	String image;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "genre_oeuvre", joinColumns = @JoinColumn(name = "oeuvre_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
	Collection<Genre> genres;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "oeuvre_download", joinColumns = @JoinColumn(name = "oeuvre_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "download_id", referencedColumnName = "id"))
	Collection<Telechargement> downloads;
	
    public Oeuvre() {
	}
    
	public Oeuvre(Date dateDeParution, String titre, String resume, String image, Collection<Genre> genres, Collection<Telechargement> downloads) {
		this.dateDeParution = dateDeParution;
		this.titre = titre;
		this.resume = resume;
		this.image = image;
		this.genres = genres;
		this.downloads = downloads;
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

	/**
	 * @return the genres
	 */
	public Collection<Genre> getGenres() {
		return genres;
	}

	/**
	 * @param genres the genres to set
	 */
	public void setGenres(Collection<Genre> genres) {
		this.genres = genres;
	}
	
	/**
	 * @param e
	 * @return
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean add(Genre e) {
		return genres.add(e);
	}
    
}