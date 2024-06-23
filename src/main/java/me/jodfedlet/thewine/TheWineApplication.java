package me.jodfedlet.thewine;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "The Wine API", version = "1.0", description = "The Wine API"))
@SpringBootApplication
public class TheWineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheWineApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(Flyway flyway) {
		return args -> {
			flyway.migrate();
		};
	}

}
