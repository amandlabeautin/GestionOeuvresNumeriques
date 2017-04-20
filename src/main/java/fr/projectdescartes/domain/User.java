package fr.projectdescartes.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity ; 
import javax.persistence.Id ;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue ; 
import javax.persistence.GenerationType ;
/**
 * 
 */
@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long idClient;
	
	@NotNull
	@Column(name="user_login")
	private String nomClient;
	
	@NotNull
	@Column(name="user_mail")
	private String adresseMailClient;
	
	@NotNull
	@Column(name="user_password")
	transient private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Collection<Telechargement> downloads;
	
	
	public User(String nomClient, String adresseMailClient, String password,
			Collection<Telechargement> telechargements) {
		super();
		this.nomClient = nomClient;
		this.password = password;
		this.adresseMailClient = adresseMailClient;
		this.downloads = telechargements;
	}

	public User() {
		
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
		return downloads;
	}

	public void setTelechargements(Collection<Telechargement> telechargements) {
		this.downloads = telechargements;
	}

}