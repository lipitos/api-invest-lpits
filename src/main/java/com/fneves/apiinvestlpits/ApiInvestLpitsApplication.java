package com.fneves.apiinvestlpits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Link Aplicação Heroku -> https://api-financas-lptis.herokuapp.com/  */
@SpringBootApplication
@EnableSwagger2
public class ApiInvestLpitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiInvestLpitsApplication.class, args);
	}

	@Bean
	public Docket allApi() {
		//Adding Header
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("Authorization").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
		List<Parameter> aParameters = new ArrayList<>();
		aParameters.add(aParameterBuilder.build());

		Set<String> protocols = new HashSet<>();
		protocols.add("http");
		protocols.add("https");

		return new Docket(DocumentationType.SWAGGER_2).host("localhost:8080")
				.groupName("All")
				.apiInfo(apiInfo())
				.select()
				.paths(PathSelectors.any())
				.build()
				.protocols(protocols)
				.ignoredParameterTypes(ApiIgnore.class)
				.enableUrlTemplating(true).globalOperationParameters(aParameters);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Controle de Investimentos")
				.description("Sistema de Controle de investimentos")
				.termsOfServiceUrl("http://localhost:8080")
				.license("")
				.licenseUrl("http//localhost:8080")
				.version("2.0")
				.build();
	}
}
