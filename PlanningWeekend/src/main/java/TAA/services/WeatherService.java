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

import TAA.Dao.WeatherDao;
import TAA.entities.Region;
import TAA.entities.Weather;

@RestController
@Transactional
@RequestMapping("/WeatherService")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class WeatherService {
	@Autowired
	private WeatherDao dao;
	@RequestMapping("/AllWeathers")
	@ResponseBody
	public List<Weather> AllWeathers() {
		return dao.findAll();
	}  
	
	@PostMapping("/Weather/add")
	public void saveWeather(@RequestBody Weather w) {
		 dao.save(w);
	}
	@GetMapping(value = "/id/{id}")
    public Weather getWeather(@PathVariable("id") int id) {
		 return dao.findByID(id);
    }
	@DeleteMapping("/Weather/delete")
	    public void deleteWeather(@RequestBody Weather w) {
	        dao.delete(w);    }
	
}


