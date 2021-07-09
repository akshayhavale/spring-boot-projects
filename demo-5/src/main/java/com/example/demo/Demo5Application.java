package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@ComponentScan ({"com.example.demo", "com.example.demo.domain"})
public class Demo5Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		log.info("PromoplanAggregatorApplication starts----------");
		SpringApplication app = new SpringApplication(Demo5Application.class);
		app.setWebApplicationType(WebApplicationType.REACTIVE);
		Environment env = app.run(args).getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\thttp://localhost:{}\n" +
						"----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				env.getProperty("server.port"));
	}
}
