package fr.projectdescartes;

import javax.persistence.Entity ; 
import javax.persistence.Id ; 
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;
/**
 * 
 */
@Entity
public class Client {

	long idClient;
	String nomClient;
	String adresseMailClient;
	
	public Client(long idClient, String nomClient, String adresseMailClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresseMailClient = adresseMailClient;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdClient() {
		return idClient;
	}
	
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	
	public String getNomClient() {
		return nomClient;
	}
	
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	
	public String getAdresseMailClient() {
		return adresseMailClient;
	}
	public void setAdresseMailClient(String adresseMailClient) {
		this.adresseMailClient = adresseMailClient;
	}

}