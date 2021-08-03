package com.tictactoe.app.game.entity;

import lombok.Data;

@Data
public class Board {

    private final String[] board;

    public Board(String[] board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return board[0] + board[1] + board[2] +
                board[3] + board[4] + board[5] +
                board[6] + board[7] + board[8];
    }

//    @Override
//    public String toString() {
//        return "|---|---|---|" + "\n" +
//                "| " + board[0] + " | " + board[1] + " | " + board[2] +
//                " |" + "\n" +
//                "|-----------|" + "\n" +
//                "| " + board[3] + " | " + board[4] + " | " + board[5] +
//                " |" + "\n" +
//                "|-----------|" + "\n" +
//                "| " + board[6] + " | " + board[7] + " | " + board[8] +
//                " |" + "\n" +
//                "|---|---|---|" + "\n";
//    }
}
