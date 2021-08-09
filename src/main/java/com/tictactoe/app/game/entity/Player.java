package com.tictactoe.app.game.entity;

import lombok.Data;

@Data
public class Player {
    private String login;

    @Override
    public String toString() {
        return this.getLogin();
    }

}
