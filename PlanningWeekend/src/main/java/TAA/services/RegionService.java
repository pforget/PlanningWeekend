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

import TAA.Dao.RegionDao;
import TAA.entities.Location;
import TAA.entities.Region;

@RestController
//@Transactional
@RequestMapping("/Regions")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class RegionService {
	@Autowired
	private RegionDao dao;
	@RequestMapping(value="/all",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Region> Allregions() {
		return dao.findAll();
	}  
	
	@PostMapping("/add")
	public void saveRegion(@RequestBody Region c) {
		 dao.save(c);
	}
	/*@GetMapping(value = "/person/{name}")
    public boolean existsByName(@PathVariable("nameame") String name) {
        return dao.existByName(name);
    }*/
	@DeleteMapping("/delete")
	    public void deleteRegion(@RequestBody Region c) {
	        dao.delete(c);    }
	@GetMapping(value = "/{name}")
    public List<Region> findByname(@PathVariable("name") String name) {
        return dao.findByName(name);
    }
}
