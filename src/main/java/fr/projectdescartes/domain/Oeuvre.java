package fr.projectdescartes.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="oeuvre")
@DiscriminatorColumn
(
 name="Discriminator",
 discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="O")
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
	
	@Column(name="resume", length=2000, columnDefinition="LONGTEXT")
    String resume;
	
	@Column(name="image")
	String image;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    		name = "genre_oeuvre", 
    		joinColumns = @JoinColumn(name = "oeuvre_id", referencedColumnName = "id"), 
    		inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
	@JsonBackReference("oeuvre_genre") 
	Collection<Genre> genres;
	
	@OneToMany(mappedBy = "oeuvre", cascade = CascadeType.ALL)
	Collection<Download> downloads;
	
    public Oeuvre() {
	}
    
	public Oeuvre(Date dateDeParution, String titre, String resume, String image, Collection<Genre> genres, Collection<Download> downloads) {
		this.dateDeParution = dateDeParution;
		this.titre = titre;
		this.resume = resume;
		this.image = image;
		this.genres = genres;
		this.downloads = downloads;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOeuvre == null) ? 0 : idOeuvre.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oeuvre other = (Oeuvre) obj;
		if (idOeuvre == null) {
			if (other.idOeuvre != null)
				return false;
		} else if (!idOeuvre.equals(other.idOeuvre))
			return false;
		return true;
	}
    
}