package fr.projectdescartes.web;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;
/**
 * 
 */
@Entity
public class Client {

	private long idClient;
	
	@Column(name="NOM_USER")
	private String nomClient;
	
	@Column(name="MAIL_USER")
	private String adresseMailClient;
	
	@Column(name="PASSWORD_USER")
	transient private String password;
	
	private Collection<Telechargement> telechargements;
	
	
	public Client(long idClient, String nomClient, String adresseMailClient,
			Collection<Telechargement> telechargements) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresseMailClient = adresseMailClient;
		this.telechargements = telechargements;
	}

	public Client() {
		
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy="Client")
	public Collection<Telechargement> getTelechargements() {
		return telechargements;
	}

	public void setTelechargements(Collection<Telechargement> telechargements) {
		this.telechargements = telechargements;
	}

}