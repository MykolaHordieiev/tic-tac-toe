package com.tictactoe.app.game.state;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:states/states.properties")
public class Draw implements State {
    @Value("${state.draw.state}")
    private String state;
    @Value("${state.draw.requiredturn}")
    private String requiredTurn;

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String requiredTurn() {
        return this.requiredTurn;
    }
}
