package TAA.Dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import TAA.entities.User;
import TAA.entities.Location;
import TAA.entities.Sport;
@Transactional
public interface UserDao extends JpaRepository<User, Long>{

    @Query(" select u from User u " +
            " where u.username = ?1")
    Optional<User> findUserWithName(String username);

	
}
