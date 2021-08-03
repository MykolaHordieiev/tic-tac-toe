package com.tictactoe.app.game;

import com.tictactoe.app.dto.StartGameDTO;
import com.tictactoe.app.dto.TurnDTO;
import com.tictactoe.app.game.entity.Game;
import com.tictactoe.app.person.Person;
import com.tictactoe.app.person.repo.PersonRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Data
public class GameService {

    private final PersonRepository personRepository;
    private final Play play;
    private final GameRepository gameRepository;

    public Game startGame(StartGameDTO startGameDTO) {
        Person person1 = getPersonByLogin(startGameDTO.getLogin1());
        Person person2 = getPersonByLogin(startGameDTO.getLogin2());
        Game game = play.startGame(person1, person2);
        game.setId(gameRepository.saveGame(game));
        return game;
    }

    public Game turn(TurnDTO turnDTO) {
        Game game = gameRepository.getGameById(turnDTO.getGameId()).orElseThrow(
                () -> new RuntimeException("game not found")
        );
        Game updatedGame = play.turn(game, turnDTO);
        return gameRepository.updateGame(updatedGame);
    }

    public Person getPersonByLogin(String login) {
        return personRepository.getPersonByLogin(login)
                .orElseThrow(() -> new RuntimeException("Person with login: " + login + " not found"));
    }


}
