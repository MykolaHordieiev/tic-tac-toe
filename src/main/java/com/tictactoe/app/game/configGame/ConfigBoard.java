package com.tictactoe.app.game.configGame;

import com.tictactoe.app.game.entity.Board;
import com.tictactoe.app.game.entity.Field;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ConfigBoard {
    public Board configBoardWhenStartGame() {
        return new Board(getFieldList());
    }

    private List<Field> getFieldList() {
        List<Field> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(new Field(String.valueOf(i + 1)));
        }
        return fields;
    }

    public Board configBoardFromDB(String board) {
        List<Field> fields = new ArrayList<>();
        String[] split = board.split("");
        Arrays.stream(split).forEach(s -> fields.add(new Field(s)));
        return new Board(fields);
    }
}
