package com.nagarro.restfull.databse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.restfull.entity.Employee;
import com.nagarro.restfull.repository.EmployeeRepository;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	 @Bean
	  CommandLineRunner initDatabase(EmployeeRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "india","jba2hba.com", new java.util.Date(System.currentTimeMillis()))));
	      log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "bhutan","jhb@hbh.com", new java.util.Date(System.currentTimeMillis()))));
	    };
	  }
	
}
