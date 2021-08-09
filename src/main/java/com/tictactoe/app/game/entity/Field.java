package com.tictactoe.app.game.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    private String value;

    @Override
    public String toString() {
        return value;
    }
}
