package se.aymeric.microservices.core.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("se.aymeric")
public class CourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseServiceApplication.class, args);
	}

}
