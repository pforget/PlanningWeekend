package TAA.swagger;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2

@ComponentScan(basePackages="TAA.services")
@Configuration

public class SwaggerConfig
{    
	private static final String SWAGGER_API_VERSION= "1.0";
	private static final String LICENSE_TEXT= "license";
	private static final String title= " REST API";
	private static final String description= "Restfull API ";    
	private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title(title)
            .description(description)
            .license(LICENSE_TEXT)
            .version(SWAGGER_API_VERSION)                
            .build();
	}    
	@Bean
	public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            
            .select()
            .apis(RequestHandlerSelectors.basePackage("TAA.services"))
            
            .build()
            .consumes(new HashSet<String>(Arrays.asList("application/json")))
            .produces(new HashSet<String>(Arrays.asList("application/json")));    }}