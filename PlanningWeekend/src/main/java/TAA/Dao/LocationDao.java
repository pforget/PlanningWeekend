package TAA.Dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import TAA.entities.Location;

public interface LocationDao extends JpaRepository<Location, Long>{
	public Location findById(@Param("id") int id);
}
