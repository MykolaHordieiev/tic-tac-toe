package com.tictactoe.app.game.configGame;

import com.tictactoe.app.game.state.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigStatesMap {

    @Bean
    public Map<String, State> statesMap(StartGame startGame, RequiredTurnX requiredTurnX,
                                        RequiredTurnO requiredTurnO, HaveWinner haveWinner,
                                        Draw draw) {
        Map<String, State> statesMap = new HashMap<>();
        statesMap.put("startGame", startGame);
        statesMap.put("requiredTurnX", requiredTurnX);
        statesMap.put("requiredTurnO", requiredTurnO);
        statesMap.put("haveWinner", haveWinner);
        statesMap.put("draw", draw);
        return statesMap;
    }
}
