package com.tictactoe.app.game.entity;

import lombok.Data;

@Data
public class State {
    private Long id;
    private String description;
    private String requiredTurn;
}
