package TAA.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import TAA.entities.Region;

public interface RegionDao extends JpaRepository<Region, String>{
	@Query ("select r from Region as r where r.name = :name")
	public List<Region> findByName(String name);
	public Boolean existByName(String name);
}
