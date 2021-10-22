package com.example.demo.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger: librería para la generación de la documentación de la API REST
 * 
 * http://localhost:8080/swagger-ui/ --> HTML
 * http://localhost:8080/v2/api-docs -- JSON
 */
@Configuration // anotacion para todas las clases spring de configuracion
@EnableSwagger2
public class SwaggerConfig {
	

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private ApiKey apiKey(){
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }
    
	
	@Bean // permite que spring invoque este método para obtener un objeto que inyectar donde lo necesite
	public Docket api() {
		
	      return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiDetails())
	                .securityContexts(Arrays.asList(securityContext()))
	                .securitySchemes(Arrays.asList(apiKey()))
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build();
	}
	

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
    
	private ApiInfo apiDetails() {

		return new ApiInfo("Awesome API REST", 
				"Pruebas Spring Boot API REST", 
				"1.0", 
				"http://localhost/terms", 
				new Contact("Prueba","Prueba","Prueba"),
				"Prueba",
				"Prueba",
				 Collections.emptyList());
	}
	
	

}
