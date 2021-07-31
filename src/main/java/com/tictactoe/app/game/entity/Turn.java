package com.tictactoe.app.game.entity;

import lombok.Data;

@Data
public class Turn {

    private int turn;

    @Override
    public String toString() {
        return String.valueOf(this.turn);
    }
}
