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
public class Livre extends Oeuvre {

	Long id;
    Integer nbreDePages;
	
    public Livre(long id, String titre, Date dateDeParution, String r√, Long id2, Integer nbreDePages) {
		super(id, titre, dateDeParution, r√);
		id = id2;
		this.nbreDePages = nbreDePages;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNbreDePages() {
		return nbreDePages;
	}
	public void setNbreDePages(Integer nbreDePages) {
		this.nbreDePages = nbreDePages;
	}
    
    

}