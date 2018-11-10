package TAA.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import TAA.entities.Proposition;
import TAA.entities.SportPK;
import TAA.entities.Location;
import TAA.entities.Sport;
@Transactional
public interface PropositionDao extends JpaRepository<Proposition, Long>{
	@Query("select p from Proposition as p where p.sport = :sport and p.location = :location")
	public Proposition findByID(Sport s, Location l);
	
}
