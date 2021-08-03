package com.tictactoe.app.game.state;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:states/states.properties")
public class HaveWinner implements State {
    @Value("${state.havewinner.state}")
    private String state;
    @Value("${state.havewinner.requiredturn}")
    private String requiredTurn;
    private String winner;

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String requiredTurn() {
        return this.requiredTurn;
    }
}
