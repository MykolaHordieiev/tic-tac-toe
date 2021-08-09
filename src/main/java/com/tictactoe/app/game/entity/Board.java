package com.tictactoe.app.game.entity;

import lombok.Data;

import java.util.List;

@Data
public class Board {
    private final List<Field> fields;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        fields.forEach(field -> sb.append(field.getValue()));
        return sb.toString();
    }
}
