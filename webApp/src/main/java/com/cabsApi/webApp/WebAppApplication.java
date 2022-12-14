package com.cabsApi.webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebAppApplication {
	String firstName = "Yan";
	String lastName = "Chang";
	String gender = "Male";

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(StudentRepository repository){
//		return args ->{
//			Student student = new Student(
//					firstName,
//					lastName,
//					gender
//			);
//			repository.insert(student);
//		};
//	}
}

