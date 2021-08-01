package com.tictactoe.app.game.configGame;

import com.tictactoe.app.game.CheckWinner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCheckWinners {
    @Bean
    public CheckWinner configCheckWinner(ConfigWinningCombinations configWinningCombinations) {
        return new CheckWinner(configWinningCombinations);
    }
}
