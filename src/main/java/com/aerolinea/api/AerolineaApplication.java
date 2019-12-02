package com.aerolinea.api;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AerolineaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AerolineaApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.aerolinea.api.rest"))
				.paths(PathSelectors.regex("api/v1.*")).build().useDefaultResponseMessages(false).apiInfo(apiInfo());
	}

	public ApiInfo apiInfo() {
		return new ApiInfo("", "Documentacion de las Apis Rest", "1.0", "", new Contact("", "", ""), "", "",
				Collections.emptyList());
	}

}
