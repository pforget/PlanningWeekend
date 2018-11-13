package TAA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import TAA.Dao.PropositionDao;
import TAA.entities.Condition;
import TAA.entities.Location;
import TAA.entities.Proposition;
import TAA.entities.Sport;
import TAA.entities.Weather;

@RestController
//@Transactional
@RequestMapping("/Propositions")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PropositionService {
	@Autowired
	private PropositionDao dao;
	
	@Autowired
	GetMeteo getMeteo;
	
	@RequestMapping(value="/all",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Proposition> AllPropositions() {
		return dao.findAll();
	}  
	
	@PostMapping("/add")
	public void saveProposition(@RequestBody Proposition p) {
		 dao.save(p);
	}
	@GetMapping(value = "/{id}")
    public Proposition getProposition(Sport s, Location l) {
		 return dao.findByID(s,l);
    }
	@DeleteMapping("/delete")
	    public void deleteProposition(@RequestBody Proposition p) {
	        dao.delete(p);    }
	
	
	// Check the weather of all locations and
	// updates the list of available propositions
	@Scheduled(cron="0 0 12 * * 3") // Executed every wednesday at 12:00 am
	public void updateAllprop() {
		
		getMeteo.UpdateAllWeather();
		
		// TODO Wait a moment to make sure the database is fully updated
		
		List<Proposition> allPropositions = AllPropositions();
		
		for(Proposition proposition : allPropositions) {
			Weather weather = proposition.getLocation().getWeather();
			Condition condition = proposition.getSport().getWeatherCondition();
			proposition.setAvailable(condition.isFulfilled(weather));
		}
	}
	
}
