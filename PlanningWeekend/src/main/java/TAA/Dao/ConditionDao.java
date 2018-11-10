package TAA.Dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import TAA.entities.Condition;

public interface ConditionDao extends JpaRepository<Condition, Long>{
	public static Object findById(@Param("id") int i) {
		
		return null;
	}
}
