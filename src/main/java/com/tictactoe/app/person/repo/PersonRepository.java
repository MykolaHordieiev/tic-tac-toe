package com.tictactoe.app.person.repo;

import com.tictactoe.app.person.Person;
import com.tictactoe.app.dto.PersonDto;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    List<Person> getAllPerson();

    Optional<Person> getPersonById(Long id);

    Person savePerson(Person person);

    Optional<Person> getPersonByLogin(String login);
}
