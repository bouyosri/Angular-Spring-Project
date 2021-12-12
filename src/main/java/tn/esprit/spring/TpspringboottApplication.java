package tn.esprit.spring;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.service.ClientServiceImpl;


@EnableScheduling
@SpringBootApplication
@EnableSwagger2
public class TpspringboottApplication {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" ); 
		ClientServiceImpl c;
		SpringApplication.run(TpspringboottApplication.class, args);
	}

}
