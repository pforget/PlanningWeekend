/*package TAA.services;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;

import TAA.entities.Condition;
import TAA.entities.Location;
import TAA.entities.Proposition;
import TAA.entities.Sport;
import TAA.entities.Weather;

public class UpdatePropositions {
	
	private PropositionService propositionService;
	
	private GetMeteo getMeteo;
	
	// Check the weather of all locations and
	// updates the list of available propositions
	@Scheduled(cron="0 0 12 * * 3") // Executed every wednesday at 12:00 am
	public void update() {
		
		getMeteo.UpdateAllWeather();
		
		// TODO Wait a moment to make sure the database is fully updated
		
		List<Proposition> allPropositions = propositionService.AllPropositions();
		
		for(Proposition proposition : allPropositions) {
			Weather weather = proposition.getLocation().getWeather();
			Condition condition = proposition.getSport().getWeatherCondition();
			proposition.setAvailable(condition.isFulfilled(weather));
		}
	}
	

}*/
