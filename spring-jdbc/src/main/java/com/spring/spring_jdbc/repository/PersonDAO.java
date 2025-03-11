package com.spring.spring_jdbc.repository;

import com.spring.spring_jdbc.model.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAO {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired //Dependency injection
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void addPerson(Person person){

        String sql = "INSERT INTO person (id, name, age) VALUES (?, ?, ?)";
        template.update(sql, person.getId(), person.getName(), person.getAge());
    }

    public List<Person> findAllPersons(){

        String sql = "SELECT * FROM person";

        //Row mapper returns data from the db row by row one at a time and return them into a array list
        RowMapper mapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                //To get the data from db in form of objects involves:

                //Create new person
                Person person = new Person();

                //Assign row by row id, name and age into person object which is to be returned by mapping it from the db using rs
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setAge(rs.getInt("age"));

                return person;
            }
        };


        //Note: we could have also converted the above code into lambda expression like below for making it shorter
        /*
        RowMapper<Person> mapper = (rs, rowNum) -> {

            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setAge(rs.getInt("age"));

            return person;
        };
        */

        List<Person> personArrayList = template.query(sql, mapper);
        return personArrayList;
    }
}
