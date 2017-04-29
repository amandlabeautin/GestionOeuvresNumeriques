package fr.projectdescartes.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;


@Entity
@Table(name="genre")
public class Genre {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long idGenre;
	
	@NotNull
	@Column(name="genre_nom")
	private String nomGenre;

	@ManyToMany(mappedBy = "genres")
	@JsonManagedReference("oeuvre_genre")
	private Collection<Oeuvre> oeuvres;
	
	public Genre() {
		
	}
	
	public Genre(long idGenre, String nomGenre, Collection<Oeuvre> oeuvres) {
		super();
		this.idGenre = idGenre;
		this.nomGenre = nomGenre;
		this.oeuvres = oeuvres;
	}
	
	public long getIdGenre() {
		return idGenre;
	}
	
	public void setIdGenre(long idGenre) {
		this.idGenre = idGenre;
	}
	
	public String getNomGenre() {
		return nomGenre;
	}
	
	public void setNomGenre(String nomGenre) {
		this.nomGenre = nomGenre;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Genre [idGenre=" + idGenre + ", nomGenre=" + nomGenre + ", oeuvres=" + oeuvres + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idGenre ^ (idGenre >>> 32));
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
		Genre other = (Genre) obj;
		if (idGenre != other.idGenre)
			return false;
		return true;
	}
	
}