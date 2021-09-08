package com.tictactoe.app.game.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Data
public class Game {
    private Long id;
    private Player player1;
    private Player player2;
    private Board board;
    private State state;
    private Boolean isPlaying;
    private Map<String, Optional<Player>> result;
}
