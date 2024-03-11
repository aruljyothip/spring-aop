package com.springpoc.aop.springaop.business;

import com.springpoc.aop.springaop.data.Dao1;
import com.springpoc.aop.springaop.jdbc.PersonJdbcDAO;
import com.springpoc.aop.springaop.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Business1 {

    @Autowired
    private Dao1 dao1;

    @Autowired
    private PersonJdbcDAO personJdbcDAO;
    public String calculateSomething(){
        return dao1.retriveSomething();
    }

    public List<Person> getAllPerson(){
        return personJdbcDAO.getAllPerson();
    }

    public Person getPersonById(int id){
        return personJdbcDAO.getPersonById(id);
    }

    public int deletePersonById(int id){
        return personJdbcDAO.deletePersonById(id);
    }

    public int addPerson(Person person){
        return personJdbcDAO.addPerson(person);
    }

    public List<Person> getPersons(){
        return personJdbcDAO.getAllPersonUsingCustomMapper();
    }

}
