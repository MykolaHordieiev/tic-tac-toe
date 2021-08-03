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
import java.util.function.Predicate;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class Play {

    private final CheckWinner checkWinner;
    private final ConfigGame configGame;
    private final Map<String, State> stateMap;

    public Game startGame(Person person1, Person person2) {
        return configGame.startNewGame(person1, person2);
    }

    public Game turn(Game game, TurnDTO turnDTO) {
        checkGameIsOver(game);

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
            boolean isDraw = game.getResult().keySet().stream()
                    .anyMatch(key -> key.equals("draw"));
            if (isDraw) {
                game.setState(stateMap.get("draw"));
            } else {
                game.setState(stateMap.get("haveWinner"));
            }
            game.setIsPlaying(false);
            return game;
        }
        return game;
    }

    private boolean checkGameIsOver(Game game) {
        return Stream.of(game).map(Game::getIsPlaying)
                .findFirst()
                .filter(aBoolean -> aBoolean.equals(true))
                .orElseThrow(() -> new RuntimeException("Game is over"));
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
