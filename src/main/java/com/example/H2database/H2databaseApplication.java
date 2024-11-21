package com.example.H2database;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration

@Slf4j
public class H2databaseApplication {
   //Logger log= (Logger) LoggerFactory.getLogger(H2databaseApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(H2databaseApplication.class, args);
		log.info("Info level");
		log.error("error level");
		log.debug("debug level");
		log.warn("warn level");
	}
}
