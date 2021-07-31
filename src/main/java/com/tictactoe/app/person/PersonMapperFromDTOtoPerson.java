package com.tictactoe.app.person;

import com.tictactoe.app.dto.PersonDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperFromDTOtoPerson {

    public Person getPersonFromSaveDTO(PersonDTO dto, Long id) {
        Person person = new Person();
        person.setId(id);
        person.setLogin(dto.getLogin());
        person.setFirsName(dto.getFirsName());
        person.setLastName(dto.getLastName());
        person.setAge(dto.getAge());
        return person;
    }
}