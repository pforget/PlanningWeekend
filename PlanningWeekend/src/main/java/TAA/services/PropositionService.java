package TAA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import TAA.Dao.PropositionDao;
import TAA.entities.Location;
import TAA.entities.Proposition;
import TAA.entities.Sport;

@RestController
@Transactional
@RequestMapping("/PropositionService")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PropositionService {
	@Autowired
	private PropositionDao dao;
	@RequestMapping("/AllPropositions")
	@ResponseBody
	public List<Proposition> AllPropositions() {
		return dao.findAll();
	}  
	
	@PostMapping("/Proposition/add")
	public void saveProposition(@RequestBody Proposition p) {
		 dao.save(p);
	}
	@GetMapping(value = "/id/{id}")
    public Proposition getProposition(Sport s, Location l) {
		 return dao.findByID(s,l);
    }
	@DeleteMapping("/Proposition/delete")
	    public void deleteProposition(@RequestBody Proposition p) {
	        dao.delete(p);    }
	
}
