package TAA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;

import TAA.Dao.UserDao;
import TAA.entities.Location;
import TAA.entities.Sport;
import TAA.entities.User;


@SpringBootApplication
public class PlanningWeekendApplication implements CommandLineRunner{
@Autowired
UserDao userDao;
	public static void main(String[] args) {
		SpringApplication.run(PlanningWeekendApplication.class, args);
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("ADMIN");
		user.setPassword("ADMIN");

		userDao.save(user);
}
}
