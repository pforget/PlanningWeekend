package TAA.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City implements Serializable {

	public City(String name, int PostalCode, Department departmentID) {
		this.cityPK = new CityPK(name, PostalCode);
		this.departmentID = departmentID;
	}

	@Id
	private CityPK cityPK;

	
	private Department departmentID;

	public City() {

	}

	public CityPK getCityPK() {
		return cityPK;
	}
	
	public void setCityPK(CityPK cityPK) {
		this.cityPK = cityPK;
	}

	public String getName() {
		return cityPK.getName();
	}

	public void setName(String name) {
		cityPK.setName(name);
	}

	public int getPostalCode() {
		return cityPK.getPostalCode();
	}

	public void setPostalCode(int postalCode) {
		cityPK.setPostalCode(postalCode);
	}
	
	@ManyToOne
	public Department getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Department departmentID) {
		this.departmentID = departmentID;
	}

}

