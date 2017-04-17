package fr.projectdescartes.web;

import javax.persistence.Column;
import javax.persistence.Entity ; 
import javax.persistence.Id ; 
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;


@Entity
public class Genre {

	private long idGenre;
	
	@Column(name="NOM_GENRE")
	private String nomGenre;
	
	public Genre() {
		
	}
	
	public Genre(long idGenre, String nomGenre) {
		super();
		this.idGenre = idGenre;
		this.nomGenre = nomGenre;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
	
}