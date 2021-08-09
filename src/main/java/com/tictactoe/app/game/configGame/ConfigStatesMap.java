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
        statesMap.put(startGame.getState(), startGame);
        statesMap.put(requiredTurnX.getState(), requiredTurnX);
        statesMap.put(requiredTurnO.getState(), requiredTurnO);
        statesMap.put(haveWinner.getState(), haveWinner);
        statesMap.put(draw.getState(), draw);
        return statesMap;
    }
}
