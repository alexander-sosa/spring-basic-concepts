package bo.edu.ucb.ingsoft.serverless.dao;

import bo.edu.ucb.ingsoft.serverless.dto.Person;

public class PersonMysql implements PersonStore {
    public PersonMysql(){

    }

    @Override
    public void persistPerson(Person person){
        System.out.println("Guardando en MySQL");
    }

    @Override
    public void deletePerson(Person person) {
        System.out.println("Eliminando en MySQL");
    }

    @Override
    public Person findByName(String name) {
        System.out.println("Buscando en MySQL");
        return null;
    }
}
