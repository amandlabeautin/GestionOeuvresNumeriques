package fr.projectdescartes;

import java.util.Date;

import javax.persistence.Entity ;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
/**
 * 
 */
@Entity
public class Films extends Oeuvre {

	Long id;
	Long durée;
	String bandeAnnonce;
	
	public Films(long id, String titre, Date dateDeParution, String résumé, Long id2, Long durée, String bandeAnnonce) {
		super(id, titre, dateDeParution, résumé);
		id = id2;
		this.durée = durée;
		this.bandeAnnonce = bandeAnnonce;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public long getDurée() {
		return durée;
	}
	public void setDurée(Long durée) {
		this.durée = durée;
	}
	public String getBandeAnnonce() {
		return bandeAnnonce;
	}
	public void setBandeAnnonce(String bandeAnnonce) {
		this.bandeAnnonce = bandeAnnonce;
	}

}