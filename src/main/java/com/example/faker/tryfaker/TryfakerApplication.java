package com.example.faker.tryfaker;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TryfakerApplication {       
        
        @Bean
        Faker faker(){
        return new Faker(); 
        }
    
	public static void main(String[] args) {
		SpringApplication.run(TryfakerApplication.class, args);
                System.out.println("running now....");
	}

}
