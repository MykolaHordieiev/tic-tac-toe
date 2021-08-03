package com.tictactoe.app.game.configGame;

import com.tictactoe.app.person.Person;
import com.tictactoe.app.game.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class ConfigPlayers {

    public Player getPlayerByPerson(Person person) {
        Player player = new Player();
        player.setLogin(person.getLogin());
        return player;
    }

    public Player getPlayerByLogin(String login){
        Player player = new Player();
        player.setLogin(login);
        return player;
    }
}
