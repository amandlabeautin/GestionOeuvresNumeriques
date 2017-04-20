package fr.projectdescartes.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
	
}