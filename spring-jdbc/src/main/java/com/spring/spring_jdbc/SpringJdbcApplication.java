package com.spring.spring_jdbc;

import com.spring.spring_jdbc.model.entity.Person;
import com.spring.spring_jdbc.repository.PersonDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@Scope("prototype") //So the spring creates different objects when we call getBean() so that we do not work around with a single object in our db
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		Person p1 = context.getBean(Person.class);
		p1.setId(112);
		p1.setName("Abhay");
		p1.setAge(22);

		PersonDAO repo = context.getBean(PersonDAO.class);
		repo.addPerson(p1);

		System.out.println(repo.findAllPersons());
	}

}
