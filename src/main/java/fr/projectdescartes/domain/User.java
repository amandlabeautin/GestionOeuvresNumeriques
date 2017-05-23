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
	private Collection<Download> downloads;
	
	@NotNull
	private boolean isAdmin;
	
	public User(String username, String password,
			Collection<Download> telechargements, boolean isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.downloads = telechargements;
		this.isAdmin = isAdmin;
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
    
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

	/**
	 * @return the downloads
	 */
	public Collection<Download> getDownloads() {
		return downloads;
	}

	/**
	 * @param downloads the downloads to set
	 */
	public void setDownloads(Collection<Download> downloads) {
		this.downloads = downloads;
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