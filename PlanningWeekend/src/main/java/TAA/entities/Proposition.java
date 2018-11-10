package TAA.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Proposition")
public class Proposition implements Serializable {
	
	@Id @GeneratedValue
	private PropositionPK propositionPK;
	private User user;
	private boolean available;
	@ManyToMany
	private List<User> users;
	
	public Proposition() {
		
	}

	public Proposition(Sport sport, Location location, boolean available) {
		this.propositionPK = new PropositionPK(sport, location);
		this.available = available;
	}
	@ManyToOne	
	public Sport getSport() {
		return propositionPK.getSport();
	}

	public void setSport(Sport sport) {
		propositionPK.setSport(sport);
	}
	@ManyToOne
	public Location getLocation() {
		return propositionPK.getLocation();
	}

	public void setLocation(Location location) {
		propositionPK.setLocation(location);
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public PropositionPK getPropositionPK() {
		return propositionPK;
	}

	public void setPropositionPK(PropositionPK propositionPK) {
		this.propositionPK = propositionPK;
	}

	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

