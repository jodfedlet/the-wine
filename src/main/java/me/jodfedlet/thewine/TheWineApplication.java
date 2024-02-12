package me.jodfedlet.thewine;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "The Wine API", version = "1.0", description = "The Wine API"))
public class TheWineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheWineApplication.class, args);
	}

}
