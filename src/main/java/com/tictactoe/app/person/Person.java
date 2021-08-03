package com.tictactoe.app.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Long id;
    private String login;
    private String firsName;
    private String lastName;
    private int age;
}
