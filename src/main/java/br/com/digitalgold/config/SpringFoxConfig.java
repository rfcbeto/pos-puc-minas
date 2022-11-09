package br.com.digitalgold.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@EnableSwagger2
public class SpringFoxConfig {
	
	/*
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.roberto"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	*/
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.digitalgold"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	
	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title("Digital Gold APP")
				.description("Aplicação para trabalho de conclusão de curso pos graduação PUC Minas")
				.termsOfServiceUrl("http://localhost:8081")
				.license("")
				.licenseUrl("http://localhost:8081")
				.version("1.0")
				.build();
	}
	

}
