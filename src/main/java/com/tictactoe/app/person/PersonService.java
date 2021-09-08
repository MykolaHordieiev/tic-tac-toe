package com.tictactoe.app.person;

import com.tictactoe.app.dto.PersonDto;
import com.tictactoe.app.person.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public Person insertPerson(PersonDto personDto) {
        Person person = personMapper.getEntityFromDto(personDto);
         return personRepository.savePerson(person);
    }

    public Person getPersonById(Long id) {
        return personRepository.getPersonById(id).orElseThrow(() -> new RuntimeException("person not found"));
    }

    public Person getPersonByLogin(String login) {
        return personRepository.getPersonByLogin(login)
                .orElseThrow(() -> new RuntimeException("Person with login: " + login + " not found"));
    }

    public List<Person> getAllPerson() {
        return personRepository.getAllPerson();
    }
}
