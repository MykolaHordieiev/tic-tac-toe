package com.tictactoe.app.person;

import com.tictactoe.app.dto.PersonDto;
import com.tictactoe.app.person.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapperFromDTOtoPerson mapperFromDTOtoPerson;

    public Person insertPerson(PersonDto personDTO) {
        Long id = personRepository.savePerson(personDTO);
        return mapperFromDTOtoPerson.getPersonFromSaveDTO(personDTO, id);
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
