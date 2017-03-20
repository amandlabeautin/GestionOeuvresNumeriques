package fr.projectdescartes;


import javax.persistence.Entity ;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
/**
 * 
 */
@Entity
public class Livre extends Oeuvre {

	private Long id;
    private Integer nbreDePages;
	
	public Livre(Long id, Integer nbreDePages) {
		super();
		this.id = id;
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