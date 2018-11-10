package TAA.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import TAA.entities.Weather;

public interface WeatherDao extends JpaRepository<Weather, Long>{
	@Query("select w from Weather as w")
	public Weather findByID(int id);
}
