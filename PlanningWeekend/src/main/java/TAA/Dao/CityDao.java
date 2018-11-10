package TAA.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import TAA.entities.City;
@Transactional
public interface CityDao extends JpaRepository<City, String>{
	public List<City> findByPostalCode(int postalCode);
	public List<City> findByName(String name);
}
