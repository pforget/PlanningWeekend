package TAA.services;

import java.util.List;
import java.util.Optional;

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

import TAA.Dao.SportDao;
import TAA.entities.Location;
import TAA.entities.Proposition;
import TAA.entities.Sport;

@RestController
@Transactional
@RequestMapping("/sportService")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class SportService<level> {
	
	@Autowired
	private SportDao<level> dao;
	@RequestMapping("/AllSport")
	@ResponseBody
	public List<Sport> AllSports() {
		return dao.findAll();
	}  
	
	@PostMapping("/sport/add")
	public void saveSport(@RequestBody Sport s) {
		 dao.save(s);
	}
	@GetMapping(value = "/id/{id}")
    public Object getSport(String name, level level) {
		 return dao.find(name,level);
    }
	@DeleteMapping("/Sport/delete")
	    public void deleteSport(@RequestBody Sport s) {
	        dao.delete(s);    }
	
}
