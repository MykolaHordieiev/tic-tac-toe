package com.tictactoe.app.person.repo;

import com.tictactoe.app.person.Person;
import com.tictactoe.app.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PersonRepoImpl implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> getAllPerson() {
        String getAllPerson = "SELECT * FROM person";
        return jdbcTemplate.query(getAllPerson, resultSet -> {
            List<Person> list = new ArrayList<>();
            while (resultSet.next()) {
                Person person = new Person();
                person.setFirsName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setAge(resultSet.getInt("age"));
                list.add(person);
            }
            return list;
        });
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        String getPerson = "SELECT * FROM person WHERE person.id=" + id;
        return jdbcTemplate.query(getPerson, resultSet -> {
            if (resultSet.next()) {
                Person person = new Person();
                person.setId(id);
                person.setLogin(resultSet.getString("login"));
                person.setFirsName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setAge(resultSet.getInt("age"));
                return Optional.of(person);
            }
            return Optional.empty();
        });
    }

    @Override
    public Person savePerson(Person person) {
        String insertPerson = "INSERT INTO person (first_name,last_name,age,login) VALUES (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertPerson, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, person.getFirsName());
            ps.setString(2, person.getLastName());
            ps.setInt(3, person.getAge());
            ps.setString(4, person.getLogin());
            return ps;
        }, keyHolder);
        person.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return person;
    }

    @Override
    public Optional<Person> getPersonByLogin(String login) {
        String getPerson = "SELECT * FROM person WHERE login='" + login + "'";
        return jdbcTemplate.query(getPerson, resultSet -> {
            if (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setFirsName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setAge(resultSet.getInt("age"));
                person.setLogin(login);
                return Optional.of(person);
            }
            return Optional.empty();
        });
    }
}
