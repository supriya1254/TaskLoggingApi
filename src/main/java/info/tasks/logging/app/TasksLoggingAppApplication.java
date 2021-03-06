package info.tasks.logging.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
public class TasksLoggingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksLoggingAppApplication.class, args);
	}

}
