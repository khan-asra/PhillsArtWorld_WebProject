package ca.sheridancollege.khanasr.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.beans.factory.annotation.*;




/**
 * A container for CORS configuration along with methods to check against the actual origin, 
 * HTTP methods, and headers of a given request. 
 * @author asra.k
 * Sep. 27, 2022
 */
@Configuration
public class CorsConfiguration {

	private static final String GET = "GET";
	private static final String POST = "POST";
	private static final String PUT = "PUT";
	private static final String DELETE = "DELETE";

	
	private static final String[] ALLOWED_ORIGINS = {"https://localhost:4200","https://localhost:9090"}; 
	
	/**
	 * Defines callback methods to customize 
	 * the Java-based configuration for Spring MVC enabled via @EnableWebMvc. 
	 * @return WebMvcConfigurer
	 */
	
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
        	
        	
        	//@Override
            public void addCorsMappings(CorsRegistry registry) {
            	
                registry
                .addMapping("/**")
                .allowedOrigins(ALLOWED_ORIGINS)           
                
                       .allowedMethods(GET, POST, PUT, DELETE)
                        .allowedHeaders("*")
                        .allowedOriginPatterns("*")
                     //   .allowCredentials(true);     
            	     .exposedHeaders("Authorization");
     
            }
        };
    
}
}