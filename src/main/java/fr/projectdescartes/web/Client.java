package fr.projectdescartes;

import java.util.Collection;

import javax.persistence.Entity ; 
import javax.persistence.Id ; 
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;
/**
 * 
 */
@Entity
public class Client {

	private long idClient;
	private String nomClient;
	private String adresseMailClient;
	private Collection<Telechargement> telechargements;
	
	
	public Client(long idClient, String nomClient, String adresseMailClient,
			Collection<Telechargement> telechargements) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresseMailClient = adresseMailClient;
		this.telechargements = telechargements;
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

	public Collection<Telechargement> getTelechargements() {
		return telechargements;
	}

	public void setTelechargements(Collection<Telechargement> telechargements) {
		this.telechargements = telechargements;
	}

}