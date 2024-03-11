package com.springpoc.aop.springaop;

import com.springpoc.aop.springaop.business.Business1;
import com.springpoc.aop.springaop.business.Business2;
import com.springpoc.aop.springaop.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	@Autowired
	Business1 business1;

	@Autowired
	Business2 business2;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(business1.calculateSomething());
		logger.info(business2.calculateSomething());

		for(int i=0 ;i<business1.getAllPerson().toArray().length; i++) {
			logger.info("{}", business1.getAllPerson().toArray()[i].toString());
		}

		logger.info("Get person by id = {}", business1.getPersonById(2));

		logger.info("No of row affected when delete person by id is 2 {}", business1.deletePersonById(2));

		Person person = new Person(5,"Manoj", "Coimbatore", new Date());
		logger.info("Delete person by id = {}", business1.addPerson(person));

		logger.info("Get all persons using Custom row mapper {}", business1.getPersons());


	}
}
