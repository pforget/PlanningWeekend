package TAA.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Weather implements Serializable {
	

public enum Sunshine {

	FortementEnsoleillé,
	Ensoleillé,
	NuageuxAvecEclaircissement,
	FortementNuageux,
	Pluvieux,
	Neige,
	Grêle,
	Gel; 

}
	
	public Weather() {
		
	}
	
	public Weather(int id, float temperature, float wind, Sunshine sunshine) {
		this.id = id;
		this.temperature = temperature;
		this.wind = wind;
		this.sunshine = sunshine;
	}

	private int id;

	private float temperature;
	
	private float wind;
	
	private Sunshine sunshine;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getWind() {
		return wind;
	}

	public void setWind(float wind) {
		this.wind = wind;
	}

	public Sunshine getSunshine() {
		return sunshine;
	}

	public void setSunshine(Sunshine sunshine) {
		this.sunshine = sunshine;
	}
	
}


