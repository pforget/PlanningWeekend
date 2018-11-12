package TAA.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import TAA.entities.City;
import TAA.entities.CityPK;
@Transactional
public interface CityDao extends JpaRepository<City, String>{
	public List<City> findBycityPK(CityPK id);
}
