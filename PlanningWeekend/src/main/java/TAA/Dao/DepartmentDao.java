package TAA.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import TAA.entities.Department;

public interface DepartmentDao extends JpaRepository<Department, String>{
	public Department findById(int id);
}
