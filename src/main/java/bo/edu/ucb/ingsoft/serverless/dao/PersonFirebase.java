package bo.edu.ucb.ingsoft.serverless.dao;

import bo.edu.ucb.ingsoft.serverless.dto.Person;

public class PersonFirebase implements PersonStore {
    public PersonFirebase(){

    }

    @Override
    public void persistPerson(Person person){
        System.out.println("Guardando en Firebase...");
    }

    @Override
    public void deletePerson(Person person) {
        System.out.println("Elminando en Firebase...");
    }

    @Override
    public Person findByName(String name) {
        System.out.println("Buscando en Firebase...");
        return null;
    }
}
