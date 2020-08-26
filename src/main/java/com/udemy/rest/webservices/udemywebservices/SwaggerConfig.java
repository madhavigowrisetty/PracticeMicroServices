package com.udemy.rest.webservices.udemywebservices;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2

//To configure support for Swagger UI with Spring Boot 2, we need to extend the class WebMvcConfigurationSupport and add two resource handlers
public class SwaggerConfig extends WebMvcConfigurationSupport {
    //creating this variable becaus eit is passed as arg in the ApiInfo
    public static final Contact DEFAULT_CONTACT = new Contact("Madhavi Gowrisetty", "www.madhavienv.com", "madhavi.gowrisetty@citi.com");
    //declaring this variable to pass in apiInfo method for swagger
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Swagger Api Documentation", "This swagger has User and Hello world service details", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    private static final Set<String> DEFAULT_P_C = new HashSet<String>(Arrays.asList("application/json","application/xml"));


    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_P_C).consumes(DEFAULT_P_C);
    }
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
