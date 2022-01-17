package bo.edu.ucb.ingsoft.serverless;

import bo.edu.ucb.ingsoft.serverless.dao.PersonFirebase;
import bo.edu.ucb.ingsoft.serverless.dao.PersonMysql;
import bo.edu.ucb.ingsoft.serverless.dao.PersonStore;
import bo.edu.ucb.ingsoft.serverless.dto.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerlessApplication {

	@Value("${myapp.store}")
	private String store;

	@Bean
	PersonStore personStore(){
		if("mysql".equals(store))
			return new PersonMysql();
		else
			return new PersonFirebase();
	}

	@Bean
	public PersonBL personBL(PersonStore personStore){
		return new PersonBL(personStore);
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(ServerlessApplication.class, args);

		// High Cohesion 1: Interface
		PersonStore personStore = new PersonFirebase();
		personStore.persistPerson(new Person("Juan", "Perez"));

		// High Cohesion 2: Inversion of Control with Environment Variable (throws exception)
		// 1. Compile -> ./mvnw clean package
		// 2. ./mvnw spring-boot:run -D spring-boot.run.arguments=bo.edu.ucb.ingsoft.serverless.dao.PersonMysql
		/*
		PersonStore personStore2 = (PersonStore) Class.forName(args[0]).newInstance();
		personStore2.persistPerson(new Person("juan", "perez"));
		*/

		// High Cohesion 3: Dependency Injection
		// Check Beans ;)
		PersonBL personBL = context.getBean(PersonBL.class);
		personBL.mainLogic();
	}

}
