package TAA.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import TAA.entities.Sport;
@Transactional
public interface SportDao<level> extends JpaRepository<Sport, String>{
	@Query("select s from Sport as s where s.sportPK.name = :name and s.sportPK.level = :level")
	public Sport find(String name, level level);
}
