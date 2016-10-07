package com.boot.swagger.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages="com.boot.swagger")
public class SwaggerConfig {
	@Bean
	public Docket restfulApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("boot-swagger").select().paths(paths()).build()
				.apiInfo(apiInfo());
	}

	private Predicate<String> paths() {
		return or(regex("/*.*"), regex("/*.*"));
	}

	private ApiInfo apiInfo() {

		ApiInfo apiInfo = new ApiInfo("Spring Boot Swagger", "Spring Boot Swagger", "1.0", "http://localhost:8080",
				"chandan.1241@gmail.com", "Licence", "something");
		return apiInfo;
	}

}
