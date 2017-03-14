package fr.projectdescartes;

import javax.persistence.Entity ; 
import javax.persistence.Id ; 
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;
/**
 * 
 */
@Entity
public class Auteur {

	Long idAuteur;
	String nomAuteur;
    
    public Auteur(Long idAuteur, String nomAuteur) {
		super();
		this.idAuteur = idAuteur;
		this.nomAuteur = nomAuteur;
	}


	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Long idAuteur) {
		this.idAuteur = idAuteur;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}
}