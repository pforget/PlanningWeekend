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

import TAA.Dao.ConditionDao;
import TAA.Dao.DepartmentDao;
import TAA.entities.Condition;
import TAA.entities.Department;

@RestController
@Transactional
@RequestMapping("/departmentService")
//@Api(value= "PersonServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class DepartmentService {
	@Autowired
	private DepartmentDao dao;
	@RequestMapping("/Alldepartment")
	@ResponseBody
	public List<Department> AllConditions() {
		return dao.findAll();
	}  
	
	@PostMapping("/department/add")
	public void saveDepartment(@RequestBody Department d) {
		 dao.save(d);
	}
	@GetMapping(value = "/id/{id}")
    public Department getDepartment(@PathVariable("id") int id) {
		 return dao.findById(id);
    }
	@DeleteMapping("/department/delete")
	    public void deleteDepartment(@RequestBody Department d) {
	        dao.delete(d);    }
	
}
