package hello.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@ComponentScan({ "hello.thymeleaf.controller", "hello.thymeleaf.models" })
//@EnableAutoConfiguration
@SpringBootApplication
public class HelloThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloThymeleafApplication.class, args);
	}

}
