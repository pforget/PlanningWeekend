package TAA.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import TAA.entities.City;
import TAA.entities.CityPK;
@Transactional
public interface CityDao extends JpaRepository<City, String>{
	@Query("select c from City as c where c.cityPK.name = :name")
	public List<City> findByName(String name);
	public List<City> findBycityPK(CityPK id);
}
