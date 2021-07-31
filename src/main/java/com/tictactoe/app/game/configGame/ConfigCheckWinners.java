package com.tictactoe.app.game.configGame;

import com.tictactoe.app.game.entity.Board;
import com.tictactoe.app.game.CheckWinner;
import com.tictactoe.app.game.entity.Game;
import com.tictactoe.app.game.entity.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;

@Configuration
public class ConfigCheckWinners {
    @Bean
    public CheckWinner configCheckWinner() {
        return new CheckWinner();
    }
}
