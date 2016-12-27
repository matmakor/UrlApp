package urlApp;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"urlApp"})
@EnableAutoConfiguration
public class Application {
	
	public static void main(String[] args) {
		 SpringApplication app = new SpringApplication(Application.class);
		    app.setBannerMode(Mode.OFF);
		    app.run(args);		
	}
}