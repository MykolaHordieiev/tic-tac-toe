package com.tictactoe.app.game.entity;

import lombok.Data;

@Data
public class WinningCombination {
    private Long id;
    private int firstFieldNumber;
    private int secondFieldNumber;
    private int thirdFieldNumber;
}
