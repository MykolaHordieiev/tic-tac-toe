package com.tictactoe.app.dto;

import lombok.Data;

@Data
public class TurnDto {
    private Long gameId;
    private int turn;
}
