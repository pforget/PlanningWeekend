package TAA.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import TAA.entities.Sport;
@Transactional
public interface SportDao<level> extends JpaRepository<Sport, String>{
	@Query("select s from Sport as s where s.name = :name")
	public Sport findBylevel(String name, level level);
}
