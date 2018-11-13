package TAA.entities;


import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Condition implements Serializable {
	
	private int id;
	private double minTemperature;
//	private double minPluviometry;
	private double minWindCondition;
	private double maxWindCondition;
	private double maxTemperature;
//	private double maxPluviometry;
	private ArrayList<String> toleratedSunshine;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int identifier) {
		this.id = identifier;
	}
	
	public double getMinTemperature() {
		return minTemperature;
	}
	public void setMinTemperature(double minTemperature) {
		this.minTemperature = minTemperature;
	}
	
/*
	public double getMinPluviometry() {
		return minPluviometry;
	}
	public void setMinPluviometry(double minPluviometry) {
		this.minPluviometry = minPluviometry;
	}
*/
	
	public double getMinWindCondition() {
		return minWindCondition;
	}
	public void setMinWindCondition(double minWindCondition) {
		this.minWindCondition = minWindCondition;
	}
	
	public double getMaxWindCondition() {
		return maxWindCondition;
	}
	public void setMaxWindCondition(double maxWindCondition) {
		this.maxWindCondition = maxWindCondition;
	}
	
	public double getMaxTemperature() {
		return maxTemperature;
	}
	public void setMaxTemperature(double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}
	
/*
	public double getMaxPluviometry() {
		return maxPluviometry;
	}
	public void setMaxPluviometry(double maxPluviometry) {
		this.maxPluviometry = maxPluviometry;
	}
*/
	
	@Column(nullable = false)
	public ArrayList<String> getToleratedSunshine() {
		return toleratedSunshine;
	}
	public void setToleratedSunshine(ArrayList<String> toleratedSunshine) {
		this.toleratedSunshine = toleratedSunshine;
	}
	
	public boolean isFulfilled(Weather weather) {
		double temperature = weather.getTemperature();
		double windSpeed = weather.getWind();
		String sunshine = weather.getSunshine();
		
		return
				temperature >= minTemperature
				&& temperature <= maxTemperature
				&& windSpeed >= minWindCondition
				&& windSpeed <= maxWindCondition
				&& toleratedSunshine.contains(sunshine)
				;
	}


}


