package com.tictactoe.app.game;

import com.tictactoe.app.dto.TurnDTO;
import com.tictactoe.app.game.configGame.ConfigGame;
import com.tictactoe.app.game.entity.Board;
import com.tictactoe.app.game.entity.Game;
import com.tictactoe.app.game.state.State;
import com.tictactoe.app.person.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class Play {

    private final CheckWinner checkWinner;
    private final ConfigGame configGame;
    private final Map<String, State> stateMap;

//    public static void main(String[] args) {
//        ConfigBoard configBoard = new ConfigBoard();
//        ConfigPlayers configPlayers = new ConfigPlayers();
//        Person person1 = new Person(1L, "one", "one_first", "one_last", 23);
//        Person person2 = new Person(2L, "two", "two_first", "two_last", 26);
//        Player player1 = configPlayers.getPlayer(person1);
//        Player player2 = configPlayers.getPlayer(person2);
//        Game game = new Game(player1, player2, new Turn(), new Board(configBoard.board().getBoard()));
//        Play play =
//                new Play(new CheckWinner(game, new HashMap<>()));
//        play.playTheGame(game);
//    }

    public Game startGame(Person person1, Person person2) {
        return configGame.startNewGame(person1, person2);
    }

    public Game turn(Game game, TurnDTO turnDTO) {
        if (game.getIsPlaying()) {
            String turn = game.getState().requiredTurn();
            int numInput = turnDTO.getTurn().getTurn();
            Board board = game.getBoard();
            checkCorrespondenceTurn(numInput);
            if (board.getBoard()[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board.getBoard()[numInput - 1] = turn;
                if (turn.equals("X")) {
                    game.setState(stateMap.get("requiredTurnO"));
                } else {
                    game.setState(stateMap.get("requiredTurnX"));
                }
                game.setBoard(board);
            } else {
                throw new RuntimeException("Slot already taken; re-enter slot number:");
            }
            if (checkFinishedGame(game)) {
                String drawOrWin = checkWinner.drawOrWin(game);
                if (drawOrWin.equalsIgnoreCase("draw")) {
                    game.setState(stateMap.get(drawOrWin));
                } else {
                    game.setState(stateMap.get("haveWinner"));
                }
                game.setIsPlaying(false);
                return game;
            }
            return game;
        }
        throw new RuntimeException("Game is over");
    }

    private boolean checkCorrespondenceTurn(int numInput) {
        if (!(numInput > 0 && numInput <= 9)) {
            throw new RuntimeException("Invalid input; re-enter slot number:");
        }
        return true;
    }

    private boolean checkFinishedGame(Game game) {
        return checkWinner.checkWinnerMethod(game).isPresent();
    }

}
