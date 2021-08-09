package com.tictactoe.app.person;

import com.tictactoe.app.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping("/save")
    public Person addPerson(@RequestBody PersonDto personDTO) {
        return personService.insertPerson(personDTO);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/get/{login}")
    public Person getPersonByLogin(@PathVariable String login) {
        return personService.getPersonByLogin(login);
    }

    @GetMapping("/all")
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }
}
