package TAA.Dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import TAA.entities.City;
import TAA.entities.Location;

public interface LocationDao extends JpaRepository<Location, Long>{
	public Location findById(@Param("id") int id);
	
	@Query("select l from Location as l where l.city.cityPK.name = :name")
	public Location findByCityName(@Param("name") String cityName);
	
	@Query("select l from Location as l where l.city.cityPK.name = :name and l.city.cityPK.postalCode = :cp")
	public Location findByCity(@Param("name") String name, @Param("cp") int cp);
	
}