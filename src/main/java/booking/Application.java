/**
 * 
 */
package booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Gottis Konstantinos
 * @email konstantninos.gottis@gmail.com
 */
// Spring annotations
@EnableAutoConfiguration
@EnableWebMvc
@Configuration
@ComponentScan
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public BookingSvcApi bookingService(){
		return new BookingSvc();
	}
}
