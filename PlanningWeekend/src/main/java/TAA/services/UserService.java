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

import TAA.Dao.UserDao;
import TAA.entities.Department;
import TAA.entities.Location;
import TAA.entities.User;
import TAA.entities.Sport;

@RestController
//@Transactional
@RequestMapping("/users")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class UserService {
	@Autowired
	private UserDao dao;
	@RequestMapping(value="/all",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<User> AllUsers() {
		return dao.findAll();
	}  
	
	@PostMapping("/add")
	public void saveUser(@RequestBody User u) {
		 dao.save(u);
	}
	@GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") String id) {
		 return dao.findOne(Long.valueOf(id));
    }
	@DeleteMapping("/delete")
	    public void deleteUser(@RequestBody User u) {
	        dao.delete(u);    }
	
}

