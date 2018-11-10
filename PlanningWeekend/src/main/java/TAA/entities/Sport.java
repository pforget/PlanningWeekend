package TAA.entities;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


enum level {Begginer,Advanced,Expert};

@Entity
public class Sport implements Serializable {
    
	@Id @GeneratedValue
    private SportPK sportPK;
    private User user;

    private Condition WeatherCondition;
    
    public Sport() {
        
    }
    
    public Sport(String name, level level, boolean needwater, boolean needmountain, Condition weatherCondition) {
        this.sportPK = new SportPK(name, level);

        WeatherCondition = weatherCondition;
    }
    
    public SportPK getSportPK() {
        return sportPK;
    }

    public void setSportPK(SportPK sportPK) {
        this.sportPK = sportPK;
    }

    public String getName() {
        return sportPK.getName();
    }

    public void setName(String name) {
        sportPK.setName(name);
    }

    @ManyToOne
    public Condition getWeatherCondition() {
        return WeatherCondition;
    }

    public void setWeatherCondition(Condition weatherCondition) {
        WeatherCondition = weatherCondition;
    }
    
    public boolean isPracticable(Weather weather) {
        return WeatherCondition.isFulfilled(weather);
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
    

}
