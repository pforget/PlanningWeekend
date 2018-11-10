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

import TAA.Dao.CityDao;
import TAA.Dao.ConditionDao;
import TAA.entities.City;
import TAA.entities.Condition;

@RestController
@Transactional
@RequestMapping("/conditionService")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class ConditionService {
	@Autowired
	private ConditionDao dao;
	@RequestMapping("/Allcondition")
	@ResponseBody
	public List<Condition> AllConditions() {
		return dao.findAll();
	}  
	
	@PostMapping("/condition/add")
	public void saveCondition(@RequestBody Condition c) {
		 dao.save(c);
	}
	@GetMapping(value = "/id/{id}")
    public Condition getCondition(@PathVariable("id") int id) {
        @SuppressWarnings("unchecked")
		Optional<Condition> condition = (Optional<Condition>) ConditionDao.findById(id);
        return condition.get();
    }
	@DeleteMapping("/condition/delete")
	    public void deleteCondition(@RequestBody Condition c) {
	        dao.delete(c);    }
	
}