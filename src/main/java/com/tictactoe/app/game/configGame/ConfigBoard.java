package com.tictactoe.app.game.configGame;

import com.tictactoe.app.game.entity.Board;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ConfigBoard {

    public Board configBoardWhenStartGame() {
        String[] boardArr = getBoardArray();
        return new Board(boardArr);
    }

    public Board configBoardFromDB(String board) {
        String[] split = board.split("");
        String[] boardArr = new String[9];
        System.arraycopy(split, 0, boardArr, 0, 9);
        return new Board(boardArr);
    }

    private String[] getBoardArray() {
        String[] boardArr = new String[9];
        for (int i = 0; i < 9; i++) {
            boardArr[i] = String.valueOf(i + 1);
        }
        return boardArr;
    }
}
