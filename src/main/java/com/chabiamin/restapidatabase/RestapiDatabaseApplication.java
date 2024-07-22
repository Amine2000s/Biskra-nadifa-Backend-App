package com.chabiamin.restapidatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


@SpringBootApplication
public class RestapiDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiDatabaseApplication.class, args);
	}


	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/*"))
				.apis(RequestHandlerSelectors.basePackage("com.chabiamin.restapidatabase"))
				.build()
				.apiInfo(apiCustomData());
	}

	private ApiInfo apiCustomData(){
		return new ApiInfo(
				"Biskra Nadifa API Application",
				"Biskra Nadifa Api's Documentation",
				"1.0",
				"Biskra Nadifa Terms",
				new Contact("Chabi Amine ", "https://github.com/Amine2000s",
						"chabiaminesifeedine@gmail.com "),
				" ",
				" ",
				Collections.emptyList()
		);
	}


}
