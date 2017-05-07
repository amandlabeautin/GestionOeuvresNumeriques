package fr.projectdescartes.domain;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
/**
 * 
 */
@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column(name="username")
	private String username;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Collection<Telechargement> downloads;
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
	      name="user_role",
	      joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	      inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
	private Collection<Role> roles;
	
	public User(String username, String password,
			Collection<Telechargement> telechargements) {
		super();
		this.username = username;
		this.password = password;
		this.downloads = telechargements;
	}

	public User() {
		
	}
	
	/**
	 * @return the idClient
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

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

	/**
	 * @return the downloads
	 */
	public Collection<Telechargement> getDownloads() {
		return downloads;
	}

	/**
	 * @param downloads the downloads to set
	 */
	public void setDownloads(Collection<Telechargement> downloads) {
		this.downloads = downloads;
	}

    /**
	 * @return the roles
	 */
	public Collection<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}