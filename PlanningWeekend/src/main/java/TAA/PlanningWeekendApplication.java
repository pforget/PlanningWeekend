package TAA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;

import TAA.entities.Location;
import TAA.entities.Sport;
import TAA.entities.User;


@SpringBootApplication
public class PlanningWeekendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanningWeekendApplication.class, args);
	}
}
