package com.tictactoe.app.game;

import com.tictactoe.app.dto.StartGameDTO;
import com.tictactoe.app.dto.TurnDTO;
import com.tictactoe.app.game.entity.Game;
import com.tictactoe.app.game.entity.ResponseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;
    private final ResponseImpl response;

    @GetMapping("/tic-tac-toe")
    public String welcome() {
        return "Welcome to 3x3 Tic Tac Toe. Please enter person's login who will play";
    }

    @PostMapping("/tic-tac-toe/start")
    public ResponseImpl startGame(@RequestBody StartGameDTO startGameDTO) {
        Game game = gameService.startGame(startGameDTO);
        response.setGameId(game.getId());
        response.setState(game.getState());
        response.setBoard(game.getBoard());
        return response;
    }

    @PostMapping("/turn")
    public ResponseImpl requiredTurn(@RequestBody TurnDTO turnDTO) {
        Game game = gameService.turn(turnDTO);
        response.setGameId(game.getId());
        response.setState(game.getState());
        response.setBoard(game.getBoard());
        return response;
    }


}
