package TAA.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

																																																												

@Entity
public class User implements Serializable, UserDetails {
	
	public User(int id, String name, List<Sport> favoriteSports, List<Location> favoriteLocations) {
		super();
		this.id = id;
		this.name = name;
		this.favoriteSports = favoriteSports;
		this.favoriteLocations = favoriteLocations;
	}
	private int id;
	private String username;
	private String password;
	private String email;

	private String name;
	
	private List<Sport> favoriteSports;
    
    private List<Location> favoriteLocations;
    
    private List<Proposition> propositions;
	
    public User() {
    }

    
	@Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


//	@Column(nullable = false)
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Sport> getFavoriteSports() {
		return favoriteSports;
	}

	public void setFavoriteSports(List<Sport> favoriteSports) {
		this.favoriteSports = favoriteSports;
	}

	@ManyToMany
	@JsonIgnore
	public List<Location> getFavoriteLocations() {
		return favoriteLocations;
	}

	public void setFavoriteLocations(List<Location> favoriteLocations) {
		this.favoriteLocations = favoriteLocations;
	}

	@ManyToMany
	  @JoinTable(name = "User_Proposition",
      joinColumns = @JoinColumn(name = "User_id"),
      inverseJoinColumns = @JoinColumn(name = "Proposition_id")
  )
	@JsonIgnore
	public List<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}


	@Override
	@Transient
	public java.util.Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transient
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	@Transient
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	@Transient
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}

