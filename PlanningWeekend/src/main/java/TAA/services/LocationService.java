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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import TAA.Dao.DepartmentDao;
import TAA.Dao.LocationDao;
import TAA.entities.City;
import TAA.entities.Department;
import TAA.entities.Location;

@RestController
//@Transactional
@RequestMapping("/locationService")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class LocationService {
	@Autowired
	private LocationDao dao;
	@RequestMapping(value="/all",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Location> AllLocations() {
		return dao.findAll();
	}  
	
	@PostMapping("/add")
	public void saveLocation(@RequestBody Location l) {
		 dao.save(l);
	}
	@GetMapping(value = "/{id}")
    public Location getLocation(@PathVariable("id") String id) {
		 return dao.findOne(Long.valueOf(id));
    }
	@DeleteMapping("/delete")
	    public void deleteLocation(@RequestBody Location l) {
	        dao.delete(l);    }
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Location getByCityName(String cityName) {
		return dao.findByCityName(cityName);
	}
	
	public Location getByCity(City city) {
		return dao.findByCity(city.getName(), city.getPostalCode());
	}
	

}
