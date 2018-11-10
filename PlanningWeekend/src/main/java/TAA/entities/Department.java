package TAA.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Department implements Serializable {
	
	public Department(int id, String name, Region regionId, List<City> cities) {
		super();
		this.id = id;
		this.name = name;
		this.regionId = regionId;
		this.cities = cities;
	}

	public Department() {
		
	}

	private int id;
	
	private String name;
	
	private Region regionId;
	
	
	private List<City> cities;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	public Region getRegionId() {
		return regionId;
	}

	public void setRegionId(Region regionId) {
		this.regionId = regionId;
	}
	
	@Transient
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}

