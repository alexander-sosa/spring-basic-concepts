package bo.edu.ucb.ingsoft.serverless.dao;

import bo.edu.ucb.ingsoft.serverless.dto.Person;

public interface PersonStore {
    void persistPerson(Person person);
    void deletePerson(Person person);
    Person findByName(String name);
}
