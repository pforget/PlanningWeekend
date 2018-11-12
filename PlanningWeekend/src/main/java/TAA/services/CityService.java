package TAA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
import TAA.entities.City;

@RestController
@Transactional
@RequestMapping("/City")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class CityService {
	@Autowired
	private CityDao dao;
	@RequestMapping("/All")
	@ResponseBody
	public List<City> AllCities() {
		return dao.findAll();
	}  
	
	@PostMapping("/add")
	public void saveCity(@RequestBody City c) {
		 dao.save(c);
	}
/*	@RequestMapping("/Citybypostalcode")
	@ResponseBody
	public List<City> CityByPostalCode(int postalCode) {
		return dao.findByPostalCode(postalCode);
	}*/
	@DeleteMapping("/delete")
	    public void deleteCity(@RequestBody City c) {
	        dao.delete(c);    }
/*	@GetMapping(value = "/name/{name}")
    public List<City> findByname(@PathVariable("name") String name) {
        return dao.findByName(name);
    }*/
}
