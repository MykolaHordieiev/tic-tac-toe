package com.tictactoe.app.person.repo;

import com.tictactoe.app.person.Person;
import com.tictactoe.app.dto.PersonDTO;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    List<Person> getAllPerson();

    Optional<Person> getPersonById(Long id);

    Long savePerson(PersonDTO personDTO);

    Optional<Person> getPersonByLogin(String login);
}