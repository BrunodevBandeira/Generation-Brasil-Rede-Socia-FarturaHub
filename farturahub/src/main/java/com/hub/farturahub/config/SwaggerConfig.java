package com.hub.farturahub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.hub.farturahub.Controller")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Fartura Hub").description("API do Projeto Fartura Hub").version("1.0")
				.contact(contact()).build();
	}

	private Contact contact() {
		return new Contact("Bruno,Giulliana,Murilo,Nayane,Stephany,Thales",
				"https://github.com/BrunodevBandeira/Generation-Brasil-Rede-Socia-FarturaHub/tree/Secuirty",
				"Estudantes - Grupo 4");
	}

}
