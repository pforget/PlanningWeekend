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

import TAA.Dao.DepartmentDao;
import TAA.Dao.LocationDao;
import TAA.entities.Department;
import TAA.entities.Location;

@RestController
@Transactional
@RequestMapping("/locationService")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class LocationService {
	@Autowired
	private LocationDao dao;
	@RequestMapping("/Alllocations")
	@ResponseBody
	public List<Location> AllLocations() {
		return dao.findAll();
	}  
	
	@PostMapping("/location/add")
	public void saveLocation(@RequestBody Location l) {
		 dao.save(l);
	}
	@GetMapping(value = "/id/{id}")
    public Location getLocation(@PathVariable("id") int id) {
		 return dao.findById(id);
    }
	@DeleteMapping("/location/delete")
	    public void deleteLocation(@RequestBody Location l) {
	        dao.delete(l);    }
	
}
