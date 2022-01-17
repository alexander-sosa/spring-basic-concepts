package bo.edu.ucb.ingsoft.serverless;

import bo.edu.ucb.ingsoft.serverless.dao.PersonStore;
import bo.edu.ucb.ingsoft.serverless.dto.Person;

public class PersonBL {
    private PersonStore personStore;

    public PersonBL(PersonStore personStore) {
        this.personStore = personStore;
    }

    public void mainLogic(){
        Person person = personStore.findByName("Juan");
        personStore.deletePerson(person);
    }
}
