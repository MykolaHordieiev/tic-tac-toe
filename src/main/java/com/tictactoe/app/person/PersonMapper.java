package com.tictactoe.app.person;

import com.tictactoe.app.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public Person getEntityFromDto(PersonDto dto) {
        Person person = new Person();
        person.setLogin(dto.getLogin());
        person.setFirsName(dto.getFirsName());
        person.setLastName(dto.getLastName());
        person.setAge(dto.getAge());
        return person;
    }
}
