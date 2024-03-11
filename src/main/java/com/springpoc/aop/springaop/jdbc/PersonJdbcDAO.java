package com.springpoc.aop.springaop.jdbc;

import com.springpoc.aop.springaop.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {


        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthdate(rs.getTimestamp("dob"));

            return person;
        }
    }

    public List<Person> getAllPerson(){
        return jdbcTemplate.query("select * from PERSON", new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person getPersonById(int id) {
        return jdbcTemplate.queryForObject("select * from PERSON where id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public int deletePersonById(int id){
        return jdbcTemplate.update("delete from PERSON where id=?", new Object[]{id});
    }

    public int addPerson(Person person){
        return jdbcTemplate.update("INSERT INTO PERSON(id, name, location, birthdate) VALUES (?, ?, ?, ?)",
                new Object[]{person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthdate().getTime())});
    }

    public List<Person> getAllPersonUsingCustomMapper(){
        return jdbcTemplate.query("select id, name, location, birthdate as dob from PERSON", new PersonRowMapper());
    }

}
