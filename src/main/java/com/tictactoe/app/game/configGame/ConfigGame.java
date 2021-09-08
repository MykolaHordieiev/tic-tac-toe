package com.tictactoe.app.game.configGame;

import com.tictactoe.app.game.entity.*;
import com.tictactoe.app.game.entity.State;
import com.tictactoe.app.person.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@RequiredArgsConstructor
@Component
public class ConfigGame {

    private final ConfigPlayers configPlayers;
    private final ConfigBoard configBoard;
    private final ConfigState configState;

    public Game startNewGame(Person person1, Person person2) {
        Player player1 = configPlayers.getPlayerByPerson(person1);
        Player player2 = configPlayers.getPlayerByPerson(person2);
        Board board = configBoard.configBoardWhenStartGame();
        State state = configState.getStateByDescription(GameEnums.START_GAME.name());
        return getGame(player1, player2, board, state, true);
    }

    public Game getGameFromDB(String login1, String login2, String strBoard, String strState, boolean playing) {
        Player player1 = configPlayers.getPlayerByLogin(login1);
        Player player2 = configPlayers.getPlayerByLogin(login2);
        Board board = configBoard.configBoardFromDB(strBoard);
        State state = configState.getStateByDescription(strState);
        return getGame(player1, player2, board, state, playing);
    }

    private Game getGame(Player player1, Player player2, Board board, State state, boolean isPlaying) {
        Game game = new Game();
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setBoard(board);
        game.setState(state);
        game.setIsPlaying(isPlaying);
        game.setResult(new HashMap<>());
        return game;
    }
}
