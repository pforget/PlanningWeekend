package TAA.entities;


import java.io.Serializable;

public class Weather implements Serializable {
	

/*public enum Sunshine {

	FortementEnsoleillé,
	Ensoleillé,
	NuageuxAvecEclaircissement,
	FortementNuageux,
	Pluvieux,
	Neige,
	Grêle,
	Gel; 
    HourlyDatadata:
    "Nuit nuageuse" "Stratus se dissipant"
    "Nuit claire et stratus" "Stratus"
    "Nuit claire" "Faiblement nuageux" 	"Ensoleillé" "Eclaircies" "Nuit bien dégagée" "Nuit légèrement voilée"
}*/
		
	public Weather(float temperature, float wind, String sunshine, String icon) {
		this.temperature = temperature;
		this.wind = wind;
		this.sunshine = sunshine;
		this.icon = icon;
	}

	private float temperature;
	
	private float wind;
	
	private String sunshine;
	
	private String icon;
	

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

	public String getSunshine() {
		return sunshine;
	}

	public void setSunshine(String sunshine) {
		this.sunshine = sunshine;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}


