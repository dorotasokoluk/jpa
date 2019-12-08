package io.mbab.sda.sdajpa17;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
public class SdaJpa17Application {

	public static void main(String[] args) {
		SpringApplication.run(SdaJpa17Application.class, args);
	}
	@Bean
	public Jackson2ObjectMapperBuilder configureObjectMapper() {
		return new Jackson2ObjectMapperBuilder()
				.modulesToInstall(Hibernate5Module.class);
	}

}
